package brussels.digitalcity.maxdolmans.demorest.controllers;

import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.headers.Header;
import org.springframework.security.access.prepost.PostAuthorize;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.security.RolesAllowed;

@RestController
@RequestMapping("api/security/demo")
public class SecurityDemoController {

//    @PostAuthorize("returnObject.charAt(0) == 'o'") // authorize la réception si ce qui va etre renvoyé correspond au check des parametres.
    @PreAuthorize("permitAll()") // annotatoin permise par @EnableGlobalMethodSecurity sur la security config. On utilise du SpEL (Spring Expression Language) pour ses parametres.
    @GetMapping("/fullAccess")
    public String fullAccess() {
        return "ok";
    }

    @PreAuthorize("denyAll()")
    @GetMapping("/role/nobody")
    public String nobody() {
        return "ok";
    }

//    @PreAuthorize("isAuthenticated()")
    @GetMapping("/connected")
    @Parameter(required = true) // Swagger
    public String connected() {
        return "ok";
    }

//    @PreAuthorize("isAnonymous()")
    @GetMapping("/not-connected")
    public String notConnected() {
        return "ok";
    }

    @GetMapping("/role/user")
    public String isUser() {
        return "ok";
    }

//    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/role/admin")
    public String isAdmin() {
        return "ok";
    }

//    @PreAuthorize("hasAnyRole('USER', 'ADMIN')")
    @RolesAllowed({"ROLE_USER", "ROLE_ADMIN", "ROLE_PERSONNEL"})
    @GetMapping("/role/any")
    public String isAdminOrUser() {
        return "ok";
    }

    @GetMapping("/authority/READ")
    public String hasReadAuthority() {
        return "ok";
    }

    @GetMapping("/authority/any")
    public String hasReadOrWriteAuthority() {
        return "ok";
    }

}
