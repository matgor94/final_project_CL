package com.github.matgor.workshop.Controller;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {

    @GetMapping("/login")
    public static String loginPage() {
        return "login/login";
    }
}
