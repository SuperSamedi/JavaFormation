package brussels.digitalcity.maxdolmans.demorest.repositories;

import brussels.digitalcity.maxdolmans.demorest.models.entities.Child;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ChildRepository extends JpaRepository<Child, Long> {

    List<Child> findByAllergiesContains(String allergy);
    List<Child> findByFirstNameAndLastName(String firstName, String lastName);

}
