package brussels.digitalcity.maxdolmans.demorest.models.dtos;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter @Setter
@NoArgsConstructor
public class BookingDTO {

    private Long id;
    private Long concernedChildId;
    private LocalDateTime droppingTime;
    private Long droppingGuardianId;
    private LocalDateTime pickupTime;
    private Long pickupGuardianId;
    private boolean cancelled;
    private String cancellationMotive;

}
