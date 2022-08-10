package brussels.digitalcity.maxdolmans.demorest.models.forms;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.*;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Getter @Setter
public class ChildUpdateForm {

    @NotBlank
    @Size(max = 255)
    private String firstName;

    @NotBlank
    @Size(max = 255)
    private String lastName;

    @PastOrPresent
    private LocalDate dateOfBirth;

    private boolean clean;

    @Size(max = 10)
    @NotNull
    private List<String> allergies;

    @NotNull
    private Set<Long> guardiansId = new HashSet<>();

    // Remplacement pour le mapper
//    public Child toEntity() {
//        Child entity = new Child();
//
//        entity.setFirstName(firstName);
//        entity.setLastName(lastName);
//        entity.setDateOfBirth(dateOfBirth);
//        entity.setClean(cleanliness);
//        entity.setAllergies(allergies);
//
//        return entity;
//    }
}
