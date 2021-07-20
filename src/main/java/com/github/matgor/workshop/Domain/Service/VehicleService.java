package com.github.matgor.workshop.Domain.Service;

import com.github.matgor.workshop.Domain.Model.Vehicle;
import com.github.matgor.workshop.Domain.Repository.VehicleRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.ArrayList;
import java.util.List;

@Service
@Repository
@Transactional
@Slf4j
public class VehicleService {
    @PersistenceContext
    protected EntityManager entityManager;

    private final VehicleRepository vehicleRepository;

    public VehicleService(VehicleRepository vehicleRepository) {
        this.vehicleRepository = vehicleRepository;
    }


    public Vehicle addVehicle(Vehicle vehicle){
        return vehicleRepository.save(vehicle);
    }

    public Vehicle getVehicle(Long id){
        return entityManager.find(Vehicle.class, id);
    }
    public List<Vehicle> getListOfVehicles(){
         return vehicleRepository.findAll();
    };
    //TODO Do tego można użyć query, aby pobrać od razu same nazwy, bez wyciągania wszystkich danych z bazy
    public List<String> getVehicleNames(){
        List<String> vehicleNames = new ArrayList<>();
        List<Vehicle> vehicles = vehicleRepository.findAll();
        for(Vehicle vehicle : vehicles){
            vehicleNames.add(vehicle.getProducent() + " " + vehicle.getModel());
        }
        return vehicleNames;
    };

    public Vehicle editVehicle(Vehicle user){
        return entityManager.merge(user);
    }
    public void deleteVehicle(Vehicle vehicle){
        entityManager.remove(entityManager.contains(vehicle) ? vehicle : entityManager.merge(vehicle));
    }
}
