package finalexam.gdm.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping(value = { "/", "/home", "/gdm/home"})
    public String displayHomePage() {
        return "public/index";
    }

    @GetMapping(value = {"/gdm/about"})
    public String displayAboutPage() {
        return "public/about";
    }
}
