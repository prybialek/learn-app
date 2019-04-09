package com.prybialek.learnapp.service.impl;

import com.prybialek.learnapp.common.BasicDao;
import com.prybialek.learnapp.dao.entity.User;
import com.prybialek.learnapp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private final BasicDao basicDao;

    @Autowired
    public UserServiceImpl(BasicDao basicDao) {
        this.basicDao = basicDao;
    }

    @Override
    public List<User> getAllUsers() {
        return basicDao.findAll();
    }

    @Override
    public User addUser(User user) {
        return basicDao.save(user);
    }
}
