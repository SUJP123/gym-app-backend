package com.collegeproject.gymappbackend.workout;

import com.collegeproject.gymappbackend.exercise.Exercise;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

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

    @PostMapping("/exercise/{workoutId}")
    public int addExerciseToWorkout(@RequestBody Exercise exercise, @PathVariable("workoutId") UUID workoutId) {
        return workoutService.addExerciseToWorkout(exercise, workoutId);
    }

    @GetMapping("/{workoutId}")
    public List<Exercise> findExercisesForWorkout(@PathVariable("workoutId") UUID workoutId) {
        return workoutService.findExercisesForWorkout(workoutId);
    }

    @GetMapping("/search/{workoutId}")
    public Workout findWorkoutById(@PathVariable("workoutId") UUID workoutId) {
        return workoutService.findWorkoutById(workoutId);
    }
}
