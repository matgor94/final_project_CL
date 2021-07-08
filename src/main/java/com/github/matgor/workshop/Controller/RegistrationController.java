package com.github.matgor.workshop.Controller;

import org.hibernate.annotations.Cache;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class RegistrationController {
    @GetMapping("/registartion")
    public String registartion(){
        return "registrationPage";
    }
}
