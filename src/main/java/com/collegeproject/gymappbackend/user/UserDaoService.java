package com.collegeproject.gymappbackend.user;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository("postgres")
public class UserDaoService implements UserDao{

    private JdbcTemplate jdbcTemplate;

    public UserDaoService(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
    @Override
    public int insertUser(UUID id, String firstName, String lastName, String email, String password, Role role) {
        if (id == null) {
            id = UUID.randomUUID();
        }
        String sql = "INSERT id, first_name, last_name, email, password, role INTO users (?, ?, ?, ?, ?, ?)";
        return jdbcTemplate.update(sql);
    }

    @Override
    public User findUserByEmail(String email) {
        String sql = "SELECT * FROM users WHERE email = ?";
        return jdbcTemplate.queryForObject(sql, new Object[]{email}, (resultSet, i) -> {
            UUID id = UUID.fromString(resultSet.getString("id"));
            String firstName = resultSet.getString("first_name");
            String lastName = resultSet.getString("last_name");
            String password = resultSet.getString("password");
            Role role = Role.valueOf(resultSet.getString("role"));
            return new User(id, firstName, lastName, email, password, role);
        });
    }
}
