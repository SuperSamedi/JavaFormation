package brussels.digitalcity.maxdolmans.demorest.controllers;

import brussels.digitalcity.maxdolmans.demorest.models.forms.AppUserCreateForm;
import brussels.digitalcity.maxdolmans.demorest.models.forms.AppUserLoginForm;
import brussels.digitalcity.maxdolmans.demorest.services.impl.CustomUserDetailsServiceImpl;
import brussels.digitalcity.maxdolmans.demorest.utils.JwtProvider;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping(path = "/api/user")
public class AppUserController {

    private final CustomUserDetailsServiceImpl service;
    private final AuthenticationManager authManager;
    private final JwtProvider jwtProvider;

    public AppUserController(CustomUserDetailsServiceImpl service, AuthenticationManager authManager, JwtProvider jwtProvider) {
        this.service = service;
        this.authManager = authManager;
        this.jwtProvider = jwtProvider;
    }


    @PostMapping("/register")
    public void createUser(@Valid @RequestBody AppUserCreateForm form) {
        service.create(form);
    }

    @PostMapping("/login")
    public String login(@Valid @RequestBody AppUserLoginForm form) {
        Authentication auth = authManager.authenticate( new UsernamePasswordAuthenticationToken(form.getUsername(), form.getPassword()) );
        return jwtProvider.createToken(auth);
    }

}
