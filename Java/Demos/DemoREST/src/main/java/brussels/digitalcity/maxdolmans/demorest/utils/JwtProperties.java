package brussels.digitalcity.maxdolmans.demorest.utils;

import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@Getter @Setter
@ConfigurationProperties("application.jwt") // alternative plus simple aux annotations @Value
public class JwtProperties implements InitializingBean {

//    @Value("${application.jwt.secret}")
    private String secret;

//    @Value("${application.jwt.expires-at}")
    private long expiresAt;

//    @Value("${application.jwt.header-prefix}")
    private String headerPrefix;

//    @Value("${application.jwt.header-key}")
    private String headerKey;

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println(this);
    }


    @Override
    public String toString() {
        return "JwtProperties{" +
                "secret='" + secret + '\'' +
                ", expiresAt='" + expiresAt + '\'' +
                ", headerPrefix='" + headerPrefix + '\'' +
                ", headerKey='" + headerKey + '\'' +
                '}';
    }
}
