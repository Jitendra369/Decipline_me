package com.decipline.self.persistance;

import com.decipline.self.entities.ExerciseRef;
import org.springframework.jdbc.core.RowCallbackHandler;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class RefRowMapper implements RowMapper<ExerciseRef> {

    @Override
    public ExerciseRef mapRow(ResultSet rs, int rowNum) throws SQLException {
            ExerciseRef exerciseRef = new ExerciseRef();
            String id = rs.getString("id");
            String exeName = rs.getString("exe_name");
            exerciseRef.setId(Integer.parseInt(id));
            exerciseRef.setName(exeName);
            return exerciseRef;
    }
}
