package brussels.digitalcity.maxdolmans.demorest.services.impl;

import brussels.digitalcity.maxdolmans.demorest.exceptions.ElementNotFoundException;
import brussels.digitalcity.maxdolmans.demorest.exceptions.InvalidReferenceException;
import brussels.digitalcity.maxdolmans.demorest.models.entities.Child;
import brussels.digitalcity.maxdolmans.demorest.models.entities.Guardian;
import brussels.digitalcity.maxdolmans.demorest.repositories.ChildRepository;
import brussels.digitalcity.maxdolmans.demorest.services.ChildService;
import brussels.digitalcity.maxdolmans.demorest.services.GuardianService;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class ChildServiceImpl implements ChildService {

    private final ChildRepository repository;
    private final GuardianService guardianService;

    public ChildServiceImpl(ChildRepository repository, GuardianService guardianService) {
        this.repository = repository;
        this.guardianService = guardianService;
    }


    @Override
    public Child create(Child child) {
        if (child == null){
            throw new IllegalArgumentException("Created child should not be null.");
        }

        child.setId(null);

        return repository.save(child);
    }

    @Override
    public Child getOne(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new ElementNotFoundException(Child.class, id));
    }

    @Override
    public List<Child> getAll() {
        return repository.findAll();
    }

    @Override
    public Child update(Long id, Child child) {
        if (child == null || id == null){
            throw new IllegalArgumentException("Updated child or their id should not be null.");
        }

        if ( !repository.existsById(id) ) {
            throw new ElementNotFoundException(Child.class, id);
        }

        child.setId(id);

        return repository.save(child);
    }

    @Override
    public void delete(Long id) {
        Child toDelete = getOne(id);
        repository.delete(toDelete);
        toDelete.setId(0L);
    }

    @Override
    public Child patchGuardians(Long id, Set<Long> newGuardiansIds) {
        if (newGuardiansIds == null || id == null){
            throw new IllegalArgumentException("Updated child's ID or their new guardianId set should not be null.");
        }

        if ( !repository.existsById(id) ) {
            throw new ElementNotFoundException(Child.class, id);
        }

        Child toPatch = getOne(id);

        try {
            toPatch.setGuardians(guardianService.getAllById(newGuardiansIds));
        }
        catch (ElementNotFoundException ex) {
            throw new InvalidReferenceException(new HashSet<>(newGuardiansIds));
        }

        return repository.save(toPatch);
    }

}
