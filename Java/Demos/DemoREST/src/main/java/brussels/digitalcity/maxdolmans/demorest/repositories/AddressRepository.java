package brussels.digitalcity.maxdolmans.demorest.repositories;

import brussels.digitalcity.maxdolmans.demorest.models.entities.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AddressRepository extends JpaRepository<Address,Long> {
}
