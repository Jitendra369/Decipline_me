package com.decipline.self.controller;

import com.decipline.self.dto.ActivityTotalCountDto;
import com.decipline.self.dto.RefActivityTypeDto;
import com.decipline.self.entities.Activity;
import com.decipline.self.service.ActivityService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/core/activity")
@CrossOrigin("*")
public class ActivityController {

    private final ActivityService activityService;

    @PostMapping()
    public Activity addActivity(@RequestBody Activity activity){
        return activityService.addActivity(activity);
    }

    @GetMapping("/all")
    public List<Activity> getAllActivity(){
        return activityService.getAllActivity();
    }

    @GetMapping("/{id}")
    public Activity findActivity(@PathVariable int id){
        return activityService.findActivityById(id);
    }

    @GetMapping("/checkNextWeightDate")
    public String checkNextWeightDate(){
        return activityService.getNextWeightReadingDate();
    }

    @GetMapping("/all/walking")
    public int getAllWalkingSteps(){
        int allWalkingSteps = this.activityService.getAllWalkingSteps();
        return allWalkingSteps;
    }

    @GetMapping("/count/all")
    public ActivityTotalCountDto countActivityAll(){
        ActivityTotalCountDto totalActivityCount = this.activityService.getTotalActivityCount();
        return totalActivityCount;
    }

    @GetMapping("/reading/dates")
    public List<Date> findReadingCountDate(){
        return activityService.findReadingDate();
    }

    @GetMapping("/ref_activity")
    public List<RefActivityTypeDto> getAllRefActivityType(){
        return activityService.getActivityType();
    }
}
