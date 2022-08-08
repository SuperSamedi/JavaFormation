package brussels.digitalcity.maxdolmans.demorest.models.forms;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.PastOrPresent;
import javax.validation.constraints.Size;
import java.time.LocalDate;

@Getter @Setter
@AllArgsConstructor
public class ChildInsertForm {

    @NotBlank
    @Size(max = 255)
    private String firstName;

    @NotBlank
    @Size(max = 255)
    private String lastName;

    // On peut modifier le message par default
    @PastOrPresent(message = "Tu es devin ou quoi ?!")
    private LocalDate dateOfBirth;

    private boolean clean = false;

}
