package com.prybialek.learnapp.service;

import com.prybialek.learnapp.dao.entity.User;

import java.util.List;

public interface UserService {

    User addUser(User user);
    List<User> getAllUsers();

}
