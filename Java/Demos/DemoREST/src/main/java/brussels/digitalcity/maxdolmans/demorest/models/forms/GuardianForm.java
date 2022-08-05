package brussels.digitalcity.maxdolmans.demorest.models.forms;

import brussels.digitalcity.maxdolmans.demorest.models.entities.Address;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Embedded;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Getter @Setter
@AllArgsConstructor
public class GuardianForm {

    @NotBlank
    @Size(max = 255)
    private String firstName;

    @NotBlank
    @Size(max = 255)
    private String lastName;

    @NotBlank
    @Pattern(regexp = "[0-9]{2,4}\\/[0-9]{2,3}\\.[0-9]{2}\\.[0-9]{2}")
    private String phoneNumber;

    @Embedded
    @NotBlank
    private AddressForm address;

}
