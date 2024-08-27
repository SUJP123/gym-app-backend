package com.collegeproject.gymappbackend.logged;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.UUID;

@Repository("postgres_logged")
public class LoggedDaoService implements LoggedDao{

    private JdbcTemplate jdbcTemplate;

    public LoggedDaoService(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public int insertLogged(UUID id, LocalDate date, double weight, Integer reps, UUID exerciseId) {
        if (id == null) {
            id = UUID.randomUUID();
        }
        final String sql = "INSERT INTO logged (id, date, weight, reps, exercise_id) VALUES (?, ?, ?, ?, ?)";
        return jdbcTemplate.update(sql, id, date, weight, reps, exerciseId);
    }
}
