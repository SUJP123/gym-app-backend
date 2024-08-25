package com.collegeproject.gymappbackend.workout;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/workout")
public class WorkoutController {

    private WorkoutService workoutService;

    public WorkoutController(WorkoutService workoutService) {
        this.workoutService = workoutService;
    }

    @PostMapping
    public int addWorkout(@RequestBody  Workout workout) {
        return workoutService.addWorkout(workout);
    }
}
