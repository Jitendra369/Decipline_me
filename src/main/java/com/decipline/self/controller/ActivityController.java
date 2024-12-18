package com.decipline.self.controller;

import com.decipline.self.entities.*;
import com.decipline.self.service.ActivityService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/core/activity")
@CrossOrigin("*")
@Slf4j
public class ActivityController {

    private final ActivityService activityService;

    @PostMapping("/walk")
    public WalkingActivity saveWalkingAct(@RequestBody WalkingActivity walkingActivity){
        return activityService.saveWalkActi(walkingActivity);
    }

//    save reading activity
    @PostMapping("/read")
    public ReadingActivity saveReadingActi(@RequestBody ReadingActivity readingActivity){
        return activityService.saveReadingActi(readingActivity);
    }

    @GetMapping("/{id}")
    public Object getActivityById(@PathVariable int id){
        Optional<? extends Activity> activity = activityService.getActivity(id);
        if (activity.isPresent()){
            log.info("No activity present with Id " + id);
            return activity.get();
        }
        return Optional.empty();
    }

    @GetMapping("/read/all")
    public List<ReadingActivity> getAllReadingActivities(){
        return activityService.getAllReadingActivities();
    }

    @PostMapping("/weight/save")
    public WeightActivity saveWeightActivity(@RequestBody WeightActivity weightActivity){
        return activityService.saveWeightActivity(weightActivity);
    }

    @GetMapping("/weight/view/all")
    public List<WeightActivity> viewAllWeightActivities(){
        return activityService.viewAllWeightActivities();
    }

    @GetMapping("/read/hist")
    public List<ReadHistory> viewAllReadHistory(){
        return activityService.getAllReadHistory();
    }

    @DeleteMapping("/weight/{id}")
    public void deleteWeightActivity(@PathVariable int id ){
        activityService.deleteWeightActivity(id);
    }

    @GetMapping("/walk/all")
    public List<WalkingActivity> findAllWeightAct(){
        return activityService.getAllWeightActivity();
    }

// exe service

    @PostMapping("/exe")
    public ExerciseActivity addExerciseActivity(@RequestBody ExerciseActivity exerciseActivity){
        return activityService.addExerciseActivity(exerciseActivity);
    }

    @GetMapping("/exe/{id}")
    public ExerciseActivity viewExerciseAct(@PathVariable int id ){
        Optional<? extends Activity> activityOptional = activityService.getActivity(id);
        return (ExerciseActivity) activityOptional.orElse(null);
    }

    @GetMapping("/exe/all")
    public List<ExerciseActivity> getAllExeActivity(){
        return activityService.getAllExeActivity();
    }

    @PostMapping("/exe/type")
    public boolean addExerciseType(@RequestBody ExerciseRef exerciseRef){
        return activityService.addExerciseRefType(exerciseRef);
    }

    @GetMapping("/exe/ref")
    public List<ExerciseRef> getAllRefExeType(){
        return activityService.getAllRefTypes();
    }
}
