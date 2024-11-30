package com.decipline.self.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CurrentTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class Activity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private int walkingSteps;
    private int pushUps;
    private boolean reading;
    private boolean writing;
    private String written_text;
    private int weight;
    private boolean selfAnalysis;
    private String excuse;

    private Date createdDate;

    @UpdateTimestamp
    private Date updatedDate;

}
