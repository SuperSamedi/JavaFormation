package brussels.digitalcity.maxdolmans.demorest.services.impl;

import brussels.digitalcity.maxdolmans.demorest.exceptions.ElementNotFoundException;
import brussels.digitalcity.maxdolmans.demorest.mapper.AppUserMapper;
import brussels.digitalcity.maxdolmans.demorest.models.dtos.AccountDTO;
import brussels.digitalcity.maxdolmans.demorest.models.entities.AppUser;
import brussels.digitalcity.maxdolmans.demorest.models.forms.AppUserCreateForm;
import brussels.digitalcity.maxdolmans.demorest.repositories.AppUserRepository;
import brussels.digitalcity.maxdolmans.demorest.services.AppUserService;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

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

    // Fonction qui va chercher les utilisateurs dans la DB/autre system
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return repository.findByUsername(username)
                .orElseThrow( () -> new UsernameNotFoundException("Username not found.") );
    }

    // todo: DTOs?
    @Override
    public void create(AppUserCreateForm form) {
        AppUser user = mapper.toEntity(form);
        user.setRoles(List.of("PERSONNEL"));
        user.setPassword(encoder.encode(user.getPassword()));
        repository.save(user);
    }

    @Override
    public AccountDTO getOne(Long id) {
        return repository.findById(id)
                .map(mapper::toDTO)
                .orElseThrow(() -> new ElementNotFoundException(AppUser.class, id));
    }
}
