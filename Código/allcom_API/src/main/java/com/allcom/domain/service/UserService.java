package com.allcom.domain.service;

import com.allcom.domain.User;
import com.allcom.domain.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public Optional<User> getUser(String userId){
        return userRepository.getUser(userId);
    }
}
