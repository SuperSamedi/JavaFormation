package brussels.digitalcity.maxdolmans.demorest.models.forms;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import javax.validation.Valid;
import javax.validation.constraints.Future;
import javax.validation.constraints.NotBlank;
import java.time.LocalDateTime;

@Getter @Setter
@AllArgsConstructor
public class BookingForm {

    @Valid
    @NotBlank
    private Long concernedChildId;

    @Future
    @NotBlank
    private LocalDateTime droppingTime;

    @Valid
    @NotBlank
    private Long droppingGuardianId;

    @Future
    @NotBlank
    private LocalDateTime pickupTime;

    @Valid
    @NotBlank
    private Long pickupGuardianId;

    private boolean cancelled;

    private String cancellationMotive;

}
