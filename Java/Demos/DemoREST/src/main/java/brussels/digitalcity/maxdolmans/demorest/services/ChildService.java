package brussels.digitalcity.maxdolmans.demorest.services;

import brussels.digitalcity.maxdolmans.demorest.models.entities.Child;

import java.util.Set;

public interface ChildService extends CrudService<Child, Long> {

    Child patchGuardians(Long id, Set<Long> newGuardiansIds);

}
