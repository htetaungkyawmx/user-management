package com.jdc.usermanagement.service;

import com.jdc.usermanagement.dto.UserRequest;
import com.jdc.usermanagement.entity.User;

import java.util.List;

public interface UserService {
    User save (UserRequest userRequest);
    List<User> findAll();
    User findUserById(long id);
    void deleteUserById(long id);
    User updateUser(long id, UserRequest userRequest);
}
