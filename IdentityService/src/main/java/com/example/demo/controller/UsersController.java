package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import com.example.demo.dto.UsersDTO;
import com.example.demo.service.UsersService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/users")
public class UsersController {

    private final UsersService usersService;

    // Use Constructor Injection instead of field @Autowired
    @Autowired
    public UsersController(UsersService usersService) {
        this.usersService = usersService;
    }

    // CREATE: Register a new user
    // Access: Restricted to Administrator as per PharmaShelf requirements
    @PostMapping("/register")
    @PreAuthorize("hasRole('ADMINISTRATOR')")  
    public ResponseEntity<UsersDTO> createUser(@Valid @RequestBody UsersDTO usersDTO) {
        UsersDTO savedUser = usersService.saveUser(usersDTO);
        return new ResponseEntity<>(savedUser, HttpStatus.CREATED);
    }

    // READ: Get all users
    @GetMapping("/all")
    @PreAuthorize("hasRole('ADMINISTRATOR')")
    public ResponseEntity<List<UsersDTO>> getAllUsers() {
        List<UsersDTO> users = usersService.getAllUsers();
        return new ResponseEntity<>(users, HttpStatus.OK);
    }

    // READ: Get specific user by ID
    @GetMapping("/{id}")
    @PreAuthorize("hasRole('ADMINISTRATOR')")
    public ResponseEntity<UsersDTO> getUserById(@PathVariable Long id) {
        UsersDTO user = usersService.getUserById(id);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    // UPDATE: Update user details
    @PutMapping("/{id}")
    @PreAuthorize("hasRole('ADMINISTRATOR')")
    public ResponseEntity<UsersDTO> updateUser(@PathVariable Long id, @Valid @RequestBody UsersDTO usersDTO) {
        UsersDTO updatedUser = usersService.updateUser(id, usersDTO);
        return new ResponseEntity<>(updatedUser, HttpStatus.OK);
    }
}