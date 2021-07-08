package com.github.matgor.workshop.Controller;

import com.github.matgor.workshop.Domain.Model.User;
import com.github.matgor.workshop.Domain.Service.UserService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;

@Controller
@RequestMapping("/user")
public class UserController {
    private final UserService userService;
    private final PasswordEncoder passwordEncoder;


    public UserController(UserService userService, PasswordEncoder passwordEncoder) {
        this.userService = userService;
        this.passwordEncoder = passwordEncoder;
    }

    //REJESTRACJA PRACOWNIKA
    @RequestMapping(value = "/addEmployee", method = RequestMethod.GET)
    public String prepareAddEmployee(Model model) {
        model.addAttribute("user", new User());
        return "user/addForm";
    }

    @RequestMapping(value = "/addEmployee", method = RequestMethod.POST)
    private String processAddEmployee(@Valid User user, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "user/addForm";
        }
        user.setRole("ROLE_EMPLOYEE");
        userService.addUser(user);
        return "redirect:/login";
    }

    //REJESTRACJA UZYTKOWNIKÓW
    @RequestMapping(value = "/addUser", method = RequestMethod.GET)
    public String prepareAddUser(Model model) {
        model.addAttribute("user", new User());
        return "user/addForm";
    }

    @RequestMapping(value = "/addUser", method = RequestMethod.POST)
    private String processAddUser(@Valid User user, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "user/addForm";
        }
        user.setRole("ROLE_USER");
        userService.addUser(user);
        return "redirect:/login";
    }

    @RequestMapping(value = "/addAdmin", method = RequestMethod.GET)
    public String prepareAddAdmin(Model model){
        model.addAttribute("user", new User());
        return "user/addForm";
    }

    @RequestMapping(value = "/addAdmin", method = RequestMethod.POST)
    private String processAddAdmin(@Valid User user, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            return "user/addForm";
        }
        user.setRole("ROLE_ADMIN");
        userService.addUser(user);
        return "redirect:/login";
    }

    @GetMapping("/all")
    public String showAllUser(Model model) {
        model.addAttribute("userList", userService.getListOfUsers());
        return "user/allUsers";
    }

    @GetMapping("/edit")
    public String prepareEditUser(Long id, Model model) {
        model.addAttribute("user", userService.getUser(id));
        return "user/editForm";
    }

    @PostMapping("edit")
    public String processEditUser(@Valid User user, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "user/editForm";
        }
        userService.addUser(user);
        return "redirect:/user/all";
    }


    @GetMapping("/delete")
    public String prepareDeleteUser(Long id, Model model) {
        model.addAttribute("user", userService.getUser(id));
        return "user/confirmDelete";
    }

    @PostMapping("/delete")
    public String processDeleteUser(Long id) {
        User user = userService.getUser(id);
        userService.deleteUser(user);
        return "redirect:/user/all";
    }
}
