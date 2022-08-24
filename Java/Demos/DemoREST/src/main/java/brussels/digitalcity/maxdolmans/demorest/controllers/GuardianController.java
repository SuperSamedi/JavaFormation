package brussels.digitalcity.maxdolmans.demorest.controllers;

import brussels.digitalcity.maxdolmans.demorest.models.dtos.GuardianDTO;
import brussels.digitalcity.maxdolmans.demorest.models.forms.AddressForm;
import brussels.digitalcity.maxdolmans.demorest.models.forms.GuardianForm;
import brussels.digitalcity.maxdolmans.demorest.services.GuardianService;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(path = "/api/guardian")
@Secured(value = "ROLE_PERSONNEL")
@CrossOrigin(origins = "http://localhost:4200")
public class GuardianController {

    private final GuardianService service;

    public GuardianController(GuardianService service) {
        this.service = service;
    }


    @PostMapping(path = "/add")
    public GuardianDTO create(@Valid @RequestBody GuardianForm form) {
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
    public GuardianDTO update(@PathVariable long id, @Valid @RequestBody GuardianForm form) {
        return service.update(id, form);
    }

    @PatchMapping("/patch-address/{id:[0-9]+}")
    public GuardianDTO patchAddress(@PathVariable Long id, @Valid @RequestBody AddressForm newAddress) {
        return service.patchAddress(id, newAddress);
    }

    @DeleteMapping("/{id}")
    public GuardianDTO delete(@PathVariable Long id) {
        return service.delete(id);
    }

    @GetMapping(params = "city")
    public List<GuardianDTO> getAllByCity(@RequestParam String city) {
        return service.getAllFromCity(city);
    }
}
