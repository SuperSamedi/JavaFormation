package brussels.digitalcity.maxdolmans.demorest.services;

import brussels.digitalcity.maxdolmans.demorest.models.dtos.GuardianDTO;
import brussels.digitalcity.maxdolmans.demorest.models.entities.Guardian;
import brussels.digitalcity.maxdolmans.demorest.models.forms.GuardianForm;

import java.util.Collection;
import java.util.Set;

public interface GuardianService extends CrudService<GuardianDTO, Long, GuardianForm, GuardianForm> {

    Set<Guardian> getAllById(Collection<Long> ids);

}
