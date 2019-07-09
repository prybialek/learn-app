package com.prybialek.learnapp.controller.impl;

import com.prybialek.learnapp.common.TestConstants;
import com.prybialek.learnapp.dao.entity.User;
import com.prybialek.learnapp.service.UserService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(MockitoJUnitRunner.class)
public class UserControllerImplTest implements TestConstants {

    @Mock
    private UserService userService;

    @InjectMocks
    private UserControllerImpl userControllerImpl;

    @Test
    public void shouldAddUserWithAddresses() {
        // given
        User newTestUser = new User(TEST_USER_1, TEST_SALARY_1, TEST_ADDRESSES_PL);
        Mockito.when(userService.addUser(newTestUser)).thenReturn(newTestUser);

        // when
        User addedUser = userControllerImpl.addUser(newTestUser);

        // then
        Mockito.verify(userService, Mockito.times(1)).addUser(addedUser);
    }

    @Test
    public void shouldFindAllUsers() {
        // given
        Mockito.when(userService.getAllUsers()).thenReturn(dummyUsers());

        // when
        List<User> allUsers = userControllerImpl.getAllUsers();

        // then
        Mockito.verify(userService, Mockito.times(1)).getAllUsers();
        Assert.assertEquals(2, allUsers.size());
    }

    @Test
    public void shouldFindAllUsersWithAddresses() {
        // given
        Mockito.when(userService.getAllUsers()).thenReturn(dummyUsers());

        // when
        List<User> allUsers = userControllerImpl.getAllUsers();

        // then
        Mockito.verify(userService, Mockito.times(1)).getAllUsers();
        assertThat(allUsers).extracting("name").containsExactly(TEST_USER_2, TEST_USER_3);
        assertThat(allUsers).extracting("salary").containsExactly(TEST_SALARY_2, TEST_SALARY_3);
        assertThat(allUsers).extracting("addresses").containsExactly(TEST_ADDRESSES_PL, TEST_ADDRESSES_EN);
    }

    private List<User> dummyUsers() {
        User newTestUser1 = new User(TEST_USER_2, TEST_SALARY_2, TEST_ADDRESSES_PL);
        User newTestUser2 = new User(TEST_USER_3, TEST_SALARY_3, TEST_ADDRESSES_EN);

        return Arrays.asList(newTestUser1, newTestUser2);
    }

}
