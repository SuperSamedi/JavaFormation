package brussels.digitalcity.maxdolmans.demorest.models.forms;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Future;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.time.LocalTime;

@Getter @Setter
@AllArgsConstructor
public class BookingForm {

    @Future
    @NotNull
    private LocalDate date;

    @NotNull
    private LocalTime droppingTime;

    @NotNull
    private LocalTime pickupTime;

    @NotNull
    private Long concernedChildId;

    @NotNull
    private Long droppingGuardianId;

    @NotNull
    private Long pickupGuardianId;

}
