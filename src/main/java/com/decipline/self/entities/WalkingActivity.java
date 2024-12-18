package com.decipline.self.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import java.util.Date;

@Getter
@Setter
@Entity
@RequiredArgsConstructor
@Table(name = "walking_activity")
public class WalkingActivity extends Activity {

    private float distanceTravel;
    private float time;

    @CreationTimestamp
    private Date createdDate;

    @Column(name = "log_date")
    private Date logDate;

    @Column(name = "wal_dist")
    private Integer walkingDistance;

    @Column(name = "run_dist")
    private Integer runningDistance;

//    @ManyToOne
//    @JoinColumn(name = "activity_id", nullable = true)
//    private Activity activity;


}
