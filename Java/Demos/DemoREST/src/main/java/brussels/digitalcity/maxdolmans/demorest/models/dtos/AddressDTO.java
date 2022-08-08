package brussels.digitalcity.maxdolmans.demorest.models.dtos;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@NoArgsConstructor
public class AddressDTO {

//    private long id;
    private String street;
    private int buildingNumber;
    private String apartmentCode;
    private int cityCode;
    private String city;

}
