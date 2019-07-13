package com.prybialek.learnapp.controller.impl;

import com.prybialek.learnapp.common.TestConstants;
import com.prybialek.learnapp.controller.dto.UserDTO;
import com.prybialek.learnapp.service.UserService;
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
public class UserControllerImplTest implements TestConstants {

    @Mock
    private UserService userService;

    @InjectMocks
    private UserControllerImpl userControllerImpl;

    @Test
    public void shouldCorrectlyAddUserWithAddresses() {
        // given
        UserDTO userDTO = new UserDTO(TEST_USER_1, TEST_SALARY_1, TEST_ADDRESSES_DTO_PL);

        // when
        userControllerImpl.addUser(userDTO);

        // then
        Mockito.verify(userService, Mockito.times(1)).addUser(userDTO);
    }

    @Test
    public void shouldFindAllUsers() {
        // given
        Mockito.when(userService.getAllUsers()).thenReturn(dummyUsersDTO());

        // when
        List<UserDTO> allUsers = userControllerImpl.getAllUsers();

        // then
        Mockito.verify(userService, Mockito.times(1)).getAllUsers();
        Assert.assertEquals(2, allUsers.size());
    }

    @Test
    public void shouldFindAllUsersWithAddresses() {
        // given
        Mockito.when(userService.getAllUsers()).thenReturn(dummyUsersDTO());

        // when
        List<UserDTO> users = userControllerImpl.getAllUsers();

        // then
        Mockito.verify(userService, Mockito.times(1)).getAllUsers();
        assertThat(users).extracting("name", "salary", "addresses").containsExactly(expectedResult());

    }

    private List<UserDTO> dummyUsersDTO() {
        UserDTO newTestUserDTO1 = new UserDTO(TEST_USER_2, TEST_SALARY_2, TEST_ADDRESSES_DTO_PL);
        UserDTO newTestUserDTO2 = new UserDTO(TEST_USER_3, TEST_SALARY_3, TEST_ADDRESSES_DTO_EN);

        return Arrays.asList(newTestUserDTO1, newTestUserDTO2);
    }

    private Tuple[] expectedResult() {
        return new Tuple[]{Tuple.tuple(TEST_USER_2, TEST_SALARY_2, TEST_ADDRESSES_DTO_PL), Tuple.tuple(TEST_USER_3, TEST_SALARY_3, TEST_ADDRESSES_DTO_EN)};
    }

}
