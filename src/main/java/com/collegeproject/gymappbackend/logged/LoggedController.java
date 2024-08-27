package com.collegeproject.gymappbackend.logged;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/logged")
public class LoggedController {

    private final LoggedService loggedService;

    public LoggedController(LoggedService loggedService) {
        this.loggedService = loggedService;
    }

    @PostMapping
    public int addLogged(@RequestBody Logged logged) {
        return loggedService.addLogged(logged);
    }
}
