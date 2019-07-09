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
        basicDao.save(new User(TEST_USER_1, TEST_SALARY_1, TEST_ADDRESSES_DE));

        // when
        User foundUser = userDaoImpl.findUserByNameAndSalary(TEST_USER_1, TEST_SALARY_1);

        // then
        assertFoundUser(foundUser);
    }

    private void assertFoundUser(User foundUser) {
        Assert.assertNotNull(foundUser);
        Assert.assertEquals(TEST_USER_1, foundUser.getName());
        Assert.assertEquals(TEST_SALARY_1, foundUser.getSalary());
        Assert.assertEquals(TEST_ADDRESSES_DE.size(), 2);
    }

}
