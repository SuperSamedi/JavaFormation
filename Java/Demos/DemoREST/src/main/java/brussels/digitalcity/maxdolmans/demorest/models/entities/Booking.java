package brussels.digitalcity.maxdolmans.demorest.models.entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Getter @Setter
@NoArgsConstructor
public class Booking {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private LocalDate date;

    @Column(name = "dropping_time", nullable = false)
    private LocalTime droppingTime;

    @Column(name = "pickup_time", nullable = false)
    private LocalTime pickupTime;

    @ManyToOne
    @JoinColumn(name = "concerned_child", nullable = false)
    private Child concernedChild;

    @ManyToOne
    @JoinColumn(name = "dropping_guardian", nullable = false)
    private Guardian droppingGuardian;

    @ManyToOne
    @JoinColumn(name = "pickup_guardian", nullable = false)
    private Guardian pickupGuardian;

    private boolean cancelled = false;

    @Column(name = "cancellation_motive")
    private String cancellationMotive = null;
}
