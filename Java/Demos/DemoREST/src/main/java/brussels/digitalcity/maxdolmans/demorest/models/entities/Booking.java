package brussels.digitalcity.maxdolmans.demorest.models.entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

@Entity
@Getter @Setter
@NoArgsConstructor
public class Booking {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "concerned_child")
    private Child concernedChild;

    @Column(name = "dropping_date")
    private LocalDate droppingDate;

    @Column(name = "dropping_time")
    private LocalTime droppingTime;

    @ManyToOne
    @JoinColumn(name = "dropping_guardian")
    private Guardian droppingGuardian;

    @Column(name = "pickup_date")
    private LocalDate pickupDate;

    @Column(name = "pickup_time")
    private LocalTime pickupTime;

    @ManyToOne
    @JoinColumn(name = "pickup_guardian")
    private Guardian pickupGuardian;

    private boolean cancelled = false;

    @Column(name = "cancellation_motive")
    private String cancellationMotive = null;
}
