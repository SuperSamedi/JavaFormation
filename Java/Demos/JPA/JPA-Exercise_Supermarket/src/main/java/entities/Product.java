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
@ToString
public class Product {
    @Id
    @Column(name = "product_id")
    private String id;
    @Column(name = "product_name")
    private String name;
    @Column(name = "product_brand")
    private String brand;
    @Column(name = "product_price")
    private long price;

    @ManyToMany(mappedBy = "products")
    private Set<Store> stores = new HashSet<>();
}
