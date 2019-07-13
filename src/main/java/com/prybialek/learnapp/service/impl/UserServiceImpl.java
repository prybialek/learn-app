package com.prybialek.learnapp.service.impl;

import com.prybialek.learnapp.common.BasicDao;
import com.prybialek.learnapp.controller.dto.UserDTO;
import com.prybialek.learnapp.service.UserService;
import com.prybialek.learnapp.service.converter.UserConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private final BasicDao basicDao;
    private final UserConverter userConverter;

    @Autowired
    public UserServiceImpl(BasicDao basicDao, UserConverter userConverter) {
        this.basicDao = basicDao;
        this.userConverter = userConverter;
    }

    @Override
    @Transactional
    public List<UserDTO> getAllUsers() {
        return userConverter.convertToUserDTOs(basicDao.findAll());
    }

    @Override
    public void addUser(UserDTO userDTO) {
        basicDao.save(userConverter.convertToUser(userDTO));
    }

}
