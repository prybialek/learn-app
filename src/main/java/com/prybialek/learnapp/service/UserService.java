package com.prybialek.learnapp.service;

import com.prybialek.learnapp.dao.UserDao;
import com.prybialek.learnapp.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    private final UserDao userDao;

    @Autowired
    public UserService(UserDao userDao) {
        this.userDao = userDao;
    }

    public List<User> getAllUsers() {
        return userDao.findAll();
    }

    public User addUser(User user) {
        return userDao.save(user);
    }
}
