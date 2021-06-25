package com.github.matgor.workshop.Controller;

import com.github.matgor.workshop.Domain.Model.User;
import com.github.matgor.workshop.Domain.Service.UserService;
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

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String prepareAddUser(Model model){
        model.addAttribute("user", new User());
        return "user/addForm";
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    private String processAddUser(@Valid User user, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            return "user/addForm";
        }
        userService.addUser(user);
        return "redirect:/user/all";
    }

    @GetMapping("/all")
    public String showAllUser(Model model){
        model.addAttribute("userList", userService.getListOfUsers());
        return "user/allUsers";
    }

    @GetMapping("/edit")
    public String prepareEditUser(Long id, Model model){
        model.addAttribute("user", userService.getUser(id));
        return "user/editForm";
    }

    @PostMapping("edit")
    public String processEditUser(@Valid User user, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            return "user/editForm";
        }
        userService.addUser(user);
        return "redirect:/user/all";
    }


    @GetMapping("/delete")
    public String prepareDeleteUser(Long id, Model model){
        model.addAttribute("user", userService.getUser(id));
        return "user/confirmDelete";
    }

    @PostMapping("delete")
    public String processDeleteUser(Long id){
        User user = userService.getUser(id);
        userService.deleteUser(user);
        return "redirect:/user/all";
    }
}
