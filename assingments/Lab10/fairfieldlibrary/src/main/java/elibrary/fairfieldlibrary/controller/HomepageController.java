package elibrary.fairfieldlibrary.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomepageController {

    @GetMapping(value={"/", "/elibrary", "/elibrary/home"})
    public String DisplayHomePage(){
        return "home/index";
    }

}
