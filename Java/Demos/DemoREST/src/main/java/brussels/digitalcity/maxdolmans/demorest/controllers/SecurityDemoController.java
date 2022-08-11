package brussels.digitalcity.maxdolmans.demorest.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/security/demo")
public class SecurityDemoController {

    @GetMapping("/fullAccess")
    public String fullAccess() {
        return "ok";
    }

    @GetMapping("/role/nobody")
    public String nobody() {
        return "ok";
    }

    @GetMapping("/connected")
    public String connected() {
        return "ok";
    }

    @GetMapping("/not-connected")
    public String notConnected() {
        return "ok";
    }

    @GetMapping("/role/user")
    public String isUser() {
        return "ok";
    }

    @GetMapping("/role/admin")
    public String isAdmin() {
        return "ok";
    }

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
