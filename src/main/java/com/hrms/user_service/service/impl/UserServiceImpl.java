package com.hrms.user_service.service.impl;

import com.hrms.user_service.dto.UserDTO;
import com.hrms.user_service.entity.User;
import com.hrms.user_service.enums.Role;
import com.hrms.user_service.exceptions.ResourceNotFoundException;
import com.hrms.user_service.repository.UserRepository;
import com.hrms.user_service.service.UserService;
import jakarta.transaction.Transactional;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    private User convertDtoToEntity(UserDTO dto) {
        User user = new User();
        user.setName(dto.getName());
        user.setEmail(dto.getEmail());
        user.setPhone(dto.getPhone());
        user.setRole(dto.getRole());
        user.setDepartment(dto.getDepartment());
        user.setJobTitle(dto.getJobTitle());
        user.setStatus(dto.getStatus());
        user.setProfileImg(dto.getProfileImg());
    
        // 🔐 Securely hash password before storing
        user.setPassword(passwordEncoder.encode(dto.getPassword()));
    
        return user;
    }
  

  private UserDTO convertEntityToDto(User user) {
    UserDTO dto = new UserDTO();
    dto.setId(user.getId());
    dto.setName(user.getName());
    dto.setEmail(user.getEmail());
    dto.setPhone(user.getPhone());
    dto.setRole(user.getRole());
    dto.setDepartment(user.getDepartment());
    dto.setJobTitle(user.getJobTitle());
    dto.setStatus(user.getStatus());
    dto.setProfileImg(user.getProfileImg());
    
    // 🔐 Only include hashed password for authentication needs
    dto.setPassword(null); 

    return dto;
}

    @Override
    @Transactional
    public UserDTO createUser(UserDTO userDTO) {
        User user = convertDtoToEntity(userDTO);
        return convertEntityToDto(userRepository.save(user));
    }

    @Override
    public Optional<UserDTO> getUserById(Long id) {
        return userRepository.findById(id).map(this::convertEntityToDto);
    }

    @Override
    public List<UserDTO> getAllUsers() {
        return userRepository.findAll().stream().map(this::convertEntityToDto).collect(Collectors.toList());
    }

    @Override
    @Transactional
    public void deleteUser(Long id) {
        User existingUser = userRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("User", id, "User not found"));
        userRepository.delete(existingUser);
    }

    @Override
    @Transactional
    public UserDTO updateUser(Long id, UserDTO userDTO) {
        return userRepository.findById(id)
                .map(existingUser -> {
                    existingUser.setName(userDTO.getName());
                    existingUser.setEmail(userDTO.getEmail());
                    existingUser.setPhone(userDTO.getPhone());
                    existingUser.setRole(userDTO.getRole());
                    existingUser.setDepartment(userDTO.getDepartment());
                    existingUser.setJobTitle(userDTO.getJobTitle());
                    existingUser.setStatus(userDTO.getStatus());
                    existingUser.setProfileImg(userDTO.getProfileImg());
                    return convertEntityToDto(userRepository.save(existingUser));
                })
                .orElseThrow(() -> new ResourceNotFoundException("User", id, "User not found"));
    }

    @Override
    public Optional<UserDTO> getUserByEmail(String email) {
        return userRepository.findByEmail(email).map(this::convertEntityToDto);
    }

    @Override
    public List<UserDTO> getUsersByRole(Role role) {
        return userRepository.findByRole(role).stream().map(this::convertEntityToDto).collect(Collectors.toList());
    }

    @Override
    public Optional<UserDTO> getUserByPhone(String phone) {
        return userRepository.findByPhone(phone).map(this::convertEntityToDto);
    }

    // 🔐 Spring Security Authentication Method
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userRepository.findByEmail(username)
                .map(user -> org.springframework.security.core.userdetails.User.withUsername(user.getEmail())
                        .password(user.getPassword()) // Password stays hashed
                        .roles(user.getRole().name())
                        .build())
                .orElseThrow(() -> new UsernameNotFoundException("User not found"));
    }
}