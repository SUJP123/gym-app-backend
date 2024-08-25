package com.collegeproject.gymappbackend.workout;

import com.collegeproject.gymappbackend.exercise.Exercise;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
import java.util.UUID;

@Getter
@Setter
@Builder
@Entity
@Table(name = "workouts")
public class Workout {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID workoutId;

    private String name;

    @ElementCollection
    private List<UUID> exerciseIds;

    private UUID userId;

    public Workout() {
        super();
    }

    public Workout(UUID workoutId, String name, List<UUID> exerciseIds, UUID userId) {
        this.workoutId = workoutId;
        this.name = name;
        this.exerciseIds = exerciseIds;
        this.userId = userId;
    }
}
