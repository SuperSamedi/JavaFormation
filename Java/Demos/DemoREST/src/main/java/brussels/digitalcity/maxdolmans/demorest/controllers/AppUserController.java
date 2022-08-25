package brussels.digitalcity.maxdolmans.demorest.controllers;

import brussels.digitalcity.maxdolmans.demorest.models.dtos.AccountDTO;
import brussels.digitalcity.maxdolmans.demorest.models.dtos.TokenDTO;
import brussels.digitalcity.maxdolmans.demorest.models.forms.AppUserCreateForm;
import brussels.digitalcity.maxdolmans.demorest.models.forms.AppUserLoginForm;
import brussels.digitalcity.maxdolmans.demorest.services.impl.CustomUserDetailsServiceImpl;
import brussels.digitalcity.maxdolmans.demorest.utils.JwtProvider;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

@RestController
@RequestMapping(path = "/api/account")
@CrossOrigin(origins = "http://localhost:4200")
public class AppUserController {

    private final CustomUserDetailsServiceImpl service;
    private final AuthenticationManager authManager;
    private final JwtProvider jwtProvider;

    public AppUserController(CustomUserDetailsServiceImpl service, AuthenticationManager authManager, JwtProvider jwtProvider) {
        this.service = service;
        this.authManager = authManager;
        this.jwtProvider = jwtProvider;
    }


    @PostMapping("/sign-up")
    public void createUser(@Valid @RequestBody AppUserCreateForm form) {
        service.create(form);
    }

    @PostMapping("/sign-in")
    public TokenDTO login(@Valid @RequestBody AppUserLoginForm form) {
        Authentication auth = authManager.authenticate( new UsernamePasswordAuthenticationToken(form.getUsername(), form.getPassword()) );
        TokenDTO token = new TokenDTO();
        token.setValue( jwtProvider.createToken(auth) );
        return token;
    }

    @GetMapping("/{id:[0-9]+}")
    public AccountDTO getOne(@NotNull @PathVariable Long id) {
        return service.getOne(id);
    }

}
