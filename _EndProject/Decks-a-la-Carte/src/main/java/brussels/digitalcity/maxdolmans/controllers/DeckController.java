package brussels.digitalcity.maxdolmans.controllers;


import brussels.digitalcity.maxdolmans.models.dtos.DeckDTO;
import brussels.digitalcity.maxdolmans.models.forms.DeckCreateForm;
import brussels.digitalcity.maxdolmans.services.DeckService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

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

}
