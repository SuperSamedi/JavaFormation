package brussels.digitalcity.maxdolmans.services;

import brussels.digitalcity.maxdolmans.models.dtos.DeckDTO;
import brussels.digitalcity.maxdolmans.models.forms.DeckCreateForm;

import java.util.List;

public interface DeckService {

    DeckDTO create(DeckCreateForm form);
    List<DeckDTO> getAll();
    boolean delete(Long id);

}
