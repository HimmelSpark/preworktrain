package com.adamyan.java.train.dto.mappers;

import com.adamyan.java.train.dto.StudentDTO;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Component
public class StudentsMapper implements RowMapper {
    @Override
    public Object mapRow(ResultSet resultSet, int i) throws SQLException {
        List<StudentDTO> students = new ArrayList<>();
        while (resultSet.next()) {
            students.add(new StudentDTO(
                    resultSet.getLong("id"),
                    resultSet.getString("name"),
                    resultSet.getLong("group_id"))
            );
        }
        return students;
    }
}
