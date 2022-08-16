package brussels.digitalcity.maxdolmans.mappers;

import brussels.digitalcity.maxdolmans.models.dtos.DeckDTO;
import brussels.digitalcity.maxdolmans.models.entities.Deck;
import brussels.digitalcity.maxdolmans.models.forms.DeckCreateForm;
import org.springframework.stereotype.Component;

@Component
public class DeckMapper {

    public DeckDTO toDTO(Deck entity) {
        if (entity == null) return null;

        DeckDTO dto = new DeckDTO();

        dto.setId(entity.getId());
        dto.setName(entity.getName());

        return dto;
    }


    public Deck toEntity(DeckCreateForm form) {
        if (form == null) return null;

        Deck entity = new Deck();

        entity.setName(form.getName());

        return entity;
    }

}
