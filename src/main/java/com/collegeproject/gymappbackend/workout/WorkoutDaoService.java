package com.collegeproject.gymappbackend.workout;

import com.collegeproject.gymappbackend.exercise.Exercise;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.Collections;
import java.util.List;
import java.util.UUID;

@Repository("postgres_workout")
public class WorkoutDaoService implements WorkoutDao{

    private JdbcTemplate jdbcTemplate;

    public WorkoutDaoService(JdbcTemplate jdbcTemplate) { this.jdbcTemplate = jdbcTemplate;}


    @Override
    public int insertWorkout(UUID workoutId, String name, UUID userId) {
        if (workoutId == null) {
            workoutId = UUID.randomUUID();
        }
        String sql = "INSERT INTO workouts (workout_id, name, user_id) VALUES (?, ?, ?)";
        return jdbcTemplate.update(sql, workoutId, name, userId);
    }

    @Override
    public int addExerciseToWorkout(Exercise exercise, UUID workoutId) {
        final String sql = "UPDATE exercise SET workout_id = " + workoutId
                + " WHERE exercise_id = " + exercise.getExerciseId();
        return jdbcTemplate.update(sql);
    }

    @Override
    public List<Exercise> getAllExercisesByWorkoutId(UUID workoutId) {
        final String sql = "SELECT * FROM exercise WHERE workout_id = ?";
        return jdbcTemplate.query(sql, new Object[]{workoutId}, (resultSet, i) -> {
            UUID exerciseId = UUID.fromString(resultSet.getString("exercise_id"));
            String name = resultSet.getString("name");
            Integer sets = Integer.valueOf(resultSet.getString("sets"));
            Integer reps = Integer.valueOf(resultSet.getString("reps"));
            Integer rest = Integer.valueOf(resultSet.getString("rest"));
            return new Exercise(exerciseId, name, sets, reps, rest, workoutId);
        });
    }

    @Override
    public Workout getWorkoutById(UUID workoutId) {
        final String sql = "SELECT * FROM workouts WHERE workout_id = ?";
        return jdbcTemplate.queryForObject(sql, new Object[]{workoutId}, (resultSet, i) -> {
            String name = resultSet.getString("name");
            UUID userId = UUID.fromString(resultSet.getString("user_id"));
            return new Workout(workoutId, name, userId);
        });
    }
}
