package entities;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "director")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Director {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @Column(name = "firstname")
    private String firstName;
    @Column(name = "lastname")
    private String lastName;
    @Column(name = "salary", columnDefinition = "DECIMAL(8,2")
    private double salary;

    @OneToOne
    @JoinColumn(name = "market_id")
    private Market market;

    public Director(String firstName, String lastName, double salary, Market market) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.salary = salary;
        this.market = market;
    }

    @Override
    public String toString() {
        return "Director{ #" + id + ", " + firstName + ' ' + lastName + ", $" + salary + " }";
    }
}
