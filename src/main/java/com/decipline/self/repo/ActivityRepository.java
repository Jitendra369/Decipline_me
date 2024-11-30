package com.decipline.self.repo;

import com.decipline.self.dto.RefActivityTypeDto;
import com.decipline.self.entities.Activity;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;
import java.util.Objects;

@Repository
public interface ActivityRepository extends JpaRepository<Activity, Integer> {

    List<Activity> findAll(Sort sort);

    @Procedure(procedureName = "CheckWeightReadingsBefore7Days")
    String checkWeightReadingsBefore7Days();

    @Query(value = "select sum(walking_steps) as totalSteps from activity", nativeQuery = true)
    int finaAllWalkingStepsTotal();

    @Query(value = "select created_date from activity where reading = 1 order by created_date desc;", nativeQuery = true)
    List<Date> findReadingActivityCount();

    @Query(value = "select * from ref_activity_type;" , nativeQuery = true)
    List<Object[]> getRefActivityTypes();

}