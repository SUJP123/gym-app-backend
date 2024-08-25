package com.collegeproject.gymappbackend.exercise;

import java.awt.*;
import java.util.UUID;

public interface ExerciseDao {

    int insertExercise(UUID exerciseId, String name, Integer sets, Integer reps, Integer rest, UUID workoutId);

    default int insertExercise(Exercise exercise) {
        UUID id = UUID.randomUUID();
        return insertExercise(id, exercise.getName(), exercise.getSets(), exercise.getReps(), exercise.getRest(), exercise.getWorkoutId());
    }
}
