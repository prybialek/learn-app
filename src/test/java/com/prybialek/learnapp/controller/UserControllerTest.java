package com.prybialek.learnapp.controller;

import com.prybialek.learnapp.dao.UserDao;
import com.prybialek.learnapp.dao.entity.User;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@RunWith(SpringRunner.class)
@Transactional
@SpringBootTest
public class UserControllerTest {

    private static final String TEST_USER_1 = "TestUser1";
    private static final String TEST_USER_2 = "TestUser2";
    private static final String TEST_USER_3 = "TestUser3";
    private static final int TEST_SALARY_1 = 10000;
    private static final int TEST_SALARY_2 = 20000;
    private static final int TEST_SALARY_3 = 30000;

    @Autowired
    private UserController userController;

    @Autowired
    private UserDao userDao;

    @Test
    public void shouldAddUser() {
        // given
        User testUser = new User(TEST_USER_1, TEST_SALARY_1);

        // when
        userController.addUser(testUser);

        // then

        // ToDo: how to verify mock save?
        User foundUser = userDao.findUserByNameAndSalary(TEST_USER_1, TEST_SALARY_1);
        assertFoundUser(foundUser, TEST_USER_1, TEST_SALARY_1);
    }

    @Test
    public void shouldFindAllAvailableUsers() {
        // given
        userController.addUser(new User(TEST_USER_1, TEST_SALARY_1));
        userController.addUser(new User(TEST_USER_2, TEST_SALARY_2));
        userController.addUser(new User(TEST_USER_3, TEST_SALARY_3));

        // when
        List<User> allFoundUsers = userController.getAllUsers();

        // then
        Assert.assertEquals(3, allFoundUsers.size());
    }

    private void assertFoundUser(User foundUser, String user, int salary) {
        Assert.assertNotNull(foundUser);
        Assert.assertEquals(user, foundUser.getName());
        Assert.assertEquals(salary, foundUser.getSalary());
    }
}
