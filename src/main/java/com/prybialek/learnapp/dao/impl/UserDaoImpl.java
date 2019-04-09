package com.prybialek.learnapp.dao.impl;

import com.prybialek.learnapp.dao.UserDao;
import com.prybialek.learnapp.dao.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;

@Repository
public class UserDaoImpl implements UserDao {

    @Autowired
    private EntityManager em;

    @Override
    public User findUserByNameAndSalary(String user, int salary) {
        return em.createNamedQuery(User.NQ_FIND_USER_BY_NAME_AND_SALARY, User.class)
                .setParameter(User.PARAM_USER, user)
                .setParameter(User.PARAM_SALARY, salary)
                .getSingleResult();
    }

}
