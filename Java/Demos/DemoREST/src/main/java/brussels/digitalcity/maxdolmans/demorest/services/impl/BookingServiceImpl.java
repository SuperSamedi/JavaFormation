package brussels.digitalcity.maxdolmans.demorest.services.impl;

import brussels.digitalcity.maxdolmans.demorest.exceptions.ElementNotFoundException;
import brussels.digitalcity.maxdolmans.demorest.exceptions.FormValidationException;
import brussels.digitalcity.maxdolmans.demorest.mapper.BookingMapper;
import brussels.digitalcity.maxdolmans.demorest.models.dtos.BookingDTO;
import brussels.digitalcity.maxdolmans.demorest.models.dtos.ChildDTO;
import brussels.digitalcity.maxdolmans.demorest.models.entities.Booking;
import brussels.digitalcity.maxdolmans.demorest.models.forms.BookingForm;
import brussels.digitalcity.maxdolmans.demorest.repositories.BookingRepository;
import brussels.digitalcity.maxdolmans.demorest.services.BookingService;
import brussels.digitalcity.maxdolmans.demorest.services.ChildService;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class BookingServiceImpl implements BookingService {

    private final BookingRepository repository;
    private final BookingMapper mapper;
    private final ChildService childService;

    public BookingServiceImpl(BookingRepository repository, BookingMapper mapper, ChildService childService) {
        this.repository = repository;
        this.mapper = mapper;
        this.childService = childService;
    }


    @Override
    public BookingDTO create(BookingForm form) {
        // Validations :
        //      form can't be null
        //      dropping time must be the same day as pickup time
        //      dropping time must be  before pickup time
        //      there can't be more than 10 uncancelled bookings per day

        MultiValueMap<String, String> validationErrors = null;

        if (form == null){
            validationErrors = new LinkedMultiValueMap<>();
            validationErrors.add("Form", "Form can't be null.");
        }

        if (form.getDroppingTime().getDayOfYear() != form.getPickupTime().getDayOfYear()) {
            validationErrors = validationErrors == null ? new LinkedMultiValueMap<>() : validationErrors;
            validationErrors.add("Booking times", "Dropping time and pickup time must be the same day.");
        }

        if (form.getDroppingTime().isAfter(form.getPickupTime())) {
            validationErrors = validationErrors == null ? new LinkedMultiValueMap<>() : validationErrors;
            validationErrors.add("Booking times", "Dropping time can't be set after pickup time.");
        }

        if( repository.findByDroppingTimeBetween( form.getDroppingTime().withHour(0) ).size() >= 10 ) {
            validationErrors = validationErrors == null ? new LinkedMultiValueMap<>() : validationErrors;
            validationErrors.add("Limit", "Booking number for this day has been reached (10).");
        }

        if (validationErrors != null) {
            throw new FormValidationException(validationErrors);
        }

        return mapper.toDTO( repository.save( mapper.toEntity(form) ) );
    }

    @Override
    public BookingDTO cancel(Long id, boolean isCancelled, String motive) {
        if (id == null){
            throw new IllegalArgumentException("Error - Updated booking's ID should not be null.");
        }

        if ( !repository.existsById(id) ) {
            throw new ElementNotFoundException(Booking.class, id);
        }

        repository.cancel(id, isCancelled, motive);

        Booking booking = repository.findById(id)
                .orElseThrow( () -> new ElementNotFoundException(Booking.class, id));

        return mapper.toDTO( booking );
    }

    @Override
    public List<ChildDTO> getAllChildrenBookedAtDate(LocalDate date) {
        LocalDateTime dateStart = date.atStartOfDay();
        LocalDateTime dateEnd = date.atTime(23,59);
        List<Booking> bookings = repository.findByDroppingTimeBetween(dateStart, dateEnd);

        return bookings.stream()
                .map((b) -> childService.getOne(b.getConcernedChildId()))
                .toList();
    }

    @Override
    public List<BookingDTO> getAllFutureBookingsOfChild(Long childId) {
        return repository.findByConcernedChildIdAndDroppingTimeAfter(childId, LocalDateTime.now()).stream()
                .map(mapper::toDTO)
                .toList();
    }

    @Override
    public List<BookingDTO> getAllRemainingBookingsOfCurrentMonth() {
        LocalDateTime endOfMonth = LocalDateTime.now();
        endOfMonth = endOfMonth.withDayOfMonth(LocalDateTime.now().getMonth().length(LocalDateTime.now().getChronology().isLeapYear(LocalDateTime.now().getYear())));
        return repository.findBookingsByDroppingTimeAfterAndDroppingTimeBefore(LocalDateTime.now(), endOfMonth).stream()
                .map(mapper::toDTO)
                .toList();
    }
}
