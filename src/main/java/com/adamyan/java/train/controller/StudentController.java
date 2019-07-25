package com.adamyan.java.train.controller;

import com.adamyan.java.train.dto.StudentDTO;
import com.adamyan.java.train.dto.StudentsGroupsDTO;
import com.adamyan.java.train.service.StudentService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/rest/student")
public class StudentController {

    private final StudentService studentService;

    @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @PostMapping("/create")
    public ResponseEntity createStudent(@RequestBody StudentDTO studentDTO) {
        return ResponseEntity.status(HttpStatus.OK).body(studentService.createStudent(studentDTO));
    }

    @GetMapping("/all")
    public ResponseEntity getAllStudens() {
        return ResponseEntity.status(HttpStatus.OK).body(studentService.getAllStudents());
    }

    @GetMapping("/all_by_groups")
    public ResponseEntity getAllStudentsByGroups() {
        StudentsGroupsDTO data = studentService.getAllStudentsByGroups();
        return ResponseEntity.status(HttpStatus.OK).body(data);
    }

    @GetMapping("/test")
    public ResponseEntity test() {
        Map<String, List<StudentDTO>> map = new LinkedHashMap<>();
        StudentDTO studentDTO = new StudentDTO(1L, "asd", 2L);
        map.put("group1", Arrays.asList(studentDTO));
        return ResponseEntity.status(HttpStatus.OK).body(map);
    }

}
