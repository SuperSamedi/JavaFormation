package entities;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "aisle")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Aisle {
    @Id
    @Column(name = "aisle_id")
    private int id;
    @Column(name = "type")
    private String type;

    @ManyToOne
    @JoinColumn(name = "market_id")
    private Store store;
}
