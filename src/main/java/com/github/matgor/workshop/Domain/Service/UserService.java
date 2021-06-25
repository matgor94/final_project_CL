package com.github.matgor.workshop.Domain.Service;

import com.github.matgor.workshop.Domain.Model.User;
import com.github.matgor.workshop.Domain.Repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Service
@Transactional
@Repository
@Slf4j
public class UserService {
    @PersistenceContext
    protected EntityManager entityManager;
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User addUser(User user){
        return userRepository.save(user);
    }

    public User getUser(Long id){
        return entityManager.find(User.class, id);
    }
    public List<User> getListOfUsers(){
        return userRepository.findAll();
    };

   public User editUser(User user){
       return entityManager.merge(user);
   }
   public void deleteUser(User user){
       entityManager.remove(entityManager.contains(user) ? user : entityManager.merge(user));
   }
}
