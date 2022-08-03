package brussels.digitalcity.maxdolmans.demorest.models.forms;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;

@Getter @Setter
public class ChildUpdateForm {

    private String firstName;
    private String lastName;
    private LocalDate dateOfBirth;
    private boolean clean;
    private List<String> allergies;
    private Set<Long> guardiansId;

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
