package brussels.digitalcity.maxdolmans.demorest.mapper;

import brussels.digitalcity.maxdolmans.demorest.models.entities.AppUser;
import brussels.digitalcity.maxdolmans.demorest.models.forms.AppUserForm;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class AppUserMapper {

    public AppUser toEntity(AppUserForm form) {
        AppUser user = new AppUser();

        user.setUsername(form.getUsername());
        user.setPassword(form.getPassword());
        user.setRoles(List.of("PERSONNEL"));

        return user;
    }
}
