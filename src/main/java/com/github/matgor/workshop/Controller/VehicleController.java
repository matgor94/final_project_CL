package com.github.matgor.workshop.Controller;

import com.github.matgor.workshop.Domain.Model.Vehicle;
import com.github.matgor.workshop.Domain.Service.VehicleService;
import org.springframework.stereotype.Service;
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

@Service
@RequestMapping("/vehicle")
public class VehicleController {
    private final VehicleService vehicleService;

    public VehicleController(VehicleService vehicleService) {
        this.vehicleService = vehicleService;
    }

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String prepareAddVehicle(Model model){
        String time = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        model.addAttribute("vehicle", new Vehicle());
        return "vehicle/addForm";
    }

    @PostMapping("/add")
    private String processAddVehicle(@Valid Vehicle vehicle, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            return "vehicle/addForm";
        }
        vehicleService.addVehicle(vehicle);
        return "redirect:/vehicle/all";
    }

    @GetMapping("/all")
    public String showAllVehicles(Model model){
        String time = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        model.addAttribute("vehiclesList", vehicleService.getListOfVehicles());
        return "vehicle/allVehicles";
    }

    @GetMapping("edit")
    public String prepareEditVehicle(Long id, Model model){
        model.addAttribute("vehicle", vehicleService.getVehicle(id));
        return "vehicle/editForm";
    }

    @PostMapping("/edit")
    public String processEditForm(@Valid Vehicle vehicle, BindingResult bindingResult){
        if (bindingResult.hasErrors()){
            return "vehicle/editForm";
        }
        vehicleService.addVehicle(vehicle);
        return "redirect:/vehicle/all";
    }

    @GetMapping("/delete")
    public String prepareDeleteVehicle(Long id, Model model){
        model.addAttribute("vehicle", vehicleService.getVehicle(id));
        return "vehicle/confirmDelete";
    }

    @PostMapping("/delete")
    public String processDeleteVehicle(Long id){
        Vehicle vehicle = vehicleService.getVehicle(id);
        vehicleService.deleteVehicle(vehicle);
        return "redirect:/vehicle/all";
    }
}
