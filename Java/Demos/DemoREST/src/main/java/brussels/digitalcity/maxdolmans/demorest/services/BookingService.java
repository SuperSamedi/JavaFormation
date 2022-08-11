package brussels.digitalcity.maxdolmans.demorest.services;

import brussels.digitalcity.maxdolmans.demorest.models.dtos.BookingDTO;
import brussels.digitalcity.maxdolmans.demorest.models.dtos.ChildDTO;
import brussels.digitalcity.maxdolmans.demorest.models.forms.BookingForm;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

public interface BookingService {

    BookingDTO create(BookingForm form);
    BookingDTO cancel(Long id, boolean isCancelled, String motive);
    List<ChildDTO> getAllChildrenBookedAtDate(LocalDate date);
    List<BookingDTO> getAllFutureBookingsOfChild(Long childId);
    List<BookingDTO> getAllRemainingBookingsOfCurrentMonth();
    boolean isAvailable(LocalDate date, LocalTime droppingTime, LocalTime pickupTime);

}
