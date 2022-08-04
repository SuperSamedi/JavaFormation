package brussels.digitalcity.maxdolmans.demorest.mapper;

import brussels.digitalcity.maxdolmans.demorest.models.dtos.GuardianDTO;
import brussels.digitalcity.maxdolmans.demorest.models.entities.Guardian;
import brussels.digitalcity.maxdolmans.demorest.models.forms.GuardianForm;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

@Component
public class GuardianMapper {

    public GuardianDTO toDTO(Guardian entity) {
        if (entity == null) {
            return null;
        }

        Set<GuardianDTO.ChildDTO> children = new HashSet<>();

        if (entity.getChildren() != null) {
            children = entity.getChildren().stream()
                    .map(GuardianDTO.ChildDTO::fromEntity)
                    .collect(Collectors.toSet());
        }

        GuardianDTO dto = new GuardianDTO();

        dto.setId(entity.getId());
        dto.setFirstName(entity.getFirstName());
        dto.setLastName(entity.getLastName());
        dto.setPhoneNumber(entity.getPhoneNumber());
        dto.setAddress(entity.getAddress());
        dto.setChildren(children);

        return dto;
    }

    public Guardian toEntity(GuardianForm form) {
        if (form == null) {
            return null;
        }

        Guardian guardian = new Guardian();

        guardian.setFirstName(form.getFirstName());
        guardian.setLastName(form.getLastName());
        guardian.setPhoneNumber(form.getPhoneNumber());
        guardian.setAddress(form.getAddress());

        return guardian;
    }

}
