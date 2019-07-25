package com.adamyan.java.train.service;

import com.adamyan.java.train.dto.StudentDTO;
import com.adamyan.java.train.dto.StudentsGroupsDTO;
import com.adamyan.java.train.repository.StudentRepository;
import com.google.common.collect.Multimap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

    private final StudentRepository studentRepository;

    @Autowired
    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public StudentDTO createStudent(StudentDTO studentDTO) {
        return studentRepository.createStudent(studentDTO);
    }

    public List<StudentDTO> getAllStudents() {
        return studentRepository.getAllStudents();
    }

    public StudentsGroupsDTO getAllStudentsByGroups() {
        return studentRepository.getAllStudentsByGroups();
    }

}
