package com.collegeproject.gymappbackend.exercise;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class ExerciseService {

    private ExerciseDao exerciseDao;

    public ExerciseService(@Qualifier("postgres_exercise") ExerciseDao exerciseDao) {
        this.exerciseDao = exerciseDao;
    }

    public int addExercise(Exercise exercise) {
        return exerciseDao.insertExercise(exercise);
    }
}
