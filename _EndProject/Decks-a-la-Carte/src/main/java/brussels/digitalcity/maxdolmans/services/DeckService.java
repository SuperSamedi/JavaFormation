package brussels.digitalcity.maxdolmans.services;

import brussels.digitalcity.maxdolmans.models.dtos.DeckDTO;
import brussels.digitalcity.maxdolmans.models.forms.DeckCreateForm;

public interface DeckService {

    DeckDTO create(DeckCreateForm form);

}
