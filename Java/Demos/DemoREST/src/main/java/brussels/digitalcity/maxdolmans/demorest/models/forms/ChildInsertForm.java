package brussels.digitalcity.maxdolmans.demorest.models.forms;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter @Setter
public class ChildInsertForm {
    private String firstname;
    private String lastName;
    private LocalDate dateOfBirth;
    private boolean clean;
}
