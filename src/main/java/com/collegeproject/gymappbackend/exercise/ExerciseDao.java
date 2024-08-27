package com.collegeproject.gymappbackend.exercise;

import com.collegeproject.gymappbackend.logged.Logged;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

public interface ExerciseDao {

    int insertExercise(UUID exerciseId, String name, Integer sets, Integer reps, Integer rest, UUID workoutId);

    default int insertExercise(Exercise exercise) {
        UUID id = UUID.randomUUID();
        return insertExercise(id, exercise.getName(), exercise.getSets(), exercise.getReps(), exercise.getRest(), exercise.getWorkoutId());
    }

    List<Logged> obtainLoggedFromExerciseIdAndDate(UUID exerciseId, LocalDate date);

    Exercise getExerciseById(UUID exerciseId);
}
