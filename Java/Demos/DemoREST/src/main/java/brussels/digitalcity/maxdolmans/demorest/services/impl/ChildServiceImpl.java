package brussels.digitalcity.maxdolmans.demorest.services.impl;

import brussels.digitalcity.maxdolmans.demorest.models.entities.Child;
import brussels.digitalcity.maxdolmans.demorest.repositories.ChildRepository;
import brussels.digitalcity.maxdolmans.demorest.services.ChildService;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@Service
public class ChildServiceImpl implements ChildService {

    private final ChildRepository repository;

    public ChildServiceImpl(ChildRepository repository) {
        this.repository = repository;
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
    public Child update(Long id, Child child) {
        if (child == null || id == null){
            throw new IllegalArgumentException("Updated child or their id should not be null.");
        }

        if ( !repository.existsById(id) ) {
            throw new EntityNotFoundException("Child does not exist in the database.");
        }

        child.setId(id);

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
        toDelete.setId(0L);
        return toDelete;
    }
}
