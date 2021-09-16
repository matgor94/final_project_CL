package com.github.matgor.workshop.Controller;

import com.github.matgor.workshop.Domain.Model.User;
import com.github.matgor.workshop.Domain.Service.EmailService;
import com.github.matgor.workshop.Domain.Service.UserService;
import org.slf4j.LoggerFactory;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.Cookie;
import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Random;
import java.util.logging.Logger;

@Controller
@RequestMapping("/reset_password")
public class ResetPasswordController {
    private final EmailService emailService;
    private final PasswordEncoder passwordEncoder;
    private final UserService userService;

    public ResetPasswordController(EmailService emailService, PasswordEncoder passwordEncoder, UserService userService) {
        this.emailService = emailService;
        this.passwordEncoder = passwordEncoder;
        this.userService = userService;
    }


    private static String generatePassword(int length) {
        String capitalCaseLetters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String lowerCaseLetters = "abcdefghijklmnopqrstuvwxyz";
        String specialCharacters = "!@#$";
        String numbers = "1234567890";
        String combinedChars = capitalCaseLetters + lowerCaseLetters + specialCharacters + numbers;
        Random random = new Random();
        char[] password = new char[length];

        password[0] = lowerCaseLetters.charAt(random.nextInt(lowerCaseLetters.length()));
        password[1] = capitalCaseLetters.charAt(random.nextInt(capitalCaseLetters.length()));
        password[2] = specialCharacters.charAt(random.nextInt(specialCharacters.length()));
        password[3] = numbers.charAt(random.nextInt(numbers.length()));

        for(int i = 4; i< length ; i++) {
            password[i] = combinedChars.charAt(random.nextInt(combinedChars.length()));
        }

        return password.toString();
    }

    @GetMapping
    public String resetPasswordQuestion(Model model){
        return "password/resetPass";
    }

    @RequestMapping(value = "/rand", method = RequestMethod.GET)
    public String changePasswrdPrepare(Model model){
        model.addAttribute("user", new User());
        return "password/info";
    }

    @RequestMapping(value = "/rand", method = RequestMethod.POST)
    public String changePasswordProcess(@RequestParam String email){
        List<User> users = userService.getListOfUsers();
        List<String> allEmails = new ArrayList<>();
        for(User tmpUser : users){
            allEmails.add(tmpUser.getEmail());
        }
        String contet = "Portal automotive-workshop został poinformowany o próbie zmiany hasła dla użytkownika \n" +
                "o mailu : " + email + " . " + "\nJeżeli nie wiesz nic na ten temat proszę o zignorowanie wiadomości. \n" +
                "Aby ustalić nowe hasło kliknij w link lub skopiuj do paska przeglądarki: localhost:8080/reset_password/new" +
                "Pozdrawiamy: automotive_workshop-security";
        if (allEmails.contains(email)) {
            emailService.sendEmail(email, "Warsztat samochodowy - resteowanie hasła", contet);
        } else {
            return "password/error";
        };
        Cookie emailCookie = new Cookie("email", email);
        emailCookie.setMaxAge(3600);
        response.addCokie(emailCookie);
        return "redirect:/reset_password/new";
    }
    @RequestMapping(value = "/new", method = RequestMethod.POST)
    public String newPassword(@RequestParam String password){



        return "redirect:/login";
    }
}
