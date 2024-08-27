package com.collegeproject.gymappbackend.exercise;

import com.collegeproject.gymappbackend.logged.Logged;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@Service
public class ExerciseService {

    private ExerciseDao exerciseDao;

    public ExerciseService(@Qualifier("postgres_exercise") ExerciseDao exerciseDao) {
        this.exerciseDao = exerciseDao;
    }

    public int addExercise(Exercise exercise) {
        return exerciseDao.insertExercise(exercise);
    }

    public List<Logged> findLoggedFromExerciseIdAndDate(UUID exerciseId, LocalDate date) {
        return exerciseDao.obtainLoggedFromExerciseIdAndDate(exerciseId, date);
    }

    public Exercise findExerciseById(UUID exerciseId) {
        return exerciseDao.getExerciseById(exerciseId);
    }
}
