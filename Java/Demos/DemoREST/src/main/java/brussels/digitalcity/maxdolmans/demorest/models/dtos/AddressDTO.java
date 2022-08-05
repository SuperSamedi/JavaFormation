package brussels.digitalcity.maxdolmans.demorest.models.dtos;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class AddressDTO {

//    private long id;
    private String street;
    private int buildingNumber;
    private String apartmentCode;
    private int cityCode;
    private String city;

}
