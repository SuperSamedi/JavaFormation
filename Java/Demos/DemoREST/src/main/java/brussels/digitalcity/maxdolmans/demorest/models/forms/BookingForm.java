package brussels.digitalcity.maxdolmans.demorest.models.forms;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import javax.validation.Valid;
import javax.validation.constraints.Future;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

@Getter @Setter
@AllArgsConstructor
public class BookingForm {

    @Valid
    @NotNull
    private Long concernedChildId;

    @Future
    @NotNull
    private LocalDate droppingDate;

    @NotNull
    private LocalTime droppingTime;

    @Valid
    @NotNull
    private Long droppingGuardianId;

    @Future
    @NotNull
    private LocalDate pickupDate;

    @NotNull
    private LocalTime pickupTime;

    @Valid
    @NotNull
    private Long pickupGuardianId;

}
