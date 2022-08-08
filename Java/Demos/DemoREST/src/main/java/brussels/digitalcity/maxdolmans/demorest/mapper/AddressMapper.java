package brussels.digitalcity.maxdolmans.demorest.mapper;

import brussels.digitalcity.maxdolmans.demorest.models.dtos.AddressDTO;
import brussels.digitalcity.maxdolmans.demorest.models.dtos.GuardianDTO;
import brussels.digitalcity.maxdolmans.demorest.models.entities.Address;
import brussels.digitalcity.maxdolmans.demorest.models.entities.Guardian;
import brussels.digitalcity.maxdolmans.demorest.models.forms.AddressForm;
import brussels.digitalcity.maxdolmans.demorest.models.forms.GuardianForm;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

@Component
public class AddressMapper {

    public AddressDTO toDTO(Address entity) {
        if (entity == null) {
            return null;
        }

        AddressDTO dto = new AddressDTO();

        dto.setStreet(entity.getStreet());
        dto.setBuildingNumber(entity.getBuildingNumber());
        dto.setApartmentCode(entity.getApartmentCode());
        dto.setCityCode(entity.getCityCode());
        dto.setCity(entity.getCity());

        return dto;
    }

    public Address toEntity(AddressForm form) {
        if (form == null) {
            return null;
        }

        Address address = new Address();

        address.setStreet(form.getStreet().trim().replaceAll("\\s{2,}", ""));
        address.setBuildingNumber(form.getBuildingNumber());
        address.setApartmentCode(form.getApartmentCode().trim().replaceAll("\\s{2,}", ""));
        address.setCityCode(form.getCityCode());
        address.setCity(form.getCity().trim().replaceAll("\\s{2,}", ""));

        return address;
    }
}
