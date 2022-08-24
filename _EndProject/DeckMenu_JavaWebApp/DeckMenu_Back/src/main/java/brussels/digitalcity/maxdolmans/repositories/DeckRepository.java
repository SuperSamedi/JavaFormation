package brussels.digitalcity.maxdolmans.repositories;

import brussels.digitalcity.maxdolmans.models.entities.Deck;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DeckRepository extends JpaRepository<Deck, Long> {
}
