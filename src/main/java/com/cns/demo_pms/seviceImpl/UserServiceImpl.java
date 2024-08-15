package com.cns.demo_pms.seviceImpl;


import com.cns.demo_pms.customExceptions.ResourceNotFoundException;
import com.cns.demo_pms.entities.User;
import com.cns.demo_pms.repository.UserRepository;
import com.cns.demo_pms.services.UserService;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.util.List;
import java.util.Optional;

@Transactional
@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepo;

    public UserServiceImpl(UserRepository userRepo) {
        this.userRepo = userRepo;
    }

    @Override
    public List<User> getAllUsers() {
        List<User>userList = userRepo.findAll();
        return userList;
    }

    @Override
    public Optional<User> getUserById(Long id) {
        if (userRepo.existsById(id)) {
            return userRepo.findById(id);
        }else {
           throw new ResourceNotFoundException("User is not exits here"+ id);
        }

    }

    @Override
    public User updateUser(Long id, User user) {
        Assert.notNull(id, "The given id must not be null");
        return userRepo.findById(id).map(existingUser -> {
            existingUser.setUsername(user.getUsername());
            existingUser.setEmail(user.getEmail());
            existingUser.setRole(user.getRole());
            existingUser.setPassword(user.getPassword());
            return userRepo.save(existingUser);
        }).orElseThrow(() -> new ResourceNotFoundException("User not found with id " + id));
    }

    @Override
    public void deleteUser(Long id) {
       if(userRepo.existsById(id)){
           userRepo.deleteById(id);
       }else{
          throw new ResourceNotFoundException("User is not found with this id : "+id);
       }
    }
}
