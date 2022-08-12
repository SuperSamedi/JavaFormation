package brussels.digitalcity.maxdolmans.demorest.filters;

import brussels.digitalcity.maxdolmans.demorest.utils.JwtProvider;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class JwtAuthFilter extends OncePerRequestFilter {

    private final JwtProvider jwtProvider;

    public JwtAuthFilter(JwtProvider jwtProvider) {
        this.jwtProvider = jwtProvider;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {

        // Sortir le token de la requete (header Authorization).
        // Vérifier la validité du token (algo, secret, claims particuliers).
            // Créer l'Auhentication.
            // Mettre l'Authentication dans le contexte de sécurité.

        String token = jwtProvider.extractToken(request); // /!\ peut être null.

        if (token != null && jwtProvider.validate(token)){
            Authentication auth = jwtProvider.generateAuth(token);
            SecurityContextHolder.getContext().setAuthentication(auth);
        }

        filterChain.doFilter(request, response);
    }
}
