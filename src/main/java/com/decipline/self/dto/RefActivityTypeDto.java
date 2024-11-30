package com.decipline.self.dto;

import lombok.Data;

import java.util.Date;

@Data
public class RefActivityTypeDto {

    private int id;
    private String name;
    private String description;
    private Date createdDate;
}
