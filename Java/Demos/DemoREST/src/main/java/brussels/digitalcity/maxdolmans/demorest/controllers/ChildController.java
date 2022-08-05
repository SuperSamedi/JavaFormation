package brussels.digitalcity.maxdolmans.demorest.controllers;

import brussels.digitalcity.maxdolmans.demorest.models.dtos.ChildDTO;
import brussels.digitalcity.maxdolmans.demorest.models.forms.ChildInsertForm;
import brussels.digitalcity.maxdolmans.demorest.models.forms.ChildUpdateForm;
import brussels.digitalcity.maxdolmans.demorest.services.ChildService;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Set;

@RestController
@RequestMapping(path = "/api/child")
public class ChildController {

    private final ChildService service;

    public ChildController(ChildService service) {
        this.service = service;
    }


    @PostMapping(path = "/add")
    public ChildDTO create(@Valid @RequestBody ChildInsertForm form) {
        return service.create(form);
    }

    @GetMapping(path = "/{id:[0-9]+}")
    public ChildDTO getOne(@PathVariable long id) {
        return service.getOne(id);
    }

    @GetMapping(path = "/all")
    public List<ChildDTO> getAll() {
        return service.getAll();
    }

    @PutMapping("/{id:[0-9]+}")
    public ChildDTO update(@PathVariable long id, @RequestBody ChildUpdateForm form) {
        return service.update(id, form);
    }

    @DeleteMapping("/{id:[0-9]+}")
    public ChildDTO delete(@PathVariable Long id){
        return service.delete(id);
    }

    @PatchMapping("/patch-guardians/{id:[0-9]+}")
    public ChildDTO patchGuardians(@PathVariable Long id, @RequestBody Set<Long> newGuardians) {
        return service.patchGuardians(id, newGuardians);
    }
}
