package brussels.digitalcity.maxdolmans.demorest.controllers;

import brussels.digitalcity.maxdolmans.demorest.mapper.GuardianMapper;
import brussels.digitalcity.maxdolmans.demorest.models.dtos.GuardianDTO;
import brussels.digitalcity.maxdolmans.demorest.models.entities.Guardian;
import brussels.digitalcity.maxdolmans.demorest.models.forms.GuardianForm;
import brussels.digitalcity.maxdolmans.demorest.services.GuardianService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api/guardian")
public class GuardianController {

    private final GuardianService service;
    private final GuardianMapper mapper;

    public GuardianController(GuardianService service, GuardianMapper mapper) {
        this.service = service;
        this.mapper = mapper;
    }

    @GetMapping(path = "/{id:[0-9]+}")
    public GuardianDTO getOne(@PathVariable long id) {
        return mapper.toDTO(service.getOne(id));
    }

    @GetMapping(path = "/all")
    public List<GuardianDTO> getAll() {
        return service.getAll().stream()
                .map(mapper::toDTO)
                .toList();
    }

    @PostMapping(path = "/add")
    public GuardianDTO create(@RequestBody GuardianForm form) {
        return mapper.toDTO(service.create(mapper.toEntity(form)));
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }

    @PutMapping("/{id}")
    public GuardianDTO update(@PathVariable long id, @RequestBody GuardianForm form) {
        Guardian entity = mapper.toEntity(form);
        return mapper.toDTO(service.update(id, entity));
    }
}
