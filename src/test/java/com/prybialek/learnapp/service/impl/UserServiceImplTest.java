package com.prybialek.learnapp.service.impl;


import com.prybialek.learnapp.common.BasicDao;
import com.prybialek.learnapp.common.TestConstants;
import com.prybialek.learnapp.dao.entity.User;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Arrays;
import java.util.List;

@RunWith(MockitoJUnitRunner.class)
public class UserServiceImplTest implements TestConstants {

    @Mock
    private BasicDao basicDao;

    @InjectMocks
    private UserServiceImpl userServiceImpl;

    @Test
    public void shouldAddUser() {
        // given
        User newUser = new User(TEST_USER_1, TEST_SALARY_1);

        // when
        userServiceImpl.addUser(newUser);

        // then
        Mockito.verify(basicDao, Mockito.times(1)).save(newUser);
    }

    @Test
    public void shouldFindAllUsers() {
        // given
        Mockito.when(userServiceImpl.getAllUsers()).thenReturn(dummyUsers());

        // when
        List<User> allUsers = userServiceImpl.getAllUsers();

        // then
        Mockito.verify(basicDao, Mockito.times(1)).findAll();
        Assert.assertEquals(3, allUsers.size());
    }

    private List<User> dummyUsers() {
        User newTestUser1 = new User(TEST_USER_1, TEST_SALARY_1);
        User newTestUser2 = new User(TEST_USER_2, TEST_SALARY_2);
        User newTestUser3 = new User(TEST_USER_3, TEST_SALARY_3);

        return Arrays.asList(newTestUser1, newTestUser2, newTestUser3);
    }

}
