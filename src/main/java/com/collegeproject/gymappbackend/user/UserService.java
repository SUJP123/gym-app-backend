package com.collegeproject.gymappbackend.user;

import com.collegeproject.gymappbackend.workout.Workout;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class UserService {


    private UserDao userDao;

    public UserService(@Qualifier("postgres") UserDao userDao) {
        this.userDao = userDao;
    }

    public int addUser(User user) {
        return userDao.insertUser(user);
    }

    public User findUserByEmail(String email) {
        return userDao.findUserByEmail(email);
    }

    public List<Workout> findUserWorkouts(UUID userId) {
        return userDao.getUserWorkouts(userId);
    }
}
