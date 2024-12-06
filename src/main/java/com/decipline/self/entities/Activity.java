package com.decipline.self.entities;

import com.decipline.self.dto.activity.WalkingActivity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CurrentTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.util.Date;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class Activity {

    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    private int id;

    private String name;


    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name="today_id", foreignKey = @ForeignKey(name = "FK_activity_today"))
    private Today today;

    @OneToMany(mappedBy = "activity", cascade = CascadeType.PERSIST)
    private List<WalkingActivity> walkingActivities;

    @UpdateTimestamp
    private Date createDate;

}
