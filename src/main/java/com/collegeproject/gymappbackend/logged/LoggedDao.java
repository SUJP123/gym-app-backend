package com.collegeproject.gymappbackend.logged;

import java.time.LocalDate;
import java.util.Date;
import java.util.UUID;

public interface LoggedDao {

    int insertLogged(UUID id, LocalDate date, double weight, Integer reps, UUID exerciseId);

    default int insertLogged(Logged logged) {
        UUID id = UUID.randomUUID();
        return insertLogged(id, logged.getDate(), logged.getWeight(), logged.getReps(), logged.getExerciseId());
    }


}
