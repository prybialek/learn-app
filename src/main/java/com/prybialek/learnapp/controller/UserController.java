package com.prybialek.learnapp.controller;

import com.prybialek.learnapp.dao.entity.User;

import java.util.List;

public interface UserController {

    User addUser(User user);
    List<User> getAllUsers();

}
