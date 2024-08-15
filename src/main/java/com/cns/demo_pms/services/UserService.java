package com.cns.demo_pms.services;

import com.cns.demo_pms.entities.User;

import java.util.List;
import java.util.Optional;

public interface UserService {
    List<User>getAllUsers();
    Optional<User>getUserById(Long id);
    User updateUser(Long id, User user);
    void deleteUser(Long id);

}
