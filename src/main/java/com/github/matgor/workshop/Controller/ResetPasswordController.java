package com.github.matgor.workshop.Controller;

import com.github.matgor.workshop.Domain.Model.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;
import javax.validation.constraints.Email;
import java.util.Random;

@Controller
@RequestMapping("/reset_password")
public class ResetPasswordController {

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

    @GetMapping("/rand")
    public String changePasswrdPrepare(Model model){
        model.addAttribute("user", new User());
        return "password/info";
    }

    @RequestMapping(value = "/rand", method = RequestMethod.POST)
    public void changePasswordProcess(@Valid User user){
        Random random = new Random(10);
        String tmpPassword = generatePassword(random.nextInt());
        user.setPassword(tmpPassword);
        
    }
}
