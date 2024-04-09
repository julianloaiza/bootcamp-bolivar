package com.allcom.domain.repository;

import com.allcom.domain.User;

import java.util.Optional;

public interface UserRepository {
    Optional<User> getUser(String userId);
}
