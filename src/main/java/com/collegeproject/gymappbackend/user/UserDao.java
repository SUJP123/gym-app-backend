package com.collegeproject.gymappbackend.user;

import java.util.UUID;

public interface UserDao {

    int insertUser(UUID id, String firstName, String lastName, String email, String password, Role role);

    default int insertUser(User user) {
        UUID id = UUID.randomUUID();
        return insertUser(id, user.getFirstName(), user.getLastName(), user.getEmail(), user.getPassword(), user.getRole());
    }

    User findUserByEmail(String email);
}
