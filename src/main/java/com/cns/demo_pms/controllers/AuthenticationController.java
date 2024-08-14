package com.cns.demo_pms.controllers;

import com.cns.demo_pms.entities.AuthenticationResponse;
import com.cns.demo_pms.entities.User;
import com.cns.demo_pms.services.AuthenticationService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class AuthenticationController {

    @Autowired
    private AuthenticationService authService;



    @PostMapping("/register")
    public ResponseEntity<AuthenticationResponse> register(@RequestBody User request) {
        return ResponseEntity.ok(authService.register(request));
    }

    @PostMapping("/login")
    public ResponseEntity<AuthenticationResponse> login(@RequestBody User request) {
        System.out.printf("in controller");
        System.out.println("User deatils =========="+ request);
        return ResponseEntity.ok(authService.authenticate(request));
    }

    @PostMapping("/refresh_token")
    public ResponseEntity refreshToken(HttpServletRequest request, HttpServletResponse response) {
        return authService.refreshToken(request, response);
    }


}
