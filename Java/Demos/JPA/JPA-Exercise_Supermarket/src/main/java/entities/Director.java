package entities;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "director")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Director {
    @Id
    @Column(name = "director_id")
    private int id;
    @Column(name = "first_name")
    private String firstName;
    @Column(name = "last_name")
    private String lastName;
    @Column(name = "salary")
    private long salary;

    @OneToOne(mappedBy = "director")
    private Store store;
}
