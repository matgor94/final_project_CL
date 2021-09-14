package com.github.matgor.workshop.Domain.Service;

import com.github.matgor.workshop.Domain.Model.Repair;
import com.github.matgor.workshop.Domain.Model.Task;
import com.github.matgor.workshop.Domain.Repository.TaskRepository;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;
import java.util.Optional;

@Service
@Repository
@Transactional
public class TaskService {
    @PersistenceContext
    protected EntityManager entityManager;


    public final TaskRepository taskRepository;

    public TaskService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    public Task addTask(Task task){
        return taskRepository.save(task);
    }

    public Task getTask(Long id){
        return entityManager.find(Task.class, id);
    }
    public List<Task> getListOfTasks(){
        return taskRepository.findAll();
    };

    public Task editTask(Task task){
        return entityManager.merge(task);
    }
    public void deleteTask(Task task){
        entityManager.remove(entityManager.contains(task) ? task : entityManager.merge(task));
    }


}
