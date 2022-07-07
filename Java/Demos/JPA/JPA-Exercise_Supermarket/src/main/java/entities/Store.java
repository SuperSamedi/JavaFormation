package entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;
import java.util.Set;

@Entity
@Table(name = "market")
@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Store {
    @Id
    @Column(name = "market_id")
    private int id;
    @Column(name = "market_name")
    private String name;
    @Column(name = "market_street")
    private String street;
    @Column(name = "market_city")
    private String city;
    @Column(name = "market_number")
    private int number;

    @OneToMany
    private Set<Aisle> aisles;

    @OneToOne
    private Director director;

    @ManyToMany
    private List<Product> products;
}
