package brussels.digitalcity.maxdolmans.demorest.models.forms;

import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class AppUserForm {

    @NotBlank
    private String username;
    @NotBlank
    private String password;

}
