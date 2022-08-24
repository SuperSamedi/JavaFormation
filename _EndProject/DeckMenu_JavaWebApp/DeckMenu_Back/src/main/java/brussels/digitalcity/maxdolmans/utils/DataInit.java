package brussels.digitalcity.maxdolmans.utils;

import brussels.digitalcity.maxdolmans.models.forms.DeckCreateForm;
import brussels.digitalcity.maxdolmans.services.DeckService;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DataInit implements InitializingBean {

    private final DeckService deckService;

    public DataInit(DeckService deckService) {
        this.deckService = deckService;
    }


    private final List<DeckCreateForm> decks = List.of(
            new DeckCreateForm("La Reine"),
            new DeckCreateForm("Rograhk")
    );


    @Override
    public void afterPropertiesSet() throws Exception {
        try {
            decks.forEach(deckService::create);
        }
        catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

}
