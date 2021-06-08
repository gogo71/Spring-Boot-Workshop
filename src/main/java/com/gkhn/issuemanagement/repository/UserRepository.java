package com.gkhn.issuemanagement.repository;

import com.gkhn.issuemanagement.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.math.BigInteger;

public interface UserRepository extends JpaRepository<User,Long> {
    User findByUsername(String username);
}
