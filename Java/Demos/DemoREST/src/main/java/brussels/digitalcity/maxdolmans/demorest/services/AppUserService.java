package brussels.digitalcity.maxdolmans.demorest.services;

import brussels.digitalcity.maxdolmans.demorest.models.dtos.AccountDTO;
import brussels.digitalcity.maxdolmans.demorest.models.forms.AppUserCreateForm;

public interface AppUserService {
    void create(AppUserCreateForm form);
    AccountDTO getOne(Long id);
}
