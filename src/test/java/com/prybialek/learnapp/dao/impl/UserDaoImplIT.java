package com.prybialek.learnapp.dao.impl;

import com.prybialek.learnapp.common.BasicDao;
import com.prybialek.learnapp.common.TestConstants;
import com.prybialek.learnapp.dao.entity.User;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

@RunWith(SpringRunner.class)
@Transactional
@SpringBootTest
public class UserDaoImplIT implements TestConstants {

    @Autowired
    private UserDaoImpl userDaoImpl;

    @Autowired
    private BasicDao basicDao;

    @Test
    public void shouldFindUserByNameAndSalary() {
        // given
        basicDao.save(new User(TEST_USER_1, TEST_SALARY_1));

        // when
        User foundUser = userDaoImpl.findUserByNameAndSalary(TEST_USER_1, TEST_SALARY_1);

        // then
        assertFoundUser(foundUser, TEST_USER_1, TEST_SALARY_1);
    }

    private void assertFoundUser(User foundUser, String user, int salary) {
        Assert.assertNotNull(foundUser);
        Assert.assertEquals(user, foundUser.getName());
        Assert.assertEquals(salary, foundUser.getSalary());
    }

}
