package com.cns.demo_pms.controllers;

import com.cns.demo_pms.customExceptions.ResourceNotFoundException;
import com.cns.demo_pms.entities.User;
import com.cns.demo_pms.services.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/api/v1/users")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class UserController {

    private final UserService userServ;

    public UserController(UserService userServ) {
        this.userServ = userServ;
    }

    @GetMapping("/all")
    public ResponseEntity<List<User>>getAllUser(){
        List<User>allUsers = userServ.getAllUsers();
        return  new ResponseEntity<List<User>>(allUsers, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> getUser(@PathVariable Long id) {
        Optional<User> user = userServ.getUserById(id);
        return user.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }
    @PutMapping("/update/{id}")
    public ResponseEntity<User>updateAllUsers(@PathVariable("id")Long id, @RequestBody User user){
        try {
            User updataUser = userServ.updateUser(id, user);
            return ResponseEntity.ok(updataUser);
        }catch (ResourceNotFoundException ex){
            return ResponseEntity.notFound().build();
        }
    }





}
