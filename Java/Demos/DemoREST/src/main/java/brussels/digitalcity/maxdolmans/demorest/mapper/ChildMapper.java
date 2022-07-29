package brussels.digitalcity.maxdolmans.demorest.mapper;

import brussels.digitalcity.maxdolmans.demorest.models.dtos.ChildDTO;
import brussels.digitalcity.maxdolmans.demorest.models.entities.Child;
import brussels.digitalcity.maxdolmans.demorest.models.forms.ChildInsertForm;
import org.springframework.stereotype.Component;

@Component
public class ChildMapper {

    public ChildDTO toDTO(Child entity) {
        if (entity == null) {
            return null;
        }

        ChildDTO dto = new ChildDTO();

        dto.setId(entity.getId());
        dto.setFirstName(entity.getFirstName());
        dto.setLastName(entity.getLastName());
        dto.setDateOfBirth(entity.getDateOfBirth());
        dto.setCleanliness(entity.isClean() ? "clean" : "not clean");

        return dto;
    }

    public Child toEntity(ChildInsertForm form) {
        if (form == null) {
            return null;
        }

        Child child = new Child();

        child.setFirstName( form.getFirstname() );
        child.setLastName( form.getLastName() );
        child.setDateOfBirth( form.getDateOfBirth() );
        child.setClean( form.isClean() );

        return child;
    }

}
