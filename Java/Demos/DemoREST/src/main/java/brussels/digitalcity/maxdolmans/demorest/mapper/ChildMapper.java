package brussels.digitalcity.maxdolmans.demorest.mapper;

import brussels.digitalcity.maxdolmans.demorest.models.dtos.ChildDTO;
import brussels.digitalcity.maxdolmans.demorest.models.dtos.GuardianDTO;
import brussels.digitalcity.maxdolmans.demorest.models.entities.Child;
import brussels.digitalcity.maxdolmans.demorest.models.forms.ChildInsertForm;
import brussels.digitalcity.maxdolmans.demorest.models.forms.ChildUpdateForm;
import org.springframework.stereotype.Component;

import java.util.Set;
import java.util.stream.Collectors;

@Component
public class ChildMapper {

    private final GuardianMapper guardianMapper;

    public ChildMapper(GuardianMapper guardianMapper) {
        this.guardianMapper = guardianMapper;
    }


    public ChildDTO toDTO(Child entity) {
        if (entity == null) {
            return null;
        }

        Set<GuardianDTO> dtos = entity.getGuardians().stream()
                .map(guardianMapper::toDTO)
                .collect(Collectors.toSet());

        ChildDTO dto = new ChildDTO();

        dto.setId(entity.getId());
        dto.setFirstName(entity.getFirstName());
        dto.setLastName(entity.getLastName());
        dto.setDateOfBirth(entity.getDateOfBirth());
        dto.setCleanliness(entity.isClean() ? "clean" : "not clean");
        dto.setAllergies(entity.getAllergies());
        dto.setGuardians(dtos);

        return dto;
    }

    public Child toEntity(ChildInsertForm form) {
        if (form == null) {
            return null;
        }

        Child child = new Child();

        child.setFirstName( form.getFirstName() );
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
        entity.setClean(form.isClean());
        entity.setAllergies(form.getAllergies().stream()
                .map(String::trim)
                .map( (s) -> s.replaceAll("\\s{2,}", " "))
                .collect(Collectors.toList())
        );

        return entity;
    }
}
