package com.example.demo.serviceimpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.demo.dto.UsersDTO;
import com.example.demo.entity.Users;
import com.example.demo.exceptions.UserAlreadyExistsException;
import com.example.demo.exceptions.UserNotFoundException;
import com.example.demo.exceptions.ValidationException;
import com.example.demo.repository.UsersRepository;
import com.example.demo.service.UsersService;

@Service
public class UsersServiceImpl implements UsersService {
	
	private final UsersRepository usersRepo;
	private final PasswordEncoder passwordEncoder;

	@Autowired
	public UsersServiceImpl(UsersRepository usersRepo, PasswordEncoder passwordEncoder) {
		this.usersRepo = usersRepo;
		this.passwordEncoder = passwordEncoder;
	}

	@Override
	public UsersDTO saveUser(UsersDTO userDTO) throws UserAlreadyExistsException, ValidationException {
		// Validate input
		if (userDTO.getEmail() == null || userDTO.getEmail().trim().isEmpty()) {
			throw new ValidationException("Email is required");
		}
		if (userDTO.getName() == null || userDTO.getName().trim().isEmpty()) {
			throw new ValidationException("Name is required");
		}
		if (userDTO.getRole() == null) {
			throw new ValidationException("Role is required");
		}

		// Check if user already exists
		if (usersRepo.findByEmail(userDTO.getEmail()) != null) {
			throw new UserAlreadyExistsException("User with email " + userDTO.getEmail() + " already exists");
		}

		// 1. Transferring data from DTO to Entity
		Users user = new Users();
		
		user.setName(userDTO.getName());
		user.setRole(userDTO.getRole());
		user.setEmail(userDTO.getEmail());
		
		// HASHING THE PASSWORD before saving to DB
		if (userDTO.getPassword() != null) {
			user.setPassword(passwordEncoder.encode(userDTO.getPassword()));
		}
		
		user.setPhone(userDTO.getPhone());
		user.setStatus(userDTO.getStatus() != null ? userDTO.getStatus() : "ACTIVE");
		
		// 2. Save entity to database
		Users savedUser = usersRepo.save(user); 
		
		// 3. Return DTO using helper method
		return convertToDTO(savedUser);
	}

	@Override
	public List<UsersDTO> getAllUsers() {
		List<Users> allUsers = usersRepo.findAll();
		List<UsersDTO> allUsersDTO = new ArrayList<>();
		
		for (Users u : allUsers) {
			allUsersDTO.add(convertToDTO(u));
		}
		
		return allUsersDTO;
	}

	@Override
	public UsersDTO getUserById(Long id) throws UserNotFoundException {
		Optional<Users> userOpt = usersRepo.findById(id);
		if (userOpt.isPresent()) {
			return convertToDTO(userOpt.get());
		} else {
			throw new UserNotFoundException("User with ID " + id + " not found");
		}
	}

	@Override
	public UsersDTO updateUser(Long id, UsersDTO userDetails) throws UserNotFoundException, ValidationException {
		// Validate input
		if (userDetails.getName() == null || userDetails.getName().trim().isEmpty()) {
			throw new ValidationException("Name is required");
		}
		if (userDetails.getRole() == null) {
			throw new ValidationException("Role is required");
		}

		Optional<Users> userOpt = usersRepo.findById(id);
		
		if (userOpt.isPresent()) {
			Users existingUser = userOpt.get();
			
			existingUser.setName(userDetails.getName());
			existingUser.setRole(userDetails.getRole());
			existingUser.setEmail(userDetails.getEmail());
			existingUser.setPhone(userDetails.getPhone());
			existingUser.setStatus(userDetails.getStatus());
			
			// If a new password is provided, hash it before updating
			if(userDetails.getPassword() != null && !userDetails.getPassword().isEmpty()) {
				existingUser.setPassword(passwordEncoder.encode(userDetails.getPassword()));
			}

			Users updatedUser = usersRepo.save(existingUser);
			return convertToDTO(updatedUser);
		} else {
			throw new UserNotFoundException("User with ID " + id + " not found");
		}
	}

	// Helper method to convert Entity to DTO (prevents code repetition)
	private UsersDTO convertToDTO(Users user) {
		UsersDTO dto = new UsersDTO();
		dto.setUserID(user.getUserID());
		dto.setName(user.getName());
		dto.setRole(user.getRole());
		dto.setEmail(user.getEmail());
		dto.setPhone(user.getPhone());
		dto.setStatus(user.getStatus());
		// Never set the password in the DTO being returned to the user
		return dto;
	}
}