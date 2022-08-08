package brussels.digitalcity.maxdolmans.demorest.repositories;

import brussels.digitalcity.maxdolmans.demorest.models.entities.Guardian;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface GuardianRepository extends JpaRepository<Guardian, Long> {

    List<Guardian> findAllByAddress_CityAndChildrenNotEmpty(String city);

    // Avec JSQL query
    @Query("SELECT g FROM Guardian g WHERE g.address.city = :city AND (g.children.size >= :nbrChildren)")
    List<Guardian> getAllFromCity(String city, int nbrChildren);

}
