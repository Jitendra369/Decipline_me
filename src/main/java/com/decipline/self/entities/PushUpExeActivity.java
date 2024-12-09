package com.decipline.self.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "pushUp_activity")
public class PushUpExeActivity extends AbstractExerciseActivity{

    private String name;

}
