package com.epam.task.service;

import com.epam.task.models.User;
import com.epam.task.repositories.UserRepository;

public class UserService {

    UserRepository userRepository = new UserRepository();

    public User add (User user) {
        return userRepository.add(user);
    }

    public boolean removeById(long id) {
        return userRepository.removeById(id);
    }
}
