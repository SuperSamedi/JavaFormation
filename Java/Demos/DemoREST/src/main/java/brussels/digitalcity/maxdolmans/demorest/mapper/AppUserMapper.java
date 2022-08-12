package brussels.digitalcity.maxdolmans.demorest.mapper;

import brussels.digitalcity.maxdolmans.demorest.models.entities.AppUser;
import brussels.digitalcity.maxdolmans.demorest.models.forms.AppUserCreateForm;
import org.springframework.stereotype.Component;

@Component
public class AppUserMapper {

    public AppUser toEntity(AppUserCreateForm form) {
        AppUser user = new AppUser();

        user.setUsername(form.getUsername());
        user.setPassword(form.getPassword());
//        user.setRoles(List.of("PERSONNEL"));

        return user;
    }
}
