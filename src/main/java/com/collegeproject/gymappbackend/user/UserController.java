package com.collegeproject.gymappbackend.user;


import com.collegeproject.gymappbackend.workout.Workout;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("api/v1/user")
public class UserController {

    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    public int addUser(User user) {
        return userService.addUser(user);
    }

    @GetMapping("/{email}")
    public User findUserByEmail(@PathVariable("email") String email) {
        return userService.findUserByEmail(email);
    }

    @GetMapping("/{userId}/workouts")
    public List<Workout> findUserWorkouts(@PathVariable("userId") UUID userId) {
        return userService.findUserWorkouts(userId);
    }

}
