package brussels.digitalcity.maxdolmans.demorest.services.impl;

import brussels.digitalcity.maxdolmans.demorest.models.entities.Child;
import brussels.digitalcity.maxdolmans.demorest.repositories.ChildRepository;
import brussels.digitalcity.maxdolmans.demorest.services.IChildService;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@Service
public class ChildService implements IChildService {

    private final ChildRepository repository;

    public ChildService(ChildRepository repository) {
        this.repository = repository;
    }

    @Override
    public Child save(Child child) {
        if (child == null){
            throw new IllegalArgumentException("Child should not be null.");
        }

        return repository.save(child);
    }

    @Override
    public Child getOne(Long id) {
        return repository.findById(id)
                .orElseThrow(EntityNotFoundException::new);
    }

    @Override
    public List<Child> getAll() {
        return repository.findAll();
    }

    @Override
    public Child delete(Long id) {
        Child toDelete = getOne(id);
        repository.delete(toDelete);
        return toDelete;
    }
}
