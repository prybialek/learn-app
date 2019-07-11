package com.prybialek.learnapp.service;

import com.prybialek.learnapp.controller.dto.UserDTO;

import java.util.List;

public interface UserService {

    void addUser(UserDTO user);
    List<UserDTO> getAllUsers();

}
