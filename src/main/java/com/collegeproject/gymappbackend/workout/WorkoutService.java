package com.collegeproject.gymappbackend.workout;

import com.collegeproject.gymappbackend.exercise.Exercise;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class WorkoutService {

    private WorkoutDao workoutDao;

    public WorkoutService(@Qualifier("postgres_workout") WorkoutDao workoutDao) {
        this.workoutDao = workoutDao;
    }

    public int addWorkout(Workout workout) {
        return workoutDao.insertWorkout(workout);
    }

    public int addExerciseToWorkout(Exercise exercise, UUID workoutId) {
        return workoutDao.addExerciseToWorkout(exercise, workoutId);
    }

    public List<Exercise> findExercisesForWorkout(UUID workoutId) {
        return workoutDao.getAllExercisesByWorkoutId(workoutId);
    }

    public Workout findWorkoutById(UUID workoutId) {
        return workoutDao.getWorkoutById(workoutId);
    }
}
