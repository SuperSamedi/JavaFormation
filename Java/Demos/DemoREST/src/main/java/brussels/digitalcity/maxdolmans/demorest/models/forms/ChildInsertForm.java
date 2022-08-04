package brussels.digitalcity.maxdolmans.demorest.models.forms;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Getter @Setter
public class ChildInsertForm {

    private String firstName;
    private String lastName;
    private LocalDate dateOfBirth;
    private boolean clean;
    private List<String> allergies;

}
