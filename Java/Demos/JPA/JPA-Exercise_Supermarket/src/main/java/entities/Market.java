package entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "market")
@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
public class Market {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @Column(name = "name")
    private String name;
    @Column(name = "street")
    private String street;
    @Column(name = "city")
    private String city;
    @Column(name = "number")
    private int number;

    @OneToOne(mappedBy = "market")
    private Director director;
    @OneToMany(mappedBy = "market")
    private Set<Aisle> aisles = new HashSet<>();
    @ManyToMany
    @JoinTable(
            name = "market_product",
            joinColumns = @JoinColumn(name = "market_id"),
            inverseJoinColumns = @JoinColumn(name = "product_id")
    )
    private List<Product> products = new ArrayList<>();

    public Market(String name, String street, String city, int number) {
        this.name = name;
        this.street = street;
        this.city = city;
        this.number = number;
    }

    @Override
    public String toString() {
        String display = "Market{" +
                "\n\t#" + id +
                "\n\tAddress{" +
                "\n\t\t" + name +
                "\n\t\t" + number + ", " + street  +
                "\n\t\t" + city +
                "\n\t}" +
                "\n\t" + director +
                "\n\tAisles{";

        for (Aisle aisle : aisles) {
            display += "\n\t\t" + aisle;
        }

        display += "\n\t}" +
                "\n\tProducts{";

        for (Product product : products) {
            display += "\n\t\t" + product;
        }

        display += "\n\t}" +
                "\n}";

        return display;
    }
}
