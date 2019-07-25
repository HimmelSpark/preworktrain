package com.adamyan.java.train.repository;

import com.adamyan.java.train.dto.StudentDTO;
import com.adamyan.java.train.dto.StudentsGroupsDTO;
import com.adamyan.java.train.dto.mappers.StudentsGroupsMapper;
import com.adamyan.java.train.dto.mappers.StudentsMapper;
import com.google.common.collect.Multimap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository // Transactional
public class StudentRepository {

    private final JdbcTemplate jdbc;
    private final StudentsMapper studentsMapper;
    private final StudentsGroupsMapper studentsGroupsMapper;

    @Autowired
    public StudentRepository(
            JdbcTemplate jdbc,
            StudentsMapper studentsMapper,
            StudentsGroupsMapper studentsGroupsMapper) {
        this.jdbc = jdbc;
        this.studentsMapper = studentsMapper;
        this.studentsGroupsMapper = studentsGroupsMapper;
    }

    public StudentDTO createStudent(StudentDTO studentDTO) {
        String sql = "INSERT INTO students (name, group_id) VALUES (?, ?) RETURNING id";
        Long id = jdbc.queryForObject(sql, new Object[] {studentDTO.getName(), studentDTO.getGroup_id()}, Long.class);
        studentDTO.setId(id);
        return studentDTO;
    }

    public List<StudentDTO> getAllStudents() {
        String sql = "SELECT * FROM students";
        List<StudentDTO> students = jdbc.query(sql, studentsMapper);
        return students;
    }

    public StudentsGroupsDTO getAllStudentsByGroups() {
        String sql = "SELECT groupname, S.name, S.id FROM groups JOIN students AS S ON (groups.id = S.group_id)";
        StudentsGroupsDTO studentsBGroups = null;
        try (Connection connection = jdbc.getDataSource().getConnection()) {
            PreparedStatement pst = connection.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
            studentsBGroups = studentsGroupsMapper.mapRow(rs, 0); //TODO опасно!
            return studentsBGroups;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return studentsBGroups;
    }

}
