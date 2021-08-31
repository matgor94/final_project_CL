package com.github.matgor.workshop.Controller;

import com.github.matgor.workshop.Domain.Model.User;
import com.github.matgor.workshop.Domain.Service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

@Controller
public class EmployeeController {

    private final UserService userService;

    public EmployeeController(UserService userService) {
        this.userService = userService;
    }
    @GetMapping("/employee")
    public String onlyEmployees(Model model, Long id){
        List<User> allUser = userService.getListOfUsers();
        List<User> emplooyees = new ArrayList<>();
        for(User user : allUser){
            if (user.getRole().equals("ROLE_EMPLOYEE")){
                emplooyees.add(user);
            }
        }
        String time = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        model.addAttribute("time", time);
        model.addAttribute("employees", emplooyees);
        return "sidebarMenu/employee";
    }
}
