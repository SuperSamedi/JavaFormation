package brussels.digitalcity.maxdolmans.exosecurityauthtoken.utils;

import brussels.digitalcity.maxdolmans.exosecurityauthtoken.forms.UserRegisterForm;
import org.springframework.beans.factory.InitializingBean;

import java.util.List;

public class DataInit implements InitializingBean {

    private final List<UserRegisterForm> users = List.of(
        new UserRegisterForm(
                "Frodon",
                "Mon précieux!"
        )
    );

    @Override
    public void afterPropertiesSet() throws Exception {

    }
}
