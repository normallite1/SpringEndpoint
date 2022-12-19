package ua.gnatyshyn.demo.controller;

import org.springframework.web.bind.annotation.*;
import ua.gnatyshyn.demo.Entity.Human;
import ua.gnatyshyn.demo.exeption.HumanNotFoundException;
import ua.gnatyshyn.demo.repo.HumanRepos;
import ua.gnatyshyn.demo.service.HumanService;

@RestController
public class HumanController {


    private final HumanService humanService;

    public HumanController( HumanService humanService) {

        this.humanService = humanService;
    }

    @RequestMapping(method = RequestMethod.GET, value = "/human/{id}")
    public Human getOne(@PathVariable Long id) {
        return humanService.findById(id).get();
    }

}
