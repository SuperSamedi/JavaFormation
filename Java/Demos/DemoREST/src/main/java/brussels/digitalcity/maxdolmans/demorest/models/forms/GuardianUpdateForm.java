package brussels.digitalcity.maxdolmans.demorest.models.forms;

import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Getter @Setter
public class GuardianUpdateForm {

    private String firstName;
    private String lastName;
    private String phoneNumber;
    private String address;
    private Set<Long> childrenId;

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
