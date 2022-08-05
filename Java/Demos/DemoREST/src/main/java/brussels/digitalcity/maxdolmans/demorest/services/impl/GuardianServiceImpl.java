package brussels.digitalcity.maxdolmans.demorest.services.impl;

import brussels.digitalcity.maxdolmans.demorest.exceptions.DeleteReferencedEntityException;
import brussels.digitalcity.maxdolmans.demorest.exceptions.ElementNotFoundException;
import brussels.digitalcity.maxdolmans.demorest.exceptions.InvalidReferenceException;
import brussels.digitalcity.maxdolmans.demorest.mapper.GuardianMapper;
import brussels.digitalcity.maxdolmans.demorest.models.dtos.GuardianDTO;
import brussels.digitalcity.maxdolmans.demorest.models.entities.Child;
import brussels.digitalcity.maxdolmans.demorest.models.entities.Guardian;
import brussels.digitalcity.maxdolmans.demorest.models.entities.Person;
import brussels.digitalcity.maxdolmans.demorest.models.forms.GuardianForm;
import brussels.digitalcity.maxdolmans.demorest.repositories.GuardianRepository;
import brussels.digitalcity.maxdolmans.demorest.services.GuardianService;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class GuardianServiceImpl implements GuardianService {

    private final GuardianRepository repository;
    private final GuardianMapper mapper;

    public GuardianServiceImpl(GuardianRepository repository, GuardianMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }


    @Override
    public GuardianDTO create(GuardianForm form) {
        if (form == null){
            throw new IllegalArgumentException("Error - Trying to insert a NULL entity.");
        }

        Guardian guardian = mapper.toEntity(form);
        guardian = repository.save(guardian);

        return mapper.toDTO(guardian);
    }

    @Override
    public GuardianDTO getOne(Long id) {
        return repository.findById(id)
                .map(mapper::toDTO)
                .orElseThrow(() -> new ElementNotFoundException(Guardian.class, id));
    }

    @Override
    public List<GuardianDTO> getAll() {
        return repository.findAll().stream()
                .map(mapper::toDTO)
                .toList();
    }

    @Override
    public GuardianDTO update(Long id, GuardianForm form) {
        if (form == null || id == null)
            throw new IllegalArgumentException("Updated guardian or their id should not be null.");

        if ( !repository.existsById(id) )
            throw new ElementNotFoundException("Guardian does not exist in the database.", Guardian.class, id);

        Guardian guardian = mapper.toEntity(form);
        guardian.setId(id);
        guardian = repository.save(guardian);

        return mapper.toDTO(guardian);
    }

    @Override
    public GuardianDTO delete(Long id) {
        Guardian guardian = repository.findById(id)
                .orElseThrow( () -> new ElementNotFoundException(Guardian.class, id));

        // Catch error if a child still references the guardian.
        try {
            repository.delete(guardian);
        }
        catch (DataIntegrityViolationException ex) {
            throw new DeleteReferencedEntityException(
                    Child.class,
                    guardian.getChildren().stream()
                            .map(Person::getId)
                            .collect(Collectors.toSet())
            );
        }

        guardian.setId(null);

        return mapper.toDTO(guardian);
    }

    @Override
    public Set<Guardian> getAllById(Collection<Long> ids) {
        // .findAllById Returns the entities it can find.
        // Verifying the size of the returned collection to know if there were bad ids.
        List<Guardian> guardians = repository.findAllById(ids);

        if (guardians.size() < ids.size()) {
            List<Long> found = guardians.stream()
                    .map(Person::getId)
                    .toList();
            List<Long> notFound = ids.stream()
                    .filter( id -> !found.contains(id) )
                    .toList();

            throw new InvalidReferenceException(notFound);
        }

        return new HashSet<>( guardians );
    }
}
