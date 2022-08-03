package brussels.digitalcity.maxdolmans.demorest.services;

import brussels.digitalcity.maxdolmans.demorest.models.entities.Guardian;

import java.util.Collection;
import java.util.Set;

public interface GuardianService extends CrudService<Guardian, Long> {

    Set<Guardian> getAllById(Collection<Long> ids);

}
