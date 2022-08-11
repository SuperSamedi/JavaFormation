package brussels.digitalcity.maxdolmans.demorest.services.impl;

import brussels.digitalcity.maxdolmans.demorest.exceptions.ElementNotFoundException;
import brussels.digitalcity.maxdolmans.demorest.exceptions.FormValidationException;
import brussels.digitalcity.maxdolmans.demorest.mapper.ChildMapper;
import brussels.digitalcity.maxdolmans.demorest.models.dtos.ChildDTO;
import brussels.digitalcity.maxdolmans.demorest.models.entities.Child;
import brussels.digitalcity.maxdolmans.demorest.models.entities.Guardian;
import brussels.digitalcity.maxdolmans.demorest.models.forms.ChildInsertForm;
import brussels.digitalcity.maxdolmans.demorest.models.forms.ChildUpdateForm;
import brussels.digitalcity.maxdolmans.demorest.repositories.BookingRepository;
import brussels.digitalcity.maxdolmans.demorest.repositories.ChildRepository;
import brussels.digitalcity.maxdolmans.demorest.repositories.GuardianRepository;
import brussels.digitalcity.maxdolmans.demorest.services.ChildService;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class ChildServiceImpl implements ChildService {

    private final ChildRepository repository;
    private final BookingRepository bookingRepository;
    private final ChildMapper mapper;
    private final GuardianRepository guardianRepository;

    public ChildServiceImpl(ChildRepository repository, BookingRepository bookingRepository, ChildMapper mapper, GuardianRepository guardianRepository) {
        this.repository = repository;
        this.bookingRepository = bookingRepository;
        this.mapper = mapper;
        this.guardianRepository = guardianRepository;
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

        MultiValueMap<String, String> validationErrors = null;

        if( form.getAllergies().stream()
                .anyMatch( (allergy) -> allergy == null || allergy.isBlank() || allergy.isEmpty() ) ) {
            validationErrors = new LinkedMultiValueMap<>();
            validationErrors.add("allergies", "some allergies are invalids");
        }

        Child child = mapper.toEntity(form);
        List<Guardian> guardians = guardianRepository.findAllById(form.getGuardiansId());

        if (guardians.size() < form.getGuardiansId().size()) {
            validationErrors = validationErrors == null ? new LinkedMultiValueMap<>() : validationErrors;
            validationErrors.add("guardians", "some ids don't relate to a guardian entity.");
        }

        if (validationErrors != null) {
            throw new FormValidationException(validationErrors);
        }

        child.setId(id);
        child.setGuardians(new HashSet<>(guardians));
        child = repository.save(child);

        return mapper.toDTO(child);
    }

    @Override
    @Transactional // guarde la session transactionnelle db sql pendant toute la methode (nécessaire pour pouvoir faire le getAllergies() dans le mappage toDTO.)
    public ChildDTO delete(Long id) {
        if (!repository.existsById(id))
            throw new ElementNotFoundException(Child.class, id);

        Child child = repository.findById(id)
                .orElseThrow( () -> new ElementNotFoundException(Child.class, id) );
        repository.delete(child);
        child.setId(null);

        return mapper.toDTO(child);
    }

    @Override
    public ChildDTO patchGuardians(Long id, Set<Long> newGuardiansIds) {
        if (newGuardiansIds == null || id == null){
            throw new IllegalArgumentException("Error - Updated child's ID or their new guardianId set should not be null.");
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

    @Override
    public List<ChildDTO> getAllWithAllergy(String allergy) {
        return repository.findByAllergiesContains(allergy).stream()
                .map(mapper::toDTO)
                .toList();
    }

    public List<ChildDTO> getAllPresentOnDay(LocalDate date) {
        return bookingRepository.findBookingsByDate(date).stream()
                .map(
                        (b) -> repository.findById(b.getConcernedChild().getId())
                                .orElseThrow( () -> new ElementNotFoundException(Child.class, b.getConcernedChild().getId())))
                .map(mapper::toDTO)
                .toList();
    }

}
