package com.decipline.self.service;

import com.decipline.self.dto.RefActivityTypeDto;
import com.decipline.self.dto.activity.WalkingActivity;
import com.decipline.self.entities.Today;
import com.decipline.self.repo.ActivityRepository;
import com.decipline.self.dto.ActivityTotalCountDto;
import com.decipline.self.entities.Activity;
import com.decipline.self.persistance.ActivityDAO;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.sql.Ref;
import java.util.*;

@Service
@RequiredArgsConstructor
@Slf4j
public class ActivityService {

    public static final String UPDATED_DATE = "updatedDate";
    private final ActivityRepository activityRepository;
    private final ActivityDAO activityDAO;

    public Activity addActivity(Activity activity){

//        for previous date
//        if (activity.getCreatedDate() == null){
//            activity.setCreatedDate(new Date());
//        }
//        Activity saveActivity = activityRepository.save(activity);
//        return saveActivity;
//    }
//
//    public List<Activity> getAllActivity(){
//        List<Activity> allActivityList = activityRepository.findAll();
//        if (!allActivityList.isEmpty()){
//            List<Activity> sortedCreatedDateActivities = allActivityList.stream().sorted(Comparator.comparing(Activity::getCreatedDate).reversed()).toList();
//            return sortedCreatedDateActivities;
//        }
//        return new ArrayList<>();
        return null;
    }

//    sorted list
    public void findAllSortedActivity(){
        Sort sort = Sort.by(Sort.Order.desc(UPDATED_DATE));
        activityRepository.findAll(sort);
    }

    public Activity findActivityById(int id){
        Activity activity = activityRepository.findById(id).orElseThrow(() -> new RuntimeException("no data found having id " + id));
        log.info("getting activity for for activity id "+ id);
        return activity;
    }

    public String getNextWeightReadingDate(){
        return activityRepository.checkWeightReadingsBefore7Days();
    }

    public int getAllWalkingSteps(){

//        int walkingSteps = 0;
//        List<Activity> allActivitys = this.activityRepository.findAll();
//        for (Activity activity : allActivitys){
//            walkingSteps = walkingSteps + activity.getWalkingSteps();
//        }
//        return walkingSteps;
        int i = activityRepository.finaAllWalkingStepsTotal();
        return i;
    }

    public ActivityTotalCountDto getTotalActivityCount(){
        ActivityTotalCountDto activityTotal = activityDAO.getActivityTotal();
        return activityTotal;
    }

    public List<Date> findReadingDate(){
        return this.activityRepository.findReadingActivityCount();
    }

    public List<RefActivityTypeDto> getActivityType(){
        List<Object[]> refActivityTypes = activityRepository.getRefActivityTypes();
        return mapRefActivityType(refActivityTypes);
    }

    private List<RefActivityTypeDto> mapRefActivityType(List<Object[]> objects){
        List<RefActivityTypeDto> refList = new ArrayList<>();
        objects.forEach(object -> {
            RefActivityTypeDto refActivityTypeDto = new RefActivityTypeDto();
            refActivityTypeDto.setId(object[0] != null ? (Integer) object[0] : 0);
            refActivityTypeDto.setName(object[1] != null ? (String) object[1] : "");
            refActivityTypeDto.setDescription(object[2] != null ? (String) object[2] : "");
            refActivityTypeDto.setCreatedDate((Date) object[3]);
            refList.add(refActivityTypeDto);
        });
        return refList;
    }

    public Activity saveActivity(WalkingActivity walkingActivity){
        Activity activity = new Activity();
        Today today = new Today();
        today.setCreatedDate(new Date());
        activity.setToday(today);
        walkingActivity.setToday(today);
        walkingActivity.setActivity(activity);
        return activityRepository.save(walkingActivity);
    }
}

