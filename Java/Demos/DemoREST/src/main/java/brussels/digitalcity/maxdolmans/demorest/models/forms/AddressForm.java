package brussels.digitalcity.maxdolmans.demorest.models.forms;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;

@Getter @Setter
@AllArgsConstructor
public class AddressForm {

    @NotBlank
    @Size(max = 255)
    private String street;

    @Positive
    private int buildingNumber;

    private String apartmentCode;

    @Positive
    @NotBlank
    @Pattern(regexp = "[0-9]{4}")
    private int cityCode;

    @NotBlank
    @Size(max = 255)
    private String city;

}
