package com.decipline.self.dto.activity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "activity_type", discriminatorType = DiscriminatorType.STRING)
public class ActivityId {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; // Primary key for Activity

    private String name;  // Common attribute for all activities

    @Column(unique = true)
    private String activityId;

}
