package com.decipline.self.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class ActivityTotalCountDto {
    private int totalWalkingSteps;
    private int totalPushUp;

}
