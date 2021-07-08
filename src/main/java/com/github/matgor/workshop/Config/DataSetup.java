package com.github.matgor.workshop.Config;

import com.github.matgor.workshop.Domain.Model.*;
import com.github.matgor.workshop.Domain.Repository.RepairRepository;
import com.github.matgor.workshop.Domain.Repository.TaskRepository;
import com.github.matgor.workshop.Domain.Repository.UserRepository;
import com.github.matgor.workshop.Domain.Repository.VehicleRepository;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.security.crypto.password.PasswordEncoder;
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
    private final PasswordEncoder passwordEncoder;

    public DataSetup(VehicleRepository vehicleRepository, UserRepository userRepository, TaskRepository taskRepository, RepairRepository repairRepository, PasswordEncoder passwordEncoder) {
        this.vehicleRepository = vehicleRepository;
        this.userRepository = userRepository;
        this.taskRepository = taskRepository;
        this.repairRepository = repairRepository;
        this.passwordEncoder = passwordEncoder;
    }
    @EventListener
    @Transactional
    public void loadData(ContextRefreshedEvent contextRefreshedEvent){
        if(!atomicBoolean.getAndSet(true)){
            Vehicle vehicle = new Vehicle(null, "Honda", "Civic", 2004, 233000, 1994, null);
            vehicleRepository.save(vehicle);
            Vehicle vehicle1 = new Vehicle(null, "BMW", "E60", 2006, 320000, 2800, null);
            vehicleRepository.save(vehicle1);

            LocalDate regDate = LocalDate.of(2021, 05, 20);
            LocalDate repairDate = LocalDate.of(2021, 05, 28);
            Task task = new Task(null, regDate , repairDate, "Pompa wody + płyn chłodniczy", vehicle);
            taskRepository.save(task);
            LocalDate regDate1 = LocalDate.of(2021, 06, 20);
            LocalDate repairDate1 = LocalDate.of(2021, 06, 30);
            Task task1 = new Task(null, regDate1, repairDate1, "Uszczelka pod głowica", vehicle1);
            taskRepository.save(task1);

            String password = passwordEncoder.encode("haslo123");
            User user = new User(null, "Mateusz", "Górczyński", "maly316@vp.pl", 690858670, password, "ROLE_ADMIN");
            userRepository.save(user);
            String passowrd_2 = passwordEncoder.encode("haslo321");
            String password_3 = passwordEncoder.encode("kowalski123");
            User user1 = new User(null, "Paulina", "Kozłowska", "kozojqa123@wp.pl", 574985663,passowrd_2, "ROLE_USER");
            userRepository.save(user1);
            User user2 = new User(null, "Czarek", "Kowalski", "kowalski123@o2.pl", 500214254, password_3, "ROLE_EMPLOYEE");
            userRepository.save(user2);

            Repair repair = new Repair(null, BigDecimal.valueOf(519.99), BigDecimal.valueOf(200.00), task);
            repairRepository.save(repair);
            Repair repair1 = new Repair(null,BigDecimal.valueOf(452.18), BigDecimal.valueOf(350.00), task1);
            repairRepository.save(repair1);
        }
    }
}
