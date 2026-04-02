package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import com.example.demo.dto.LoginDTO;
import com.example.demo.dto.UsersDTO;
import com.example.demo.entity.Users;
import com.example.demo.exceptions.InvalidCredentialsException;
import com.example.demo.exceptions.UserAlreadyExistsException;
import com.example.demo.exceptions.ValidationException;
import com.example.demo.repository.UsersRepository;
import com.example.demo.security.JwtUtil;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/auth")
public class AuthController {
	
	@Autowired
    private UsersRepository repo;
	@Autowired
    private PasswordEncoder encoder;
	@Autowired
    private JwtUtil util;


    public AuthController(UsersRepository repo, PasswordEncoder encoder, JwtUtil util) {
		super();
		this.repo = repo;
		this.encoder = encoder;
		this.util = util;
	}

	@PostMapping("/signup")
    public ResponseEntity<UsersDTO> signup(@Valid @RequestBody UsersDTO userDTO) {
        // Validate input
        if (userDTO.getEmail() == null || userDTO.getEmail().trim().isEmpty()) {
            throw new ValidationException("Email is required");
        }
        if (userDTO.getPassword() == null || userDTO.getPassword().trim().isEmpty()) {
            throw new ValidationException("Password is required");
        }
        if (userDTO.getName() == null || userDTO.getName().trim().isEmpty()) {
            throw new ValidationException("Name is required");
        }
        if (userDTO.getRole() == null) {
            throw new ValidationException("Role is required");
        }

        // Check if user already exists
        if (repo.findByEmail(userDTO.getEmail()) != null) {
            throw new UserAlreadyExistsException("User with email " + userDTO.getEmail() + " already exists");
        }

        // Map DTO to Entity
        Users user = new Users();
        user.setName(userDTO.getName());
        user.setEmail(userDTO.getEmail());
        
        // HASH THE PASSWORD before saving
        if (userDTO.getPassword() != null) {
            user.setPassword(encoder.encode(userDTO.getPassword()));
        }
        
        user.setRole(userDTO.getRole());
        user.setPhone(userDTO.getPhone());
        user.setStatus("ACTIVE"); // Default status for PharmaShelf users

        Users savedUser = repo.save(user);

        // Map back to DTO for response
        UsersDTO responseDTO = new UsersDTO();
        responseDTO.setUserID(savedUser.getUserID());
        responseDTO.setName(savedUser.getName());
        responseDTO.setEmail(savedUser.getEmail());
        responseDTO.setRole(savedUser.getRole());
        responseDTO.setPhone(savedUser.getPhone());
        responseDTO.setStatus(savedUser.getStatus());

        return new ResponseEntity<>(responseDTO, HttpStatus.CREATED);
    }

    @PostMapping("/login")
    public ResponseEntity<String> login(@Valid @RequestBody LoginDTO loginDTO) {
        // Validate input
        if (loginDTO.getEmail() == null || loginDTO.getEmail().trim().isEmpty()) {
            throw new ValidationException("Email is required");
        }
        if (loginDTO.getPassword() == null || loginDTO.getPassword().trim().isEmpty()) {
            throw new ValidationException("Password is required");
        }

        Users u = repo.findByEmail(loginDTO.getEmail());

        // Use encoder.matches to compare raw password with the hashed one in DB
        if (u != null && u.getPassword() != null && encoder.matches(loginDTO.getPassword(), u.getPassword())) {
            String token = util.generateToken(u.getEmail(), u.getRole().name());
            return new ResponseEntity<>(token, HttpStatus.OK);
        } else {
            throw new InvalidCredentialsException("Invalid email or password");
        }
    }
    
 // Add this to your AuthController in the Identity Service
    @GetMapping("/user/{id}")
    public ResponseEntity<UsersDTO> getUserById(@PathVariable Long id) {
        Users user = repo.findById(id).orElseThrow(() -> new com.example.demo.exceptions.UserNotFoundException("User with ID " + id + " not found"));
        UsersDTO dto = new UsersDTO();
        dto.setUserID(user.getUserID());
        dto.setName(user.getName());
        dto.setEmail(user.getEmail());
        dto.setRole(user.getRole());
        dto.setPhone(user.getPhone());
        dto.setStatus(user.getStatus());
        return new ResponseEntity<>(dto, HttpStatus.OK);
    }
}