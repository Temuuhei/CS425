package finalexam.gdm.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping(value = { "/", "/home", "/spebank/home"})
    public String displayHomePage() {
        return "public/index";
    }

    @GetMapping(value = {"/spebank/about"})
    public String displayAboutPage() {
        return "public/about";
    }
}
