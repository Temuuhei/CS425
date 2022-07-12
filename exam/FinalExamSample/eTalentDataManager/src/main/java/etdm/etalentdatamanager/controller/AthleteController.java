package etdm.etalentdatamanager.controller;

import etdm.etalentdatamanager.service.AthleteService;
import  etdm.etalentdatamanager.model.Athlete;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;

@Controller
@RequestMapping(value = {"/etdm/athlete"})
public class AthleteController {

    @Autowired
    private AthleteService athleteService;

    public AthleteController(AthleteService athleteService) {
        this.athleteService = athleteService;
    }

    @GetMapping(value = {"/list"})
    public ModelAndView listAthletes(Model model) {
        var athletes = athleteService.getAllAthletes();
        var modelAndView = new ModelAndView();
        modelAndView.addObject("athletes", athletes);
        modelAndView.setViewName("public/athletelist");
        return modelAndView;
    }

    @GetMapping(value = {"/elite/list"})
    public ModelAndView listEliteAthletes(Model model) {
        var athletes = athleteService.getAllEliteAthletes();
        var modelAndView = new ModelAndView();
        modelAndView.addObject("athletes", athletes);
        modelAndView.setViewName("public/athletelist");
        return modelAndView;
    }

    @GetMapping(value = {"/new"})
    public String displayNewAthleteForm(Model model) {
        var newAthlete = new Athlete();
        model.addAttribute("athlete", newAthlete);
        return "public/newAthlete";
    }

    @PostMapping(value = {"/new"}) // PRG: Post-Redirect-Get
    public String addNewAthlete(@Valid @ModelAttribute("athlete") Athlete athlete, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("athlete", athlete);
            model.addAttribute("errors", bindingResult.getAllErrors());
            return "public/newAthlete";
        }
        athleteService.addNewAthlete(athlete);
        return "redirect:/etdm/athlete/list";
    }

}