package com.decipline.self.dto.activity;

import com.decipline.self.entities.Activity;
import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class WalkingActivity extends Activity {

    private float distanceTravel;

    @ManyToOne
    @JoinColumn(name = "activity_id", nullable = true)
    private Activity activity;

}
