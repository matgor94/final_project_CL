package com.github.matgor.workshop.Controller;

import com.github.matgor.workshop.Domain.Model.User;
import com.github.matgor.workshop.Domain.Repository.UserRepository;
import com.github.matgor.workshop.Domain.Service.EmailService;
import com.github.matgor.workshop.Domain.Service.UserService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/reset_password")
public class ResetPasswordController{
    private final EmailService emailService;
    private final PasswordEncoder passwordEncoder;
    private final UserService userService;

    public ResetPasswordController(EmailService emailService, PasswordEncoder passwordEncoder, UserService userService, UserRepository userRepository) {
        this.emailService = emailService;
        this.passwordEncoder = passwordEncoder;
        this.userService = userService;
    }

    @GetMapping
    public String resetPasswordQuestion(Model model) {
        return "password/resetPass";
    }

    @RequestMapping(value = "/rand", method = RequestMethod.GET)
    public String changePasswrdPrepare(Model model) {
        model.addAttribute("user", new User());
        return "password/info";
    }


    @RequestMapping(value = "/rand", method = RequestMethod.POST)
    public String changePasswordProcess(@RequestParam String email, Model model) {
        List<User> users = userService.getListOfUsers();
        List<String> allEmails = new ArrayList<>();
        for (User tmpUser : users) {
            allEmails.add(tmpUser.getEmail());
        }
        String contet = "Portal automotive-workshop został poinformowany o próbie zmiany hasła dla użytkownika \n" +
                "o mailu : " + email + " . " + "\nJeżeli nie wiesz nic na ten temat proszę o kontakt z administratorem. \n" +
                "Aby ustalić nowe hasło kliknij w link lub skopiuj do paska przeglądarki: localhost:8080/reset_password/newpass" +
                "\nPozdrawiamy: automotive_workshop-security";
        if (allEmails.contains(email)) {
            emailService.sendEmail(email, "Warsztat samochodowy - resteowanie hasła", contet);
        } else {
            return "password/error";
        }
        model.addAttribute("email", email);
        return "redirect:/login";
    }

    @GetMapping("/newpass")
    public String newPasswordPrepare(Model model) {
        model.addAttribute("password", new User());
        return "password/pass";
    }

    @RequestMapping(value = "/newpass", method = RequestMethod.POST)
    public String newPassword(@RequestParam String password, String email) {
        User user = userService.userByEmail(email).orElseThrow();
        user.setPassword(password);
        userService.addUser(user);
        return "redirect:/login";
    }
}
