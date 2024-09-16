package com.jdc.usermanagement.service.impl;

import com.jdc.usermanagement.dto.UserRequest;
import com.jdc.usermanagement.entity.User;
import com.jdc.usermanagement.repo.UserRepo;
import com.jdc.usermanagement.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService{
    @Autowired
    private UserRepo userRepo;

    @Override
    public User save(UserRequest userRequest) {
         User user = User.builder()
                    .username(userRequest.getUsername())
                    .email(userRequest.getEmail())
                    .joinDate(userRequest.getJoinDate())
                    .build();
        return userRepo.save(user);
    }

    @Override
    public List<User> findAll() {
        return userRepo.findAll();
    }

    @Override
    public User findUserById(long id) {
        return userRepo.findById(id).orElseThrow(() -> new IllegalArgumentException("User Not Found By Id " + id));
    }

    @Override
    public void deleteUserById(long id) {
        if (userRepo.existsById(id)) {
            userRepo.deleteById(id);
        }
    }

    @Override
    public User updateUser(long id, UserRequest userRequest) {
        User existingUser = findUserById(id);
        existingUser.setUsername(userRequest.getUsername());
        existingUser.setEmail(userRequest.getEmail());
        existingUser.setJoinDate(userRequest.getJoinDate());
        User user = userRepo.save(existingUser);
        return user;
    }

}
