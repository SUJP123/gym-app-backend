package com.collegeproject.gymappbackend.exercise;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
@Builder
@Entity
@Table(name="exercise")
public class Exercise {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID exerciseId;

    private String name;

    private Integer sets;

    private Integer reps;

    // Time in seconds for rest period
    private Integer rest;

    private UUID workoutId;

    public Exercise() {
        super();
    }

    public Exercise(String name, Integer sets, Integer reps, Integer rest, UUID workoutId) {
        this.name = name;
        this.sets = sets;
        this.reps = reps;
        this.rest = rest;
        this.workoutId = workoutId;
    }
}
