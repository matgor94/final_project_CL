package com.github.matgor.workshop.Domain.Service;

import com.github.matgor.workshop.Domain.Model.Repair;
import com.github.matgor.workshop.Domain.Repository.RepairRepository;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Service
@Repository
@Transactional
public class RepairService {
    @PersistenceContext
    protected EntityManager entityManager;

    public final RepairRepository repairRepository;

    public RepairService(RepairRepository repairRepository) {
        this.repairRepository = repairRepository;
    }


    public Repair addRepair(Repair repair){
        return repairRepository.save(repair);
    }

    //TODO Albo repozytoria albo entityManager, nie jedno i drugie
    public Repair getRepair(Long id){
        return entityManager.find(Repair.class, id);
    }
    public List<Repair> getListOfRepairs(){
        return repairRepository.findAll();
    };

    public Repair editRepair(Repair repair){
        return entityManager.merge(repair);
    }
    public void deleteRepair(Repair repair){
        entityManager.remove(entityManager.contains(repair) ? repair : entityManager.merge(repair));
    }
}
