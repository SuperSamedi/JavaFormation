package brussels.digitalcity.maxdolmans.demorest.services.impl;

import brussels.digitalcity.maxdolmans.demorest.exceptions.ElementNotFoundException;
import brussels.digitalcity.maxdolmans.demorest.mapper.ChildMapper;
import brussels.digitalcity.maxdolmans.demorest.models.dtos.ChildDTO;
import brussels.digitalcity.maxdolmans.demorest.models.entities.Child;
import brussels.digitalcity.maxdolmans.demorest.models.entities.Guardian;
import brussels.digitalcity.maxdolmans.demorest.models.forms.ChildInsertForm;
import brussels.digitalcity.maxdolmans.demorest.models.forms.ChildUpdateForm;
import brussels.digitalcity.maxdolmans.demorest.repositories.ChildRepository;
import brussels.digitalcity.maxdolmans.demorest.repositories.GuardianRepository;
import brussels.digitalcity.maxdolmans.demorest.services.ChildService;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class ChildServiceImpl implements ChildService {

    private final ChildRepository repository;
    private final GuardianRepository guardianRepository;
    private final ChildMapper mapper;

    public ChildServiceImpl(ChildRepository repository, GuardianRepository guardianRepository, ChildMapper mapper) {
        this.repository = repository;
        this.guardianRepository = guardianRepository;
        this.mapper = mapper;
    }


    @Override
    public ChildDTO create(ChildInsertForm form) {
        if (form == null){
            throw new IllegalArgumentException("Created child should not be null.");
        }

        Child child = mapper.toEntity(form);
        child = repository.save(child);

        return mapper.toDTO(child);
    }

    @Override
    public ChildDTO getOne(Long id) {
        return repository.findById(id)
                .map(mapper::toDTO)
                .orElseThrow(() -> new ElementNotFoundException(Child.class, id));
    }

    @Override
    public List<ChildDTO> getAll() {
        return repository.findAll().stream()
                .map(mapper::toDTO)
                .toList();
    }

    @Override
    public ChildDTO update(Long id, ChildUpdateForm form) {
        if (form == null || id == null)
            throw new IllegalArgumentException("Updated child or their id should not be null.");

        if ( !repository.existsById(id) )
            throw new ElementNotFoundException(Child.class, id);

        Child child = mapper.toEntity(form);
        List<Guardian> guardians = guardianRepository.findAllById(form.getGuardiansId());
        child.setId(id);
        child.setGuardians(new HashSet<>(guardians));
        child = repository.save(child);

        return mapper.toDTO(child);
    }

    @Override
    public ChildDTO delete(Long id) {
        // Will notify us if nothing was deleted
        if (!repository.existsById(id))
            throw new ElementNotFoundException("Did not find any child to delete at id {" + id + "}.", Child.class, id);

        Child child = repository.findById(id)
                .orElseThrow( () -> new ElementNotFoundException(Child.class, id) );
        repository.delete(child);
        child.setId(null);

        return mapper.toDTO(child);
    }

    @Override
    public ChildDTO patchGuardians(Long id, Set<Long> newGuardiansIds) {
        if (newGuardiansIds == null || id == null){
            throw new IllegalArgumentException("Updated child's ID or their new guardianId set should not be null.");
        }

        if ( !repository.existsById(id) ) {
            throw new ElementNotFoundException(Child.class, id);
        }

        Child child = repository.findById(id)
                .orElseThrow( () -> new ElementNotFoundException(Child.class, id));

        List<Guardian> guardians = guardianRepository.findAllById(newGuardiansIds);
        child.setGuardians(new HashSet<>(guardians));
        child = repository.save(child);

        return mapper.toDTO(child);
    }
}
