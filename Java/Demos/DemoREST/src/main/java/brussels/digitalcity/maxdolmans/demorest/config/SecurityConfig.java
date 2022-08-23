package brussels.digitalcity.maxdolmans.demorest.config;

import brussels.digitalcity.maxdolmans.demorest.filters.JwtAuthFilter;
import brussels.digitalcity.maxdolmans.demorest.utils.JwtProvider;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(
        prePostEnabled = true, // PreAuhtorize = check avant la requete. PostAuthorize = check apres la requete (si par example l'autorisation dépend du calcul et reésultat de la requete)
        securedEnabled = true, // acces à @Secured
        jsr250Enabled = true // access à @RolesAllowed
) // Permet d'apposer des annotations sur chaque requete dans les controllers - bugged?
public class SecurityConfig {
    // Exist aussi une ancienn methode depreciated implemtation de WebServiceConfigurerAdapter

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http, JwtAuthFilter authFilter) throws Exception {

//        http.httpBasic();

        // Cross Site Request Forgery Block si Spring détecte une requête falcifiée. Disabled ici car Spring interprète les requêtes Postman en tant que tel
        http.csrf().disable();
//        http.cors().disable();

        // Vérifie le token
        http.addFilterBefore(authFilter, UsernamePasswordAuthenticationFilter.class);

        // Précise de ne pas créer de cookie de session pour rester stateless entre les requêtes. Ne garder aucune information entre les requêtes
        http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);

        // Règles d'accès aux end-points
        // A écrire de plus spécifique au plus général
        http.authorizeRequests()
                .antMatchers("/api/security/demo/fullAccess").permitAll() // /* = only 1 sub-path after /child. /** = every sub-paths after /child
                .antMatchers("/api/security/demo/nobody").denyAll() // kill-switch when request is bugged or depreciated?
                .antMatchers("/api/security/demo/connected").authenticated()
                .antMatchers("/api/security/demo/not-connected").anonymous()
                .antMatchers("/api/security/demo/role/user").hasRole("USER")
                .antMatchers("/api/security/demo/role/admin").hasRole("ADMIN")
                .antMatchers("/api/security/demo/role/any").hasAnyRole("USER", "ADMIN")
                .antMatchers("/api/security/demo/authority/READ").hasAuthority("READ")
                .antMatchers("/api/security/demo/authority/any").hasAnyAuthority("READ", "WRITE", "ROLE_USER")
                .antMatchers("/api/security/demo/role/admin").not().hasRole("ADMIN") // Anybody excepted Admins
                .antMatchers("/api/fake/r?quest/{id:[0-9]+}/**").denyAll()
                // ? = joker for 0-1 char
                // * = joker sub-path of 0-N character
                // ** = joker for 0-N sub-paths
                // {pathvar:regex} = regex pattern for a sub-path

                .antMatchers("/api/user/**").permitAll()
                .antMatchers("/api/booking/check").permitAll()
                .antMatchers(HttpMethod.DELETE).hasRole("ADMIN")
                .anyRequest().permitAll(); // All the remaining end-points

        return http.build();
    }

    @Bean
    public PasswordEncoder encoder() {
        return new BCryptPasswordEncoder();
    }

//    @Bean
//    public UserDetailsService userDetailsService(PasswordEncoder encoder) {
//        return new InMemoryUserDetailsManager(
//                List.of(
//                        User.builder()
//                                .username("user")
//                                .password(encoder.encode("pass"))
//                                .roles("PERSONNEL")
//                                .build(),
//
//                        User.builder()
//                                .username("admin")
//                                .password(encoder.encode("pass"))
//                                .roles("ADMIN")
//                                .build()
//                )
//        );
//    }

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration config) throws Exception{
        return config.getAuthenticationManager();
    }

}
