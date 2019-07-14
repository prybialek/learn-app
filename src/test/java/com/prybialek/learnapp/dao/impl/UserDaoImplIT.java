package com.prybialek.learnapp.dao.impl;

import com.prybialek.learnapp.common.TestConstants;
import com.prybialek.learnapp.dao.repo.UserRepo;
import com.prybialek.learnapp.model.entity.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import static org.assertj.core.api.Java6Assertions.assertThat;

@RunWith(SpringRunner.class)
@Transactional
@SpringBootTest
public class UserDaoImplIT implements TestConstants {

    @Autowired
    private UserRepoCustomImpl userDaoImpl;

    @Autowired
    private UserRepo userRepo;

    @Test
    public void shouldFindUserByNameAndSalary() {
        // given
        User userToSave = new User(TEST_ID_3, TEST_USER_1, TEST_SALARY_1, TEST_ADDRESSES_DE);
        userRepo.save(userToSave);

        // when
        User foundUser = userDaoImpl.findUserByNameAndSalary(TEST_USER_1, TEST_SALARY_1);

        // then
        assertThat(foundUser).isEqualToComparingFieldByFieldRecursively(userToSave);
    }

}
