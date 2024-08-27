package com.collegeproject.gymappbackend.exercise;

import com.collegeproject.gymappbackend.logged.Logged;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("api/v1/exercise")
public class ExerciseController {

    private final ExerciseService exerciseService;

    public ExerciseController(ExerciseService exerciseService) {
        this.exerciseService = exerciseService;
    }

    @PostMapping
    public int addExercise(@RequestBody Exercise exercise) {
        return exerciseService.addExercise(exercise);
    }

    @GetMapping("/{exerciseId}/{date}")
    public List<Logged> findLoggedFromExerciseIdAndDate(@PathVariable("exerciseId") UUID exerciseId,
                                                        @PathVariable("date") LocalDate date) {
        return exerciseService.findLoggedFromExerciseIdAndDate(exerciseId, date);
    }

    @GetMapping("/{exerciseId}")
    public Exercise findExerciseById(@PathVariable("exerciseId") UUID exerciseId) {
        return exerciseService.findExerciseById(exerciseId);
    }

}
