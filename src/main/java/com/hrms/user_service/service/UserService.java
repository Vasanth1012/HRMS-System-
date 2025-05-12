package com.hrms.user_service.service;

import com.hrms.user_service.dto.UserDTO;
import com.hrms.user_service.enums.Role;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;
import java.util.Optional;

public interface UserService extends UserDetailsService {
    
    UserDTO createUser(UserDTO userDTO);
    
    Optional<UserDTO> getUserById(Long id);
    
    List<UserDTO> getAllUsers();
    
    void deleteUser(Long id);
    
    UserDTO updateUser(Long id, UserDTO userDTO);
    
    Optional<UserDTO> getUserByEmail(String email);
    
    List<UserDTO> getUsersByRole(Role role);
    
    Optional<UserDTO> getUserByPhone(String phone);
}