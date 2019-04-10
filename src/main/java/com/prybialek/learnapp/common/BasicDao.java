package com.prybialek.learnapp.common;

import com.prybialek.learnapp.dao.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;


public interface BasicDao extends JpaRepository<User, Long> {
}
