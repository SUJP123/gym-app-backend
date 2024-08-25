package com.collegeproject.gymappbackend.user;


import org.springframework.web.bind.annotation.*;

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

}
