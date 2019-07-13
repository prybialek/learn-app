package com.prybialek.learnapp.dao.repo;

import com.prybialek.learnapp.model.entity.User;

public interface UserRepoCustom {

    User findUserByNameAndSalary(String user, int salary);

}
