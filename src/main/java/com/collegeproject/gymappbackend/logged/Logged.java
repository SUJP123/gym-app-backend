package com.collegeproject.gymappbackend.logged;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.UUID;

@Getter
@Setter
@Builder
@Entity
@Table(name = "logged")
public class Logged {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    private LocalDate date;

    private double weight;

    private Integer reps;

    private UUID exerciseId;

    public Logged(UUID id, LocalDate date, double weight, Integer reps, UUID exerciseId) {
        this.id = id;
        this.date = date;
        this.weight = weight;
        this.reps = reps;
        this.exerciseId = exerciseId;
    }

    public Logged() {
        super();
    }
}
