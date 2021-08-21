package com.github.matgor.workshop.Controller;

import com.github.matgor.workshop.Domain.Model.Repair;
import com.github.matgor.workshop.Domain.Service.RepairService;
import com.github.matgor.workshop.Domain.Service.TaskService;
import com.github.matgor.workshop.Domain.Service.UserService;
import com.github.matgor.workshop.Domain.Service.VehicleService;
import org.springframework.stereotype.Controller;

import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;
import java.util.Optional;

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

    @GetMapping("/add")
    public String prepareAddRepair(Model model, Long id){
        model.addAttribute("repair", new Repair());
        model.addAttribute("task", taskService.getListOfTasks());
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
        model.addAttribute("task", taskService.getListOfTasks());
        return "repair/allRepairs";
    }

    @GetMapping("/edit")
    public String preprareEditRepair(Long id, Model model){
        model.addAttribute("repair", repairService.getRepair(id));
        return "repair/editForm";
    }

    @PostMapping("/edit")
    public String processEditRepair(@Valid Repair repair, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            return "repair/editForm";
        }
        repairService.addRepair(repair);
        return "redirect:/repair/all";
    }

    @GetMapping("/delete")
    public String prepareDeleteRepair(Long id, Model model){
        model.addAttribute("repair", repairService.getRepair(id));
        return "repair/confirmDelete";
        }

    @PostMapping("/delete")
    public String processDeleteRepair(Long id){
        Repair repair = repairService.getRepair(id);
        repairService.deleteRepair(repair);
        return "redirect:/repair/all";
    }
}
