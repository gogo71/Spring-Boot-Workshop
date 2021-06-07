package com.gkhn.issuemanagement.service.impl;

import com.gkhn.issuemanagement.entity.User;
import com.gkhn.issuemanagement.repository.UserRepository;
import com.gkhn.issuemanagement.service.UserService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.math.BigInteger;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    @Override
    public User save(User user) {
        if (user.getEmail()==null){
            throw new IllegalArgumentException("Username cannot be null");
        }
        user = userRepository.save(user);
        return user;
    }

    @Override
    public User getById(BigInteger id) {
        return userRepository.getById(id);
    }

    @Override
    public Page<User> getAllPageable(Pageable pageable) {
        return userRepository.findAll(pageable);
    }


    public User getByUsername(String username) {
        return userRepository.findByUsername(username);
    }
}
