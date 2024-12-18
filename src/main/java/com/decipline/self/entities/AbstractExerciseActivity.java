package com.decipline.self.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.util.Date;

//@Entity
@Getter
@Setter
@RequiredArgsConstructor
//@Table(name = "exercise_Activity")
public class AbstractExerciseActivity extends Activity {

    private int count;
    private Date logDate;
}
