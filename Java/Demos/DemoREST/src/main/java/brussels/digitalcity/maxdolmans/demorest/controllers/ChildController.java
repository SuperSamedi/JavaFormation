package brussels.digitalcity.maxdolmans.demorest.controllers;

import brussels.digitalcity.maxdolmans.demorest.mapper.ChildMapper;
import brussels.digitalcity.maxdolmans.demorest.models.dtos.ChildDTO;
import brussels.digitalcity.maxdolmans.demorest.models.entities.Child;
import brussels.digitalcity.maxdolmans.demorest.models.forms.ChildInsertForm;
import brussels.digitalcity.maxdolmans.demorest.services.IChildService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api/child")
public class ChildController {

    private final IChildService service;
    private final ChildMapper mapper;

    public ChildController(IChildService service, ChildMapper mapper) {
        this.service = service;
        this.mapper = mapper;
    }

    @GetMapping(path = "/{id:[0-9]+}")
    public ChildDTO getOne(@PathVariable long id) {
        return mapper.toDTO( service.getOne(id) );
    }

    @GetMapping(path = "/all")
    public List<ChildDTO> getAll() {
        return service.getAll().stream()
                .map( mapper::toDTO )
                .toList();
    }

    @PostMapping(path = "/add")
    public ChildDTO insert(@RequestBody ChildInsertForm child) {
        return mapper.toDTO( service.save(mapper.toEntity(child)) );
    }
}
