package brussels.digitalcity.maxdolmans.demorest.utils;

import brussels.digitalcity.maxdolmans.demorest.models.forms.AddressForm;
import brussels.digitalcity.maxdolmans.demorest.models.forms.BookingForm;
import brussels.digitalcity.maxdolmans.demorest.models.forms.ChildInsertForm;
import brussels.digitalcity.maxdolmans.demorest.models.forms.GuardianForm;
import brussels.digitalcity.maxdolmans.demorest.services.BookingService;
import brussels.digitalcity.maxdolmans.demorest.services.ChildService;
import brussels.digitalcity.maxdolmans.demorest.services.GuardianService;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

@Service
public class DataInit implements InitializingBean {

    private final ChildService childService;
    private final GuardianService guardianService;
    private final BookingService bookingService;

    public DataInit(ChildService childService, GuardianService guardianService, BookingService bookingService) {
        this.childService = childService;
        this.guardianService = guardianService;
        this.bookingService = bookingService;
    }


    private final List<ChildInsertForm> children = Arrays.asList(
            new ChildInsertForm(
                    "Max",
                    "Dolmans",
                    LocalDate.of(1991, 6, 20),
                    true
            ),
            new ChildInsertForm(
                    "Nora",
                    "Dolmans",
                    LocalDate.of(1993, 2, 14),
                    true
            )
    );

    private final List<GuardianForm> guardians = Arrays.asList(
            new GuardianForm(
                    "Christine",
                    "Herinckx",
                    "063424786",
                    new AddressForm("Rue Abraham Gilson",1, 6723, "Habay-la-Vieille")
            ),

            new GuardianForm(
                    "Michel",
                    "Dolmans",
                    "063424786",
                    new AddressForm("Rue Abraham Gilson",1, 6723, "Habay-la-Vieille")
            )
    );

    private final List <BookingForm> bookings = Arrays.asList(
            new BookingForm(
                    1L,
                    LocalDateTime.of(2022, 8, 30, 8, 15),
                    3L,
                    LocalDateTime.of(2022, 8, 30, 17, 15),
                    3L
            )
    );

    @Override
    public void afterPropertiesSet() throws Exception {
        try {
            children.forEach(childService::create);
            guardians.forEach(guardianService::create);
            bookings.forEach(bookingService::create);
        } catch (IllegalArgumentException ex) {
            System.out.println(ex.getMessage());
        }
    }
}
