package brussels.digitalcity.maxdolmans.demorest.services;

import brussels.digitalcity.maxdolmans.demorest.models.dtos.BookingDTO;
import brussels.digitalcity.maxdolmans.demorest.models.dtos.ChildDTO;
import brussels.digitalcity.maxdolmans.demorest.models.dtos.GuardianDTO;
import brussels.digitalcity.maxdolmans.demorest.models.entities.Guardian;
import brussels.digitalcity.maxdolmans.demorest.models.forms.AddressForm;
import brussels.digitalcity.maxdolmans.demorest.models.forms.BookingForm;
import brussels.digitalcity.maxdolmans.demorest.models.forms.GuardianForm;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Collection;
import java.util.List;
import java.util.Set;

public interface BookingService {

    BookingDTO create(BookingForm form);
    BookingDTO cancel(Long id, boolean isCancelled, String motive);
    List<ChildDTO> getAllChildrenBookedAtDate(LocalDate date);
    List<BookingDTO> getAllFutureBookingsOfChild(Long childId);
    List<BookingDTO> getAllRemainingBookingsOfCurrentMonth();

}
