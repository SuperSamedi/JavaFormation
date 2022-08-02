package brussels.digitalcity.maxdolmans.demorest.services.impl;

import brussels.digitalcity.maxdolmans.demorest.models.entities.Child;
import brussels.digitalcity.maxdolmans.demorest.models.entities.Guardian;
import brussels.digitalcity.maxdolmans.demorest.repositories.GuardianRepository;
import brussels.digitalcity.maxdolmans.demorest.services.GuardianService;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Set;

@Service
public class GuardianServiceImpl implements GuardianService {

    private final GuardianRepository repository;

    public GuardianServiceImpl(GuardianRepository repository) {
        this.repository = repository;
    }


    @Override
    public Guardian create(Guardian guardian) {
        if (guardian == null){
            throw new IllegalArgumentException("Created guardian should not be null.");
        }

        guardian.setId(null);

        return repository.save(guardian);
    }

    @Override
    public Guardian getOne(Long id) {
        return repository.findById(id)
                .orElseThrow(EntityNotFoundException::new);
    }

    @Override
    public List<Guardian> getAll() {
        return repository.findAll();
    }

    public Set<Child> getChildrenOfGuardian(Long id) {
        Guardian guardian = getOne(id);
        return guardian.getChildren();
    }

    @Override
    public Guardian update(Long id, Guardian guardian) {
        if (guardian == null || id == null){
            throw new IllegalArgumentException("Updated guardian or their id should not be null.");
        }

        if ( !repository.existsById(id) ) {
            throw new EntityNotFoundException("Guardian does not exist in the database.");
        }

        guardian.setId(id);

        return repository.save(guardian);
    }

    @Override
    public Guardian delete(Long id) {
        Guardian toDelete = getOne(id);
        repository.delete(toDelete);
        toDelete.setId(0L);
        return toDelete;
    }
}
