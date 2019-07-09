package com.prybialek.learnapp.controller.impl;

import com.prybialek.learnapp.controller.UserController;
import com.prybialek.learnapp.dao.entity.User;
import com.prybialek.learnapp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserControllerImpl implements UserController {

    private final UserService userService;

    @Autowired
    public UserControllerImpl(UserService userService) {
        this.userService = userService;
    }

    @Override
    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    @Override
    @RequestMapping(value = "/add", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody()
    public User addUser(@RequestBody User user) {
        return userService.addUser(user);
    }

}
