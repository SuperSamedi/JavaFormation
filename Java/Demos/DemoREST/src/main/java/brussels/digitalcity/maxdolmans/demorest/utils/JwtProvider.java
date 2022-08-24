package brussels.digitalcity.maxdolmans.demorest.utils;

import brussels.digitalcity.maxdolmans.demorest.models.dtos.TokenDTO;
import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.interfaces.DecodedJWT;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.time.Instant;

// Gère tout ce qui est en rapport avec les JWT
@Slf4j // Logger lombok annotation
@Component
public class JwtProvider {

    // les propriétés sont géré par le JwtProperties et le application.yml
//    private final String KEY = "8TnBtx7HDLtG0%6j#c4#Mam5Fsq9UkWxBkNy$L^ck#plJ8Ubhs";
//    private final String PREFIX = "Bearer ";
//    private final long EXPIRED_AFTER = 846_000;
//    private final String HEADER_KEY = "Authorization";

    //    Logger log = LoggerFactory.getLogger(JwtProvider.class);
    private final UserDetailsService userDetailsService; // pour récupérer les authorities à jour, qui pourraient changer
    private final JwtProperties properties;

    public JwtProvider(UserDetailsService userDetailsService, JwtProperties properties) {
        this.userDetailsService = userDetailsService;
        this.properties = properties;
    }


    public String createToken(Authentication auth) {
        return JWT.create()
                // Déclarer les claims du payload
                .withExpiresAt(Instant.now().plusSeconds(properties.getExpiresAt()))
                .withSubject(auth.getName())
                .withClaim(
                        "roles", auth.getAuthorities().stream()
                                .map(GrantedAuthority::getAuthority)
                                .toList()
                )
                // Déclarer la signature
                .sign(Algorithm.HMAC512(properties.getSecret()));
    }

    public String extractToken(HttpServletRequest request) {
        String authHeader = request.getHeader(properties.getHeaderKey());
        return authHeader == null ? null : authHeader.replace(properties.getHeaderPrefix(), "");
    }

    public boolean validate(String token) {
        try {
            DecodedJWT decodedJWT = JWT.require(Algorithm.HMAC512(properties.getSecret()))
                    .acceptExpiresAt(properties.getExpiresAt())
                    .build().verify(token);

            // On peut encore faire d'autres vérifications par rapport au claims du payload
//            return decodedJWT.getSubject().startsWith("C");

            return true;
        } catch (JWTVerificationException ex) {
            log.warn(ex.getMessage());
            return false;
        }
    }

    public Authentication generateAuth(String token) {
        DecodedJWT decodedJWT = JWT.decode(token);

        UserDetails user = userDetailsService.loadUserByUsername(decodedJWT.getSubject()); // pour récupérer les authorities à jour qui pourraient changer
        Authentication auth = new UsernamePasswordAuthenticationToken(
                decodedJWT.getSubject(),
                null, // pas besoin du password
                user.getAuthorities()
        );

        return auth;
    }
}
