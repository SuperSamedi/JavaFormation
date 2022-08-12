package brussels.digitalcity.maxdolmans.demorest.models.forms;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;

@Getter @Setter
@AllArgsConstructor
public class AppUserLoginForm {

    @NotBlank
    private String username;

    @NotBlank
    private String password;

}
