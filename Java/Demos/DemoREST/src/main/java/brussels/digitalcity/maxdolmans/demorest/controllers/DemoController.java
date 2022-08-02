package brussels.digitalcity.maxdolmans.demorest.controllers;

import brussels.digitalcity.maxdolmans.demorest.models.entities.Child;
import brussels.digitalcity.maxdolmans.demorest.models.entities.Person;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.time.LocalDate;
import java.util.Map;

@RestController
@RequestMapping(path = "/api")
public class DemoController {

    // GET - http://localhost:8080/api/bob
    @GetMapping(path = "/bob")
    @ResponseBody // le retour de la method sera le body
    @ResponseStatus(HttpStatus.OK)
    public Person getPerson() {
        return new Child("Spongebob", "Squarepants", LocalDate.now(), false);
    }

    // POST http://localhost:8080/api/person
    @PostMapping("/person")
    public void writePerson(@RequestBody Person person, @RequestParam("iterations") int iter){
        for (int i = 0; i < iter; i++) {
            System.out.println(person);
        }
    }

    // GET http://localhost:8080/api/params
    @GetMapping("/params")
    public void writeParams(@RequestParam Map<String, Object> params){
        for (String key : params.keySet()) {
            System.out.println(key + " - " + params.get(key));
        }
    }

    // GET http://localhost:8080/api/header
    // On peut ne pas préciser le nom du header si le nom du parametre de la method
    // a le meme non que la clef du header
    @GetMapping("/header")
    public void writeArtificialHeader(@RequestHeader("artificial") String x){
        System.out.println(x);
    }

    // GET http://localhost:8080/api/header/all
    @GetMapping("/header/all")
    public void writeAllHeaders(@RequestHeader HttpHeaders headers) {
        for (String key : headers.keySet()) {
            System.out.println(key + " - " + headers.get(key));
        }
    }

    // GET http://localhost:8080/api/{variable}
    // Can use RegEx xpressions to limit what is accepted in the path
    // Example here: only accept numbers from 0 to 8 with a repetition of maximum 3 and minimum 1
    @GetMapping("/demo/{id:[0-8]{1,3}}")
    public void demoPathVar(@PathVariable("id") int index) {
        System.out.println("Selected id: " + index);
    }

    // GET http://localhost:8080/api/request
    @GetMapping("/request")
    public void recupRequest(HttpServletRequest request, HttpServletResponse response) {
        System.out.println(request);
        //response.sendRedirect("path");
    }

    // Full-control request/response
    @GetMapping("/person/new")
    public ResponseEntity<Person> getPerson(@RequestParam("firstName") String firstName, @RequestParam("lastName") String lastName) {
        Person body = new Child(firstName, lastName, LocalDate.now(), true);

        HttpHeaders headers = new HttpHeaders();
        headers.add("artificial", "crazy value");

        HttpStatus status = HttpStatus.OK;

//        return new ResponseEntity<>(body, headers, status);
        // ou avec un builder
        return ResponseEntity.status(status)
                .header("builder artificial", "1ere valeur", "2eme valeur")
                .headers(headers)
                .body(body);

    }
}
