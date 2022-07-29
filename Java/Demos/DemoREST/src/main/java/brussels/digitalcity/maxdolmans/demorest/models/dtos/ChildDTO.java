package brussels.digitalcity.maxdolmans.demorest.models.dtos;

import brussels.digitalcity.maxdolmans.demorest.models.entities.Guardian;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;

@Getter @Setter
public class ChildDTO {
    private long id;
    private String firstName;
    private String lastName;
    private LocalDate dateOfBirth;
    private String cleanliness;
    private List<String> allergies;
    private Set<GuardianDTO> guardians;
}
