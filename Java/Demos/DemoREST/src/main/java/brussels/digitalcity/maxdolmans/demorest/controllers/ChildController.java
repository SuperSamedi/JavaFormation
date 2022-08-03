package brussels.digitalcity.maxdolmans.demorest.controllers;

import brussels.digitalcity.maxdolmans.demorest.mapper.ChildMapper;
import brussels.digitalcity.maxdolmans.demorest.models.dtos.ChildDTO;
import brussels.digitalcity.maxdolmans.demorest.models.entities.Child;
import brussels.digitalcity.maxdolmans.demorest.models.entities.Guardian;
import brussels.digitalcity.maxdolmans.demorest.models.forms.ChildInsertForm;
import brussels.digitalcity.maxdolmans.demorest.models.forms.ChildUpdateForm;
import brussels.digitalcity.maxdolmans.demorest.services.ChildService;
import brussels.digitalcity.maxdolmans.demorest.services.GuardianService;
import org.springframework.web.bind.annotation.*;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@RestController
@RequestMapping(path = "/api/child")
public class ChildController {

    private final ChildService service;
    private final ChildMapper mapper;
    private final GuardianService guardianService;

    public ChildController(ChildService service, ChildMapper mapper, GuardianService guardianService) {
        this.service = service;
        this.mapper = mapper;
        this.guardianService = guardianService;
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
    public ChildDTO create(@RequestBody ChildInsertForm form) {
        return mapper.toDTO( service.create( mapper.toEntity(form) ) );
    }

    @PutMapping("/{id}")
    public ChildDTO update(@PathVariable long id, @RequestBody ChildUpdateForm form) {
        Child entity = mapper.toEntity(form);
        Set<Guardian> guardians = new HashSet<>();
        if (form.getGuardiansId() != null && !form.getGuardiansId().isEmpty()) {
            guardians = guardianService.getAllById(form.getGuardiansId());
        }
        entity.setGuardians(guardians);
        return mapper.toDTO( service.update( id, entity ) );
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id){
        service.delete(id);
    }
}
