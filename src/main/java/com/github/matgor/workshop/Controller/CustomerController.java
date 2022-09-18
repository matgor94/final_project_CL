package com.github.matgor.workshop.Controller;

import com.github.matgor.workshop.Domain.Model.User;
import com.github.matgor.workshop.Domain.Service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;

@Controller
public class CustomerController {
    public final UserService userService;

    public CustomerController(UserService userService) {
        this.userService = userService;
    }
@GetMapping("/customers")
    public String onlyCustomers(Model model,Long id){
        java.util.List<User> allUser = userService.getListOfUsers();
        java.util.List<User> customers = new ArrayList<>();
        for (User user : allUser){
            if(user.getRole().equals("ROLE_USER")){
                customers.add(user);
            }
        }
        model.addAttribute("customers", customers);
        return "sidebarMenu/customers";
    }
}
