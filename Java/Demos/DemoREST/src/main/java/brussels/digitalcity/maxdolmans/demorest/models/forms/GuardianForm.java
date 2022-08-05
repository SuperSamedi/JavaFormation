package brussels.digitalcity.maxdolmans.demorest.models.forms;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@AllArgsConstructor
public class GuardianForm {

    private String firstName;
    private String lastName;
    private String phoneNumber;
    private String address;

}
