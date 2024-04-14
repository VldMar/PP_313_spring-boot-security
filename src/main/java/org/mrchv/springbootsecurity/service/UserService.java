package org.mrchv.springbootsecurity.service;

import org.mrchv.springbootsecurity.model.User;
import org.springframework.stereotype.Service;

import java.util.List;

public interface UserService {
    List<User> findAllUsers();
    User findUserById(Long id);
    User findByUserName(String username);
    void saveUser(User user);
    void removeUserById(Long id);
}
