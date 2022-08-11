package brussels.digitalcity.maxdolmans.demorest.services.impl;

import brussels.digitalcity.maxdolmans.demorest.mapper.AppUserMapper;
import brussels.digitalcity.maxdolmans.demorest.models.entities.AppUser;
import brussels.digitalcity.maxdolmans.demorest.models.forms.AppUserForm;
import brussels.digitalcity.maxdolmans.demorest.repositories.AppUserRepository;
import brussels.digitalcity.maxdolmans.demorest.services.AppUserService;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailsServiceImpl implements UserDetailsService, AppUserService {

    private final AppUserRepository repository;
    private final AppUserMapper mapper;
    private final PasswordEncoder encoder;


    public CustomUserDetailsServiceImpl(AppUserRepository repository, AppUserMapper mapper, PasswordEncoder encoder) {
        this.repository = repository;
        this.mapper = mapper;
        this.encoder = encoder;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return repository.findByUsername(username)
                .orElseThrow( () -> new UsernameNotFoundException("Connexion failed."));
    }

    // todo: DTOs
    public void create(AppUserForm form) {
        AppUser user = mapper.toEntity(form);
        user.setPassword(encoder.encode(user.getPassword()));
        repository.save(user);
    }
}
