package com.prybialek.learnapp.service.impl;


import com.prybialek.learnapp.common.TestConstants;
import com.prybialek.learnapp.controller.dto.UserDTO;
import com.prybialek.learnapp.dao.repo.UserRepo;
import com.prybialek.learnapp.model.entity.User;
import com.prybialek.learnapp.service.converter.UserConverter;
import org.assertj.core.groups.Tuple;
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
public class UserServiceImplTest implements TestConstants {

    @Mock
    private UserRepo userRepo;

    @Mock
    private UserConverter userConverter;

    @InjectMocks
    private UserServiceImpl userServiceImpl;

    @Test
    public void shouldAddUserWithAddresses() {
        // given
        UserDTO userDTO = new UserDTO(TEST_USER_1, TEST_SALARY_1, TEST_ADDRESSES_DTO_PL);
        User user = new User(TEST_ID_1, TEST_USER_1, TEST_SALARY_1, TEST_ADDRESSES_PL);
        Mockito.when(userConverter.convertToUser(userDTO)).thenReturn(user);

        // when
        userServiceImpl.addUser(userDTO);

        // then
        Mockito.verify(userRepo, Mockito.times(1)).save(user);
    }

    @Test
    public void shouldFindAllUsers() {
        // given
        List<User> users = dummyUsers();
        Mockito.when(userRepo.findAll()).thenReturn(users);
        Mockito.when(userConverter.convertToUserDTOs(users)).thenReturn(dummyUsersDTO());

        // when
        List<UserDTO> foundUsers = userServiceImpl.getAllUsers();

        // then
        Assert.assertEquals(3, foundUsers.size());
        assertThat(foundUsers).extracting("name", "salary").containsExactly(expectedResult());
    }

    private List<User> dummyUsers() {
        User newTestUser1 = new User(TEST_ID_1, TEST_USER_1, TEST_SALARY_1, TEST_ADDRESSES_PL);
        User newTestUser2 = new User(TEST_ID_2, TEST_USER_2, TEST_SALARY_2, TEST_ADDRESSES_EN);
        User newTestUser3 = new User(TEST_ID_3, TEST_USER_3, TEST_SALARY_3, TEST_ADDRESSES_DE);

        return Arrays.asList(newTestUser1, newTestUser2, newTestUser3);
    }

    private List<UserDTO> dummyUsersDTO() {
        UserDTO newTestUserDTO1 = new UserDTO(TEST_USER_1, TEST_SALARY_1, TEST_ADDRESSES_DTO_PL);
        UserDTO newTestUserDTO2 = new UserDTO(TEST_USER_2, TEST_SALARY_2, TEST_ADDRESSES_DTO_EN);
        UserDTO newTestUserDTO3 = new UserDTO(TEST_USER_3, TEST_SALARY_3, TEST_ADDRESSES_DTO_DE);

        return Arrays.asList(newTestUserDTO1, newTestUserDTO2, newTestUserDTO3);
    }

    private Tuple[] expectedResult() {
        return new Tuple[]{Tuple.tuple(TEST_USER_1, TEST_SALARY_1), Tuple.tuple(TEST_USER_2, TEST_SALARY_2), Tuple.tuple(TEST_USER_3, TEST_SALARY_3)};
    }

}
