package brussels.digitalcity.maxdolmans.demorest.models.entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Getter @Setter
@NoArgsConstructor
public class Booking {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @Column(name = "concerned_child")
    private Long concernedChildId;

    @Column(name = "dropping_time")
    private LocalDateTime droppingTime;

    @ManyToOne
    @Column(name = "dropping_guardian")
    private Long droppingGuardianId;

    @Column(name = "pickup_time")
    private LocalDateTime pickupTime;

    @ManyToOne
    @Column(name = "pickup_guardian")
    private Long pickupGuardianId;

    private boolean cancelled = false;

    @Column(name = "cancellation_motive")
    private String cancellationMotive = null;
}
