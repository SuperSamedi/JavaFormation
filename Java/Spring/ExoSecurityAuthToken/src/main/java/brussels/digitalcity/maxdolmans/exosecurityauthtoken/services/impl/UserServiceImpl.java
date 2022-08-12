package brussels.digitalcity.maxdolmans.exosecurityauthtoken.services.impl;

import brussels.digitalcity.maxdolmans.exosecurityauthtoken.entities.AppUser;
import brussels.digitalcity.maxdolmans.exosecurityauthtoken.forms.UserRegisterForm;
import brussels.digitalcity.maxdolmans.exosecurityauthtoken.repositories.UserRepository;
import brussels.digitalcity.maxdolmans.exosecurityauthtoken.services.UserService;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService, UserDetailsService {

    private final UserRepository repository;
    private final PasswordEncoder encoder;

    public UserServiceImpl(UserRepository repository, PasswordEncoder encoder) {
        this.repository = repository;
        this.encoder = encoder;
    }


    @Override
    public void register(UserRegisterForm form) {
        AppUser user = new AppUser();
        user.setUsername(form.getUsername());
        user.setRoles( List.of("REGISTERED_USER") );
        user.setPassword(encoder.encode(form.getPassword()));
        repository.save(user);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return repository.findByUsername(username)
                .orElseThrow( () -> new UsernameNotFoundException("Username not found.") );
    }
}
