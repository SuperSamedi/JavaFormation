package brussels.digitalcity.maxdolmans.demorest.models.dtos;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.time.LocalTime;

@Getter @Setter
@NoArgsConstructor
public class BookingDTO {

    private Long id;

    private ChildDTO concernedChild;

    @DateTimeFormat(pattern = "dd MMM yyyy")
    private LocalDate date;

    @DateTimeFormat(pattern = "hh:mm")
    private LocalTime droppingTime;

    @DateTimeFormat(pattern = "hh:mm")
    private LocalTime pickupTime;

    private GuardianDTO droppingGuardian;

    private GuardianDTO pickupGuardian;

    private boolean cancelled;

    private String cancellationMotive;

}
