package com.github.matgor.workshop.Controller;

import com.github.matgor.workshop.Domain.Model.Task;
import com.github.matgor.workshop.Domain.Service.TaskService;
import com.github.matgor.workshop.Domain.Service.VehicleService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Controller
@RequestMapping("/task")
public class TaskController {
    private final TaskService taskService;
    private final VehicleService vehicleService;

    public TaskController(TaskService taskService, VehicleService vehicleService) {
        this.taskService = taskService;
        this.vehicleService = vehicleService;
    }


    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String prepareAddTask(Model model){
        model.addAttribute("task", new Task());
        model.addAttribute("vehicles", vehicleService.getListOfVehicles());
        model.addAttribute("vehicleNames", vehicleService.getVehicleNames());
        return "task/addForm";
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    private String processAddTask(@Valid Task task, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            return "task/addForm";
        }
        taskService.addTask(task);
        return "redirect:/task/all";
    }

    @GetMapping("/all")
    public String showAllTask(Model model){
        model.addAttribute("taskList", taskService.getListOfTasks());
        String time = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        model.addAttribute("time", time);
        return "task/allTask";
    }

    @GetMapping("/edit")
    public String prepareEditTask(Long id, Model model){
        model.addAttribute("task", taskService.getTask(id));
        return "task/editForm";
    }

    @PostMapping("edit")
    public String processEditTask(@Valid Task task, BindingResult bindingResult){
        if (bindingResult.hasErrors()){
            return "task/editForm";
        }
        taskService.addTask(task);
        return "redirect:/task/all";
    }

    @GetMapping("/delete")
    public String preprareDeleteTask(Long id, Model model){
        model.addAttribute("task", taskService.getTask(id));
        return "task/confirmDelete";
    }

    @PostMapping("/delete")
    public String processDeleteTask(Long id){
        Task task = taskService.getTask(id);
        taskService.deleteTask(task);
        return "redirect:/task/all";
    }
}
