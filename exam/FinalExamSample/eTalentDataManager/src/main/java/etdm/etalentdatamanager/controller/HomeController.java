package etdm.etalentdatamanager.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping(value = {"/", "/home", "/etdm/home"})
    public String displayHomePage() {
        return "public/index";
    }
}