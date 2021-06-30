package com.github.matgor.workshop.Controller;

import com.github.matgor.workshop.Domain.Model.Repair;
import com.github.matgor.workshop.Domain.Service.RepairService;
import com.github.matgor.workshop.Domain.Service.TaskService;
import com.github.matgor.workshop.Domain.Service.UserService;
import com.github.matgor.workshop.Domain.Service.VehicleService;
import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/repair")
public class RepairController {

    private final RepairService repairService;
    private final TaskService taskService;
    private final VehicleService vehicleService;
    private final UserService userService;

    public RepairController(RepairService repairService, TaskService taskService, VehicleService vehicleService, UserService userService) {
        this.repairService = repairService;
        this.taskService = taskService;
        this.vehicleService = vehicleService;
        this.userService = userService;
    }

    /*@GetMapping("/all")
    public String showAllRepair(Model model, Long id){
        Repair repair = new Repair(vehicleService.getVehicle(id).getModel(), taskService.getTask(id).g, userService.getUser(id));
    }
   @GetMapping("/add")
    public String prepareAddRepair(Model model){
        model.addAttribute("repair", new Repair());
        return "repair/addForm";
    }

    @PostMapping("/add")
    public String processAddRepair(@Valid Repair repair, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            return "repair/addForm";
        }
        repairService.addRepair(repair);
        return "redirect:/repair/all";
    }

    @GetMapping("/all")
    public String showAllTask(Model model){
        model.addAttribute("repairList", repairService.getListOfRepairs());
        return "repair/allRepairs";
    }*/
}
