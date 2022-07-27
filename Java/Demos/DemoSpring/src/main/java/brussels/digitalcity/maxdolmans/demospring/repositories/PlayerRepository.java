package brussels.digitalcity.maxdolmans.demospring.repositories;

import brussels.digitalcity.maxdolmans.demospring.entities.Player;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlayerRepository extends JpaRepository<Player, Long> {
}
