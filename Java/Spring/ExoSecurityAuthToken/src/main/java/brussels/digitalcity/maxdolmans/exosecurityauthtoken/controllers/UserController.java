package brussels.digitalcity.maxdolmans.exosecurityauthtoken.controllers;

import brussels.digitalcity.maxdolmans.exosecurityauthtoken.forms.UserLoginForm;
import brussels.digitalcity.maxdolmans.exosecurityauthtoken.forms.UserRegisterForm;
import brussels.digitalcity.maxdolmans.exosecurityauthtoken.services.UserService;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping(path = "/api/user")
public class UserController {

    private final UserService service;

    public UserController(UserService service) {
        this.service = service;
    }


    @PostMapping(path = "/register")
    public void registerUser( @Valid @RequestBody UserRegisterForm form) {
        service.register(form);
    }

//    // Retourne le token généré.
//    @PostMapping(path = "/login")
//    public String login(@Valid @RequestBody UserLoginForm form) {
//        Authentication auth = authManager.authenticate( new UsernamePasswordAuthenticationToken( form.getUsername(), form.getPassword()) );
//        return jwtProvider.createToken(auth);
//    }

}
