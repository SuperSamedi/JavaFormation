package brussels.digitalcity.maxdolmans.demospring.dtos;

import brussels.digitalcity.maxdolmans.demospring.utils.Position;
import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;
import java.time.LocalDate;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class PlayerDTO {
    Long id;
    String name;
    LocalDate dateOfBirth;
    int age;
    int number;
    Position position;
    double salary;
}
