package brussels.digitalcity.maxdolmans.demorest.services.impl;

import brussels.digitalcity.maxdolmans.demorest.exceptions.ElementNotFoundException;
import brussels.digitalcity.maxdolmans.demorest.models.entities.Guardian;
import brussels.digitalcity.maxdolmans.demorest.repositories.GuardianRepository;
import brussels.digitalcity.maxdolmans.demorest.services.ChildService;
import brussels.digitalcity.maxdolmans.demorest.services.GuardianService;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class GuardianServiceImpl implements GuardianService {

    private final GuardianRepository repository;
    private final ChildService childService;

    public GuardianServiceImpl(GuardianRepository repository, ChildService childService) {
        this.repository = repository;
        this.childService = childService;
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
                .orElseThrow(() -> new ElementNotFoundException("Cannot find guardian.", Guardian.class, id));
    }

    @Override
    public List<Guardian> getAll() {
        return repository.findAll();
    }

    @Override
    public Guardian update(Long id, Guardian guardian) {
        if (guardian == null || id == null){
            throw new IllegalArgumentException("Updated guardian or their id should not be null.");
        }

        if ( !repository.existsById(id) ) {
            throw new ElementNotFoundException("Guardian does not exist in the database.", Guardian.class, id);
        }

        guardian.setId(id);

        return repository.save(guardian);
    }

    @Override
    public void delete(Long id) {
        if (!repository.existsById(id)){
            // Will notify us if nothing was deleted
            // todo: throw custom exception
            throw new ElementNotFoundException("Did not find any guardian to delete.", Guardian.class, id);
        }
        repository.deleteById(id);
    }

    @Override
    public Set<Guardian> getAllById(Collection<Long> ids) {
        return new HashSet<>( repository.findAllById(ids) );
    }
}
