package com.prybialek.learnapp.dao;

import com.prybialek.learnapp.dao.entity.User;

public interface UserDao {

    User findUserByNameAndSalary(String user, int salary);

}
