package com.decipline.self.service;

import com.decipline.self.dto.RefActivityTypeDto;
import com.decipline.self.entities.ReadingActivity;
import com.decipline.self.entities.WalkingActivity;
import com.decipline.self.repo.ActivityRepository;
import com.decipline.self.dto.ActivityTotalCountDto;
import com.decipline.self.entities.Activity;
import com.decipline.self.persistance.ActivityDAO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
@RequiredArgsConstructor
@Slf4j
public class ActivityService {

    public static final String UPDATED_DATE = "updatedDate";
    private final ActivityRepository activityRepository;
    private final ActivityDAO activityDAO;


    public String getNextWeightReadingDate() {
        return activityRepository.checkWeightReadingsBefore7Days();
    }

    private List<RefActivityTypeDto> mapRefActivityType(List<Object[]> objects) {
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

    public WalkingActivity saveWalkActi(WalkingActivity walkingActivity) {
        try {
            if (walkingActivity != null) {
                return activityRepository.save(walkingActivity);
            }
        } catch (Exception e) {
            log.error("Exception while saving the walking activity");
        }
        return null;
    }

    public ReadingActivity saveReadingActi(ReadingActivity readingActivity) {
        try {
            if (readingActivity.getId() == 0) {
                return null;
            }
            Optional<? extends Activity> readActOptional =  getActivity(readingActivity.getId());
            if (readActOptional.isPresent()) {
                ReadingActivity activity = (ReadingActivity) readActOptional.get();
//                if already present then update
                if (activity != null) {
                    if (activity.getPauseReadingBook() == null || activity.getPauseReadingBook()){
                        activity.setPauseReadingDate(new Date());
                    }
                    return activityRepository.save(activity);
                }
                return activityRepository.save(readingActivity);
            }
        } catch (Exception e) {
            e.printStackTrace();
            log.error("Exception while saving the reading Activity ");
        }
        return null;
    }

    //    base on the type of instance , will return the result
    public Optional<? extends Activity> getActivity(int id) {
        try {
            Optional<Activity> activityOptional = activityRepository.findById(id);
            if (activityOptional.isPresent()) {
                Optional<Activity> optionalActivity = Optional.of(activityOptional.get());
                if (optionalActivity.isPresent()) {
                    Activity activity = optionalActivity.get();
                    if (activity instanceof WalkingActivity) {
                        return Optional.of((WalkingActivity) activity);
                    } else if (activity instanceof ReadingActivity) {
                        return Optional.of((ReadingActivity) activity);
                    }
                }

            }
        } catch (Exception e) {
            e.printStackTrace();
            log.error("Exception while saving the reading Activity ");
        } return null;
    }

    public List<ReadingActivity> getAllReadingActivities() {
        List<ReadingActivity> allReadingActivity = new ArrayList<>();
        try {
            return activityRepository.findAllReadingActivity();
        } catch (Exception e) {
            e.printStackTrace();
            log.error("exception while getting all the reading Activities");
        }
        return allReadingActivity;
    }
}

