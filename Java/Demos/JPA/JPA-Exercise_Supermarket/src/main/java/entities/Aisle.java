package entities;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.IdGeneratorType;

@Entity
@Table(name = "aisle")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Aisle {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @Column(name = "type")
    private String type;

    @ManyToOne
    @JoinColumn(name = "market_id", foreignKey = @ForeignKey())
    private Market market;

    public Aisle(String type, Market market) {
        this.type = type;
        this.market = market;
    }

    @Override
    public String toString() {
        return "Aisle{ #" + id + ", " + type + " }";
    }
}
