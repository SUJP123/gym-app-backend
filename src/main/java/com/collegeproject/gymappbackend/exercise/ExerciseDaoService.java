package com.collegeproject.gymappbackend.exercise;

import com.collegeproject.gymappbackend.logged.Logged;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
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
        String sql = "INSERT INTO exercise (exercise_id, name, sets, reps, rest, workout_id) VALUES (?, ?, ?, ?, ?, ?)";
        return jdbcTemplate.update(sql, exerciseId, name, sets, reps, rest, workoutId);
    }

    @Override
    public List<Logged> obtainLoggedFromExerciseIdAndDate(UUID exerciseId, LocalDate date) {
        final String sql = "SELECT * FROM logged WHERE exercise_id = ? AND date = ?";
        return (jdbcTemplate.query(sql, new Object[]{exerciseId, date}, (resultSet, i) -> {
            UUID id = UUID.fromString(resultSet.getString("id"));
            double weight = Double.parseDouble(resultSet.getString("weight"));
            Integer reps = Integer.valueOf(resultSet.getString("reps"));
            return new Logged(id, date, weight, reps, exerciseId);
        }));
    }

    @Override
    public Exercise getExerciseById(UUID exerciseId) {
        final String sql = "SELECT * FROM exercise WHERE exercise_id = ?";
        return jdbcTemplate.queryForObject(sql, new Object[]{exerciseId}, (resultSet, i) -> {
            String name = resultSet.getString("name");
            Integer sets = Integer.valueOf(resultSet.getString("sets"));
            Integer reps = Integer.valueOf(resultSet.getString("reps"));
            Integer rest = Integer.valueOf(resultSet.getString("rest"));
            UUID workoutId = UUID.fromString(resultSet.getString("workout_id"));
            return new Exercise(exerciseId, name, sets, reps, rest, workoutId);
        });
    }
}
