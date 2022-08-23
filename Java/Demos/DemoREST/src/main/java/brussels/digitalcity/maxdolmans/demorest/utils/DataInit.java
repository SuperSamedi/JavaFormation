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
                    "Frodo",
                    "Baggins",
                    LocalDate.of(1991, 6, 20),
                    true
            ),
            new ChildInsertForm(
                    "Aragorn",
                    "Of Isildur",
                    LocalDate.of(1993, 2, 14),
                    true
            )
    );

    private final List<GuardianForm> guardians = List.of(
            new GuardianForm(
                    "Bilbo",
                    "Baggins",
                    "063/42.47.86",
                    new AddressForm("Shire lane",1, 1000, "Hobbitbourg")
            ),

            new GuardianForm(
                    "Arwen",
                    "Evenstar",
                    "0498/65.61.49",
                    new AddressForm("High-tree Road",11, 9999, "Lothlòrien")
            ),

            new GuardianForm(
                    "Gimli",
                            "Lockbearer",
                            "02/655.61.49",
                            new AddressForm("Sword sheatheth street",51, 6699, "Helm's Deep")
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
