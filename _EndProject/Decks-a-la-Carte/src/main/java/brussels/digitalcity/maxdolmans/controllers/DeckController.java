package brussels.digitalcity.maxdolmans.controllers;


import brussels.digitalcity.maxdolmans.models.dtos.DeckDTO;
import brussels.digitalcity.maxdolmans.models.forms.DeckCreateForm;
import brussels.digitalcity.maxdolmans.services.DeckService;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(path = "api/deck")
public class DeckController {

    private final DeckService service;

    public DeckController(DeckService service) {
        this.service = service;
    }


    @PostMapping(path = "/new")
    public DeckDTO create(@Valid @RequestBody DeckCreateForm form) {
        return service.create(form);
    }

    @GetMapping(path = "/all")
    public List<DeckDTO> getAll() {
        return service.getAll();
    }

    @DeleteMapping(path = "/{id:[0-9]+}")
    public boolean delete(@PathVariable Long id) {
        return service.delete(id);
    }

}
