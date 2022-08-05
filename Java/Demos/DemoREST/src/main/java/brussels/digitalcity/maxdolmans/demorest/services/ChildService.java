package brussels.digitalcity.maxdolmans.demorest.services;

import brussels.digitalcity.maxdolmans.demorest.models.dtos.ChildDTO;
import brussels.digitalcity.maxdolmans.demorest.models.forms.ChildInsertForm;
import brussels.digitalcity.maxdolmans.demorest.models.forms.ChildUpdateForm;

import java.util.Set;

public interface ChildService extends CrudService<ChildDTO, Long, ChildInsertForm, ChildUpdateForm> {

    ChildDTO patchGuardians(Long id, Set<Long> newGuardiansIds);

}
