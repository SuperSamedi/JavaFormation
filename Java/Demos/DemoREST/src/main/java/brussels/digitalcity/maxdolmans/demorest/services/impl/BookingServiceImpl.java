package brussels.digitalcity.maxdolmans.demorest.services.impl;

import brussels.digitalcity.maxdolmans.demorest.exceptions.ElementNotFoundException;
import brussels.digitalcity.maxdolmans.demorest.exceptions.FormValidationException;
import brussels.digitalcity.maxdolmans.demorest.exceptions.UnavailableBookingException;
import brussels.digitalcity.maxdolmans.demorest.mapper.BookingMapper;
import brussels.digitalcity.maxdolmans.demorest.mapper.ChildMapper;
import brussels.digitalcity.maxdolmans.demorest.models.dtos.BookingDTO;
import brussels.digitalcity.maxdolmans.demorest.models.dtos.ChildDTO;
import brussels.digitalcity.maxdolmans.demorest.models.entities.Booking;
import brussels.digitalcity.maxdolmans.demorest.models.entities.Child;
import brussels.digitalcity.maxdolmans.demorest.models.entities.Guardian;
import brussels.digitalcity.maxdolmans.demorest.models.forms.BookingForm;
import brussels.digitalcity.maxdolmans.demorest.repositories.BookingRepository;
import brussels.digitalcity.maxdolmans.demorest.repositories.ChildRepository;
import brussels.digitalcity.maxdolmans.demorest.repositories.GuardianRepository;
import brussels.digitalcity.maxdolmans.demorest.services.BookingService;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;
import java.util.List;

@Service
public class BookingServiceImpl implements BookingService {

    private final BookingRepository repository;
    private final BookingMapper mapper;
    private final ChildRepository childRepository;
    private final GuardianRepository guardianRepository;
    private final ChildMapper childMapper;

    public BookingServiceImpl(BookingRepository repository, BookingMapper mapper, ChildRepository childRepository, GuardianRepository guardianRepository, ChildMapper childMapper) {
        this.repository = repository;
        this.mapper = mapper;
        this.childRepository = childRepository;
        this.guardianRepository = guardianRepository;
        this.childMapper = childMapper;
    }


    @Override
    public BookingDTO create(@NonNull BookingForm form) {

        if (!isAvailable(form.getDate(), form.getDroppingTime(), form.getPickupTime())) {
            throw new UnavailableBookingException(form.getDate(), form.getDroppingTime(), form.getPickupTime());
        }

        Booking booking = mapper.toEntity(form);

        booking.setConcernedChild(
                childRepository.findById(form.getConcernedChildId())
                        .orElseThrow( () -> new ElementNotFoundException(Child.class, form.getConcernedChildId()))
        );
        booking.setDroppingGuardian(
                guardianRepository.findById(form.getDroppingGuardianId())
                        .orElseThrow( () -> new ElementNotFoundException(Guardian.class, form.getDroppingGuardianId()))
        );
        booking.setPickupGuardian(
                guardianRepository.findById(form.getPickupGuardianId())
                        .orElseThrow( () -> new ElementNotFoundException(Guardian.class, form.getPickupGuardianId()))
        );

        return mapper.toDTO( repository.save( booking ) );
    }

    @Override
    public BookingDTO cancel(Long id, boolean isCancelled, String motive) {
        if (id == null || motive.isEmpty() || motive == null){
            throw new IllegalArgumentException("Error - Updated booking's ID and motive should not be null.");
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
        List<Booking> bookings = repository.findBookingsByDate(date);

        return bookings.stream()
                .filter( (b) -> !b.isCancelled())
                .map(
                        (b) -> childRepository.findById(b.getConcernedChild().getId())
                        .orElseThrow( () -> new ElementNotFoundException(Child.class, b.getConcernedChild().getId()))
                )
                .map(childMapper::toDTO)
                .toList();
    }

    @Override
    public List<BookingDTO> getAllFutureBookingsOfChild(Long childId) {
        return repository.getFutureBookingsOfChild(childId).stream()
                .map(mapper::toDTO)
                .toList();
    }

    @Override
    public List<BookingDTO> getAllRemainingBookingsOfCurrentMonth() {
        // Methode 1
        //        LocalDate endOfMonth = LocalDate.now();
//        endOfMonth = endOfMonth.withDayOfMonth(
//                LocalDate.now()
//                        .getMonth()
//                        .length(
//                                LocalDate.now()
//                                        .getChronology()
//                                        .isLeapYear(LocalDate.now().getYear())
//                        )
//        );
//        return repository.findBookingsByDroppingDateAfterAndDroppingDateBefore(LocalDate.now(), endOfMonth).stream()
//                .map(mapper::toDTO)
//                .toList();
        return repository.findRemainingCurrentMonth().stream()
                .map(mapper::toDTO)
                .toList();
    }

    @Override
    public boolean isAvailable(LocalDate date, LocalTime droppingTime, LocalTime pickupTime) {
        // Validations :
        //      form can't be null
        //      dropping time must be before pickup time
        //      dropping time must be after or at 07:00
        //      pickup time must be before or at 18:30
        //      the difference between dropping time and pick up time must be at least 30min
        //      max 1 uncancelled booking per child per day
        //      todo: there can't be more than 10 uncancelled bookings at any time during the day

        MultiValueMap<String, String> validationErrors = null;

        if (date == null || droppingTime == null || pickupTime == null){
            throw new IllegalArgumentException("Form can't be null");
        }

        if (droppingTime.isAfter(pickupTime)) {
            validationErrors = validationErrors == null ? new LinkedMultiValueMap<>() : validationErrors;
            validationErrors.add("Booking times", "Dropping time can't be set after pickup time.");
        }

        if (droppingTime.isBefore(droppingTime.withHour(7).withMinute(0))
                || pickupTime.isAfter(pickupTime.withHour(18).withMinute(30))) {
            validationErrors = validationErrors == null ? new LinkedMultiValueMap<>() : validationErrors;
            validationErrors.add("Booking times", "Dropping time and pickup time must be set between opening hour (07:00 - 18:30).");
        }

        if (ChronoUnit.MINUTES.between(droppingTime, pickupTime) < 60) {
            validationErrors = validationErrors == null ? new LinkedMultiValueMap<>() : validationErrors;
            validationErrors.add("Booking times", "Bookings can't last less than 30 minutes.");
        }

        if (validationErrors != null) {
            throw new FormValidationException(validationErrors);
        }

        return repository.checkAvailable(date, droppingTime, pickupTime);
    }

}
