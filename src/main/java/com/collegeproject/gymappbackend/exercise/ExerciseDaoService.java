package com.collegeproject.gymappbackend.exercise;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository("postgres_exercise")
public class ExerciseDaoService implements ExerciseDao{

    private JdbcTemplate jdbcTemplate;

    public ExerciseDaoService(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }


    @Override
    public int insertExercise(UUID exerciseId, String name, Integer sets, Integer reps, Integer rest, UUID workoutId) {
        if (exerciseId == null) {
            exerciseId = UUID.randomUUID();
        }
        String sql = "INSERT exercise_id, name, sets, reps, rest, workout_id INTO exercise (?, ?, ?, ?, ?, ?)";
        return jdbcTemplate.update(sql);
    }
}
