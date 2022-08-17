package brussels.digitalcity.maxdolmans.services.impl;

import brussels.digitalcity.maxdolmans.exceptions.ElementNotFoundException;
import brussels.digitalcity.maxdolmans.mappers.DeckMapper;
import brussels.digitalcity.maxdolmans.models.dtos.DeckDTO;
import brussels.digitalcity.maxdolmans.models.entities.Deck;
import brussels.digitalcity.maxdolmans.models.forms.DeckCreateForm;
import brussels.digitalcity.maxdolmans.repositories.DeckRepository;
import brussels.digitalcity.maxdolmans.services.DeckService;
import brussels.digitalcity.maxdolmans.utils.StringHelper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DeckServiceImpl implements DeckService {

    private final DeckRepository repository;
    private final DeckMapper mapper;

    public DeckServiceImpl(DeckRepository repository, DeckMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }


    @Override
    public List<DeckDTO> getAll() {
        return repository.findAll().stream()
                .map(mapper::toDTO)
                .toList();
    }

    @Override
    public DeckDTO create(DeckCreateForm form) {
        if (form == null) {
            throw new IllegalArgumentException("Error - Trying to create a new deck with a null form.");
        }

        // Clean the name of any weird white spaces.
        form.setName(StringHelper.clean(form.getName()));

        return mapper.toDTO(repository.save(mapper.toEntity(form)));
    }

    @Override
    public boolean delete(Long id) {
        Deck entity = repository.findById(id)
                .orElseThrow(() -> new ElementNotFoundException(Deck.class, id));

        repository.delete(entity);
        return true;
    }

}
