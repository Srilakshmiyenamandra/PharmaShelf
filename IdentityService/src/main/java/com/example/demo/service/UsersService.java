package com.example.demo.service;

import java.util.List;

import com.example.demo.dto.UsersDTO;
import com.example.demo.exceptions.UserNotFoundException;
import com.example.demo.exceptions.UserAlreadyExistsException;
import com.example.demo.exceptions.ValidationException;



public interface UsersService {

    public UsersDTO saveUser(UsersDTO user) throws UserAlreadyExistsException, ValidationException;

    public List<UsersDTO> getAllUsers();

    public UsersDTO getUserById(Long id) throws UserNotFoundException;

    public UsersDTO updateUser(Long id, UsersDTO userDetails) throws UserNotFoundException, ValidationException;
}
