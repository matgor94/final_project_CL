package com.github.matgor.workshop.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class StartController {
    @GetMapping("/automotive-workshop")
    public String startApp(){
        return "loginPage";
    }
}
