package com.prybialek.learnapp.controller;

import com.prybialek.learnapp.controller.dto.UserDTO;

import java.util.List;

public interface UserController {

    void addUser(UserDTO user);
    List<UserDTO> getAllUsers();

}
