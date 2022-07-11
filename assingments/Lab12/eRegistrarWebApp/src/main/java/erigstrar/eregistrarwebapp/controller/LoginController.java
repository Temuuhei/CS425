package erigstrar.eregistrarwebapp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {

    @GetMapping(value = { "/public/student/login" })
    public String login() {
        return "public/login";
    }

}