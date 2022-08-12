package brussels.digitalcity.maxdolmans.exosecurityauthtoken.repositories;

import brussels.digitalcity.maxdolmans.exosecurityauthtoken.entities.AppUser;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface UserRepository extends CrudRepository<AppUser, Long> {

    Optional<AppUser> findByUsername(String username);

}
