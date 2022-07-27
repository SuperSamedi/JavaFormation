package brussels.digitalcity.maxdolmans.demospring.controllers;

import brussels.digitalcity.maxdolmans.demospring.dtos.PlayerDTO;
import brussels.digitalcity.maxdolmans.demospring.services.PlayerService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping(path = "/joueur")
public class PlayerController {

    private final PlayerService playerService;

    public PlayerController(PlayerService playerService) {
        this.playerService = playerService;
    }

    @RequestMapping(path = "/tous", method = RequestMethod.GET)
    public ModelAndView getAllPlayers() {
        ModelAndView mv = new ModelAndView("player/all");
        mv.addObject("players", this.playerService.getAll());
        return mv;
    }

    @RequestMapping(path = "/{id}")
    public ModelAndView getOnePlayerById(@PathVariable Long id) {
        ModelAndView mv = new ModelAndView("player/one");
        mv.addObject("player", this.playerService.getById(id));
        return mv;
    }
}
