package entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "product")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Product {
    @Id
    @Column(name = "id")
    private String id;
    @Column(name = "name")
    private String name;
    @Column(name = "brand")
    private String brand;
    @Column(name = "price", columnDefinition = "DECIMAL(6,2)")
    private double price;

    @ManyToMany(mappedBy = "products")
    private Set<Market> markets = new HashSet<>();

    public Product(String id, String name, String brand, double price) {
        this.id = id;
        this.name = name;
        this.brand = brand;
        this.price = price;
    }

    @Override
    public String toString() {
        return "Product{ #" + id + ", " + name + ", " + brand + ", $" + price + " }";
    }
}
