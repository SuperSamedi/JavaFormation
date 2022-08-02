package brussels.digitalcity.maxdolmans.demorest.mapper;

import brussels.digitalcity.maxdolmans.demorest.models.dtos.GuardianDTO;
import brussels.digitalcity.maxdolmans.demorest.models.entities.Child;
import brussels.digitalcity.maxdolmans.demorest.models.entities.Guardian;
import brussels.digitalcity.maxdolmans.demorest.models.forms.GuardianInsertForm;
import brussels.digitalcity.maxdolmans.demorest.models.forms.GuardianUpdateForm;
import brussels.digitalcity.maxdolmans.demorest.services.ChildService;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@Component
public class GuardianMapper {

    private final ChildService childService;

    public GuardianMapper(ChildService childService) {
        this.childService = childService;
    }



    public GuardianDTO toDTO(Guardian entity) {
        if (entity == null) {
            return null;
        }

        GuardianDTO dto = new GuardianDTO();

        dto.setId(entity.getId());
        dto.setFirstName(entity.getFirstName());
        dto.setLastName(entity.getLastName());
        dto.setPhoneNumber(entity.getPhoneNumber());
        dto.setAddress(entity.getAddress());
        dto.setChildrenId(
                entity.getChildren().stream()
                .map(Child::getId)
                .collect(Collectors.toSet())
        );

        return dto;
    }

    public Guardian toEntity(GuardianInsertForm form) {
        if (form == null) {
            return null;
        }

        Guardian guardian = new Guardian();

        guardian.setFirstName( form.getFirstname() );
        guardian.setLastName( form.getLastName() );
        guardian.setPhoneNumber( form.getPhoneNumber() );
        guardian.setAddress( form.getAddress() );

        return guardian;
    }

    // On ne mappe pas l'id ou les guardians
    public Guardian toEntity(GuardianUpdateForm form) {
        if (form == null) {
            return null;
        }

        Guardian entity = new Guardian();

        entity.setFirstName(form.getFirstName());
        entity.setLastName(form.getLastName());
        entity.setPhoneNumber(form.getPhoneNumber());
        entity.setAddress(form.getAddress());
        entity.setChildren(
                form.getChildrenId().stream()
                .map(childService::getOne)
                .collect(Collectors.toSet())
        );

        return entity;
    }

}
