package brussels.digitalcity.maxdolmans.exosecurityauthtoken.forms;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;

@Getter
@Setter
@AllArgsConstructor
public class UserLoginForm {

    @NotBlank
    private String username;

    @NotBlank
    private String password;

}
