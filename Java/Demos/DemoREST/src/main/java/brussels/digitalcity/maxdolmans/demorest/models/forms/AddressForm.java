package brussels.digitalcity.maxdolmans.demorest.models.forms;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Embeddable;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;

@Embeddable
@Getter @Setter
@NoArgsConstructor
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

    public AddressForm(String street, int buildingNumber, int cityCode, String city) {
        this.street = street;
        this.buildingNumber = buildingNumber;
        this.cityCode = cityCode;
        this.city = city;
    }
}
