package brussels.digitalcity.maxdolmans.demorest.models.forms;

import brussels.digitalcity.maxdolmans.demorest.models.entities.Address;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.*;

@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
public class AddressForm {

    @NotBlank
    @Size(max = 255)
    private String street;

    @Positive // wroks as a not blank as well as int default value = 0
    private int buildingNumber;

    private String apartmentCode;

//    @Min(1000)
//    @Max(9999)
//    @Pattern(regexp = "[0-9]{4}")
    @Positive
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

    public Address toEntity() {
        Address entity = new Address();

        entity.setStreet(this.street);
        entity.setBuildingNumber(this.buildingNumber);
        entity.setApartmentCode(this.apartmentCode);
        entity.setCityCode(this.cityCode);
        entity.setCity(this.city);

        return entity;
    }
}
