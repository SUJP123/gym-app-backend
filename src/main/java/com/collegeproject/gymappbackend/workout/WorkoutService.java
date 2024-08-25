package com.collegeproject.gymappbackend.workout;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class WorkoutService {

    private WorkoutDao workoutDao;

    public WorkoutService(@Qualifier("postgres_workout") WorkoutDao workoutDao) {
        this.workoutDao = workoutDao;
    }

    public int addWorkout(Workout workout) {
        return workoutDao.insertWorkout(workout);
    }
}
