package brussels.digitalcity.maxdolmans.demorest.controllers;

import brussels.digitalcity.maxdolmans.demorest.models.dtos.GuardianDTO;
import brussels.digitalcity.maxdolmans.demorest.models.forms.GuardianForm;
import brussels.digitalcity.maxdolmans.demorest.services.GuardianService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api/guardian")
public class GuardianController {

    private final GuardianService service;

    public GuardianController(GuardianService service) {
        this.service = service;
    }


    @PostMapping(path = "/add")
    public GuardianDTO create(@RequestBody GuardianForm form) {
        return service.create(form);
    }

    @GetMapping(path = "/{id:[0-9]+}")
    public GuardianDTO getOne(@PathVariable long id) {
        return service.getOne(id);
    }

    @GetMapping(path = "/all")
    public List<GuardianDTO> getAll() {
        return service.getAll();
    }

    @PutMapping("/{id}")
    public GuardianDTO update(@PathVariable long id, @RequestBody GuardianForm form) {
        return service.update(id, form);
    }

    @DeleteMapping("/{id}")
    public GuardianDTO delete(@PathVariable Long id) {
        return service.delete(id);
    }
}
