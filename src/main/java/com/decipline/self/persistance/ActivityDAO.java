package com.decipline.self.persistance;

import com.decipline.self.dto.ActivityTotalCountDto;
import com.decipline.self.entities.ExerciseRef;
import jakarta.persistence.EntityManager;
import jakarta.persistence.ParameterMode;
import jakarta.persistence.StoredProcedureQuery;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class ActivityDAO {

    private final EntityManager entityManager;
    public static final String TOTAL_WALKING_STEPS = "totalWalkingSteps";
    public static final String TOTAL_PUSH_UPS = "totalPushUps";
    public static final String PROC_CALCULATE_ACTIVITY_TOTALS = "CalculateActivityTotals";

    private final JdbcTemplate jdbcTemplate;


    @Transactional
    public ActivityTotalCountDto getActivityTotal(){

        ActivityTotalCountDto dto = new ActivityTotalCountDto();
        try{
            StoredProcedureQuery procedure = entityManager.createStoredProcedureQuery(PROC_CALCULATE_ACTIVITY_TOTALS);
            procedure.registerStoredProcedureParameter(TOTAL_WALKING_STEPS,Integer.class, ParameterMode.OUT);
            procedure.registerStoredProcedureParameter(TOTAL_PUSH_UPS,Integer.class, ParameterMode.OUT);
            procedure.execute();

            Integer walkingSteps = (Integer) procedure.getOutputParameterValue(TOTAL_WALKING_STEPS);
            Integer pushUps = (Integer) procedure.getOutputParameterValue(TOTAL_PUSH_UPS);
            dto.setTotalPushUp(pushUps);
            dto.setTotalWalkingSteps(walkingSteps);
        }catch (Exception e){
            e.printStackTrace();
            log.error("Exception while getting the data from procedure "+ PROC_CALCULATE_ACTIVITY_TOTALS);
        }
        return dto;
    }

    public boolean addExerciseRefData(ExerciseRef exerciseRef){
        String sql = "insert into ref_exe_type(exe_name) values (?)";
        int update = jdbcTemplate.update(sql, exerciseRef.getName());
        if (update != 0){
            return true;
        }
        return false;
    }

    public List<ExerciseRef> getAllExeRefTypes() {
        String sql = "select id, exe_name from ref_exe_type";
        return this.jdbcTemplate.query(sql, new RefRowMapper());
    }
}
