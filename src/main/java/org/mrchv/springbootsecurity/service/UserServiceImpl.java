package org.mrchv.springbootsecurity.service;


import org.mrchv.springbootsecurity.model.User;
import org.mrchv.springbootsecurity.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepo;

    @Autowired
    public UserServiceImpl(UserRepository userRepo) {
        this.userRepo = userRepo;
    }

    @Override
    public List<User> findAllUsers() {
        return userRepo.findAll();
    }

    @Override
    public User findUserById(Long id) {
        return userRepo.getById(id);
    }

    @Override
    public User findByUserName(String username) {
        return userRepo.findByUsername(username);
    }

    @Override
    public void saveUser(User user) {
        userRepo.save(user);
    }

    @Override
    public void removeUserById(Long id) {
        userRepo.deleteById(id);
    }
}
