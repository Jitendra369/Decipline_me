package com.decipline.self.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class Activity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;


//    @ManyToOne(cascade = CascadeType.PERSIST)
//    @JoinColumn(name="today_id", foreignKey = @ForeignKey(name = "FK_activity_today"))
//    private Today today;
//
//    @OneToMany(mappedBy = "activity", cascade = CascadeType.PERSIST)
//    private List<WalkingActivity> walkingActivities;

    @CreationTimestamp
    private Date createDate;

    @UpdateTimestamp
    private Date upDatedDate;

}
