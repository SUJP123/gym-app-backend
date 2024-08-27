package com.collegeproject.gymappbackend.workout;

import com.collegeproject.gymappbackend.exercise.Exercise;

import java.util.List;
import java.util.UUID;

public interface WorkoutDao {

    int insertWorkout(UUID workoutId, String name, UUID userId);

    default int insertWorkout(Workout workout) {
        UUID id = UUID.randomUUID();
        return insertWorkout(id, workout.getName(), workout.getUserId());
    }

    int addExerciseToWorkout(Exercise exercise, UUID workoutId);

    List<Exercise> getAllExercisesByWorkoutId(UUID workoutId);


    Workout getWorkoutById(UUID workoutId);
}
