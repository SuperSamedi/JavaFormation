package brussels.digitalcity.maxdolmans.demorest.utils;

import brussels.digitalcity.maxdolmans.demorest.models.forms.*;
import brussels.digitalcity.maxdolmans.demorest.services.AppUserService;
import brussels.digitalcity.maxdolmans.demorest.services.BookingService;
import brussels.digitalcity.maxdolmans.demorest.services.ChildService;
import brussels.digitalcity.maxdolmans.demorest.services.GuardianService;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@Service
public class DataInit implements InitializingBean {

    private final ChildService childService;
    private final GuardianService guardianService;
    private final BookingService bookingService;
    private final AppUserService userService;

    public DataInit(ChildService childService, GuardianService guardianService, BookingService bookingService, AppUserService userService) {
        this.childService = childService;
        this.guardianService = guardianService;
        this.bookingService = bookingService;
        this.userService = userService;
    }


    private final List<ChildInsertForm> children = List.of(
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

    private final List<GuardianForm> guardians = List.of(
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

    private final List<BookingForm> bookings = List.of(
            new BookingForm(
                    LocalDate.of(2022, 8, 30),
                    LocalTime.of(9, 15),
                    LocalTime.of(15, 15),
                    1L,
                    3L,
                    3L
            )
    );

    private final List<AppUserCreateForm> users = List.of(
            new AppUserCreateForm(
                    "Frodo",
                    "My precious!"
            )
    );

    @Override
    public void afterPropertiesSet() throws Exception {
        try {
            children.forEach(childService::create);
            guardians.forEach(guardianService::create);
            bookings.forEach(bookingService::create);
            users.forEach(userService::create);
        } catch (IllegalArgumentException ex) {
            System.out.println(ex.getMessage());
        }
    }
}
