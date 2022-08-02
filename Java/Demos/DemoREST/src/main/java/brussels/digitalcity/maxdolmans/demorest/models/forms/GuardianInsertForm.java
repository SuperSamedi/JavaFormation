package brussels.digitalcity.maxdolmans.demorest.models.forms;

import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Getter @Setter
public class GuardianInsertForm {
    private String firstname;
    private String lastName;
    private String phoneNumber;
    private String address;
//    private Set<Long> childrenId;
}
