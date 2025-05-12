package com.hrms.user_service.controller;

import com.hrms.user_service.dto.AuthRequestDTO;
import com.hrms.user_service.security.JwtUtil;
import com.hrms.user_service.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
public class AuthController {  

    private final AuthenticationManager authenticationManager;
    private final JwtUtil jwtUtil;
    private final UserService userService;
    
    private static final Logger LOGGER = LoggerFactory.getLogger(AuthController.class);

    public AuthController(AuthenticationManager authenticationManager, JwtUtil jwtUtil, UserService userService) {
        this.authenticationManager = authenticationManager;
        this.jwtUtil = jwtUtil;
        this.userService = userService;
    }

    @PostMapping("/login")
public ResponseEntity<?> authenticateUser(@RequestBody AuthRequestDTO authRequest) {
    try {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(authRequest.getUsername(), authRequest.getPassword()));

        UserDetails userDetails = userService.loadUserByUsername(authRequest.getUsername());

        String token = jwtUtil.generateToken(userDetails.getUsername());
        return ResponseEntity.ok(new JwtResponse(token));
    } catch (Exception e) {
        return ResponseEntity.status(401).body("Invalid username or password");
    }
}
}

class JwtResponse {
    private String token;
    
    public JwtResponse(String token) {
        this.token = token;
    }
    
    public String getToken() {
        return token;
    }
}