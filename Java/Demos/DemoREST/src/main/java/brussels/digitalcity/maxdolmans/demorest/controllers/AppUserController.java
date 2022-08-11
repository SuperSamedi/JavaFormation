package brussels.digitalcity.maxdolmans.demorest.controllers;

import brussels.digitalcity.maxdolmans.demorest.models.forms.AppUserForm;
import brussels.digitalcity.maxdolmans.demorest.services.impl.CustomUserDetailsServiceImpl;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping(path = "/api/user")
public class AppUserController {

    private final CustomUserDetailsServiceImpl service;

    public AppUserController(CustomUserDetailsServiceImpl service) {
        this.service = service;
    }


    @PostMapping("/register")
    public void createUser(@Valid @RequestBody AppUserForm form) {
        service.create(form);
    }

}
