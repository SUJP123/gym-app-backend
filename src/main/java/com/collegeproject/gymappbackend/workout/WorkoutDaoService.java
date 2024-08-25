package com.collegeproject.gymappbackend.workout;

import com.collegeproject.gymappbackend.exercise.Exercise;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository("postgres_workout")
public class WorkoutDaoService implements WorkoutDao{

    private JdbcTemplate jdbcTemplate;

    public WorkoutDaoService(JdbcTemplate jdbcTemplate) { this.jdbcTemplate = jdbcTemplate;}


    @Override
    public int insertWorkout(UUID workoutId, String name, List<UUID> exerciseIds, UUID userId) {
        if (workoutId == null) {
            workoutId = UUID.randomUUID();
        }
        String sql = "INSERT workout_id, name, exercise_ids, user_id INTO workouts (?, ?, ?, ?)";
        return jdbcTemplate.update(sql);
    }

    @Override
    public List<Exercise> getAllExercisesByWorkoutId() {
        return null;
    }
}
