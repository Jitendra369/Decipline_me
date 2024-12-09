package com.decipline.self.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Entity
@RequiredArgsConstructor
@Table(name = "walking_activity")
public class WalkingActivity extends Activity {

    private float distanceTravel;
    private float time;

//    @ManyToOne
//    @JoinColumn(name = "activity_id", nullable = true)
//    private Activity activity;


}
