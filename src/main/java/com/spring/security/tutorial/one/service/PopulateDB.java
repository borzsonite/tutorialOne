package com.spring.security.tutorial.one.service;

import com.spring.security.tutorial.one.model.User;
import com.spring.security.tutorial.one.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class PopulateDB {
    private UserRepository userRepository;

    @Autowired
    public PopulateDB(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @PostConstruct
    public void addUserToDB() {

        User user = new User();
        user.setEmail("ravikumar@gmail.com");
        user.setPassword("ravi2020");
        user.setFirstName("Ravi");
        user.setLastName("Kumar");

        if (userRepository.findUserByEmail(user.getEmail()).getEmail().equals(user.getEmail())) {
            user.setId(userRepository.findUserByEmail(user.getEmail()).getId());
        }
        userRepository.save(user);
    }
}
