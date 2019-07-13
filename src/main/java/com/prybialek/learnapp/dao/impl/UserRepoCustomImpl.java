package com.prybialek.learnapp.dao.impl;

import com.prybialek.learnapp.dao.repo.UserRepoCustom;
import com.prybialek.learnapp.model.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;

@Repository
public class UserRepoCustomImpl implements UserRepoCustom {

    private final EntityManager em;

    @Autowired
    public UserRepoCustomImpl(EntityManager em) {
        this.em = em;
    }

    @Override
    @Transactional(readOnly = true)
    public User findUserByNameAndSalary(String user, int salary) {
        return em.createNamedQuery(User.NQ_FIND_USER_BY_NAME_AND_SALARY, User.class)
                .setParameter(User.PARAM_USER, user)
                .setParameter(User.PARAM_SALARY, salary)
                .getSingleResult();
    }
}
