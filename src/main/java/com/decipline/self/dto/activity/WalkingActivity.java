package com.decipline.self.dto.activity;

import com.decipline.self.entities.Activity;
import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@DiscriminatorValue("WALKING")
public class WalkingActivity extends ActivityId {

    private String sportType;
    private boolean active;
}
