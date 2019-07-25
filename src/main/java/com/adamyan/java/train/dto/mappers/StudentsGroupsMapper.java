package com.adamyan.java.train.dto.mappers;

import com.adamyan.java.train.dto.StudentDTO;
import com.adamyan.java.train.dto.StudentsGroupsDTO;
import com.adamyan.java.train.entity.GroupStudentsEntity;
import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.Multimap;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Component
public class StudentsGroupsMapper implements RowMapper<StudentsGroupsDTO> {

    @Override
    public StudentsGroupsDTO mapRow(ResultSet resultSet, int i) throws SQLException {

//        List<GroupStudentsEntity> list = new ArrayList<>();
//
//        while (resultSet.next()) {
//            list.add(GroupStudentsEntity.newBuilder()
//                    .setGroupName(resultSet.getString("groupname"))
//                    .setName(resultSet.getString("name"))
//                    .setStudentId(resultSet.getLong("group_id"))
//                    .build());
//        }
//
//        return

        StudentsGroupsDTO studentsByGroups = new StudentsGroupsDTO();

        while (resultSet.next()) {
            studentsByGroups.addStudent(resultSet.getString("groupname"),
                    StudentDTO.newBuilder()
                            .setId(resultSet.getLong("id"))
                            .setName(resultSet.getString("name"))
                            .build());
        }
        return studentsByGroups;
    }
}
