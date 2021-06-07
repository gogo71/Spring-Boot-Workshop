package com.gkhn.issuemanagement.service;

import com.gkhn.issuemanagement.entity.Issue;
import com.gkhn.issuemanagement.entity.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.math.BigInteger;

public interface UserService {
    User save(User user);
    User getById(BigInteger id);
    Page<User> getAllPageable(Pageable pageable);


}
