package erigstrar.eregistrarwebapp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
    @GetMapping(value = {"/", "/home", "/eregistrar/home"})
    public String displayHomePage() {
        return "public/index";
    }

    @GetMapping(value = {"/eregistrar/about"})
    public String displayAboutPage() {
        return "public/about";
    }
}
