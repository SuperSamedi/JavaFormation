package brussels.digitalcity.maxdolmans.demospring.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

@Controller
public class DemoController {
    Random rng = new Random();

    List<String> answers = Arrays.asList(
            "Ouais, ça claque...",
            "C'est nickel...",
            "Yuuuup...",
            "Miam!",
            "Si, quand même pas mal dis...",
            "Po torp mal, ouais..."
    );

    @RequestMapping(path = "/la-page", method = RequestMethod.GET)
    public ModelAndView bellePage() {
        ModelAndView mv = new ModelAndView("demo-index");

        String valeur = answers.get(rng.nextInt(answers.size()));
        mv.addObject("answer", valeur);
        mv.addObject("answers", answers);

        return mv;
    }
}
