package brussels.digitalcity.maxdolmans.demorest.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import java.util.List;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

        http.httpBasic();
        http.csrf().disable();
        http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);

        // more specific rules to more general rules
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

                .antMatchers("/api/booking/check").permitAll()
                .antMatchers(HttpMethod.DELETE).hasRole("ADMIN")
                .anyRequest().authenticated(); // All the remaining end-points

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

}
