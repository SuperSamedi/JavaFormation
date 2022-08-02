package brussels.digitalcity.maxdolmans.demorest.mapper;

import brussels.digitalcity.maxdolmans.demorest.models.dtos.ChildDTO;
import brussels.digitalcity.maxdolmans.demorest.models.entities.Child;
import brussels.digitalcity.maxdolmans.demorest.models.forms.ChildInsertForm;
import brussels.digitalcity.maxdolmans.demorest.models.forms.ChildUpdateForm;
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
        dto.setAllergies(entity.getAllergies());
        //dto.setGuardians(entity.getGuardians());

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

    // On ne mappe pas l'id ou les guardians
    public Child toEntity(ChildUpdateForm form) {
        if (form == null) {
            return null;
        }

        Child entity = new Child();

        entity.setFirstName(form.getFirstName());
        entity.setLastName(form.getLastName());
        entity.setDateOfBirth(form.getDateOfBirth());
        entity.setClean(form.isCleanliness());
        entity.setAllergies(form.getAllergies());

        return entity;
    }

}
