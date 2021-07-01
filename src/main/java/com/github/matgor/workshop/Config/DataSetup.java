package com.github.matgor.workshop.Config;

import com.github.matgor.workshop.Domain.Model.*;
import com.github.matgor.workshop.Domain.Repository.RepairRepository;
import com.github.matgor.workshop.Domain.Repository.TaskRepository;
import com.github.matgor.workshop.Domain.Repository.UserRepository;
import com.github.matgor.workshop.Domain.Repository.VehicleRepository;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.concurrent.atomic.AtomicBoolean;
@Component
public class DataSetup {
    private AtomicBoolean atomicBoolean = new AtomicBoolean(false);
    private final VehicleRepository vehicleRepository;
    private final UserRepository userRepository;
    private final TaskRepository taskRepository;
    private final RepairRepository repairRepository;

    public DataSetup(VehicleRepository vehicleRepository, UserRepository userRepository, TaskRepository taskRepository, RepairRepository repairRepository) {
        this.vehicleRepository = vehicleRepository;
        this.userRepository = userRepository;
        this.taskRepository = taskRepository;
        this.repairRepository = repairRepository;
    }
    @EventListener
    @Transactional
    public void loadData(ContextRefreshedEvent contextRefreshedEvent){
        if(!atomicBoolean.getAndSet(true)){
            Vehicle vehicle = new Vehicle(null, "Honda", "Civic", 2004, 233000, 1994, null);
            vehicleRepository.save(vehicle);
            Vehicle vehicle1 = new Vehicle(null, "BMW", "E60", 2006, 320000, 2800, null);
            vehicleRepository.save(vehicle1);

            LocalDate regDate = LocalDate.of(2021, 05, 22);
            LocalDate repairDate = LocalDate.of(2021, 05, 28);
            Task task = new Task(null,regDate , repairDate, "Pompa wody + płyn chłodniczy", vehicle);
            taskRepository.save(task);
            LocalDate regDate1 = LocalDate.of(2021, 06, 20);
            LocalDate repairDate1 = LocalDate.of(2021, 06, 30);
            Task task1 = new Task(null, regDate1, repairDate1, "Uszczelka pod głowica", vehicle1);
            taskRepository.save(task1);


            User user = new User(null, "Mateusz", "Górczyński", "maly316@vp.pl", 690858670, "haslo123");
            userRepository.save(user);
            User user1 = new User(null, "Paulina", "Kozłowska", "kozojqa123@wp.pl", 574985663,"haslo321");
            userRepository.save(user1);

            Repair repair = new Repair(null, BigDecimal.valueOf(519.99), BigDecimal.valueOf(200.00),vehicle, task, user, Status.DONE);
            repairRepository.save(repair);
            Repair repair1 = new Repair(null,BigDecimal.valueOf(452.18), BigDecimal.valueOf(350.00), vehicle1, task1, user1, Status.DURING);
            repairRepository.save(repair1);

        }
    }
}
