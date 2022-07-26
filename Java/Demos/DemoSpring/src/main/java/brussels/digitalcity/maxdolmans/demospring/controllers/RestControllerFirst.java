package brussels.digitalcity.maxdolmans.demospring.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/api")
public class RestControllerFirst {

    @RequestMapping(path ="/first")
    public ResponseEntity<String> firstWebApiCall() {
        return ResponseEntity.ok("Bonjour!");
    }
}
