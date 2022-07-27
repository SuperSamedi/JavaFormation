package brussels.digitalcity.maxdolmans.demospring.entities;

import brussels.digitalcity.maxdolmans.demospring.utils.Position;
import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;
import java.time.LocalDate;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "player")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Player {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;

    @Column
    String name;

    @Column(name = "date_of_birth", columnDefinition = "DATE")
    LocalDate dateOfBirth;

    @Column(nullable = true)
    int number;

    @Column
    @Enumerated(EnumType.STRING)
    Position position;

    @Column
    double salary;


}
