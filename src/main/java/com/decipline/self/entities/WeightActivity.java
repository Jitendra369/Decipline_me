package com.decipline.self.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Entity
@RequiredArgsConstructor
@Getter
@Setter
public class WeightActivity extends Activity{
    private Integer weight;

    @Column(name = "wt_date")
    private Date weightDate;

}
