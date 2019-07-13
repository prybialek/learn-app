package com.prybialek.learnapp.service.impl;

import com.prybialek.learnapp.controller.dto.UserDTO;
import com.prybialek.learnapp.dao.repo.UserRepo;
import com.prybialek.learnapp.service.UserService;
import com.prybialek.learnapp.service.converter.UserConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepo userRepo;
    private final UserConverter userConverter;

    @Autowired
    public UserServiceImpl(UserRepo userRepo, UserConverter userConverter) {
        this.userRepo = userRepo;
        this.userConverter = userConverter;
    }

    @Override
    @Transactional
    public List<UserDTO> getAllUsers() {
        return userConverter.convertToUserDTOs(userRepo.findAll());
    }

    @Override
    public void addUser(UserDTO userDTO) {
        userRepo.save(userConverter.convertToUser(userDTO));
    }

}
