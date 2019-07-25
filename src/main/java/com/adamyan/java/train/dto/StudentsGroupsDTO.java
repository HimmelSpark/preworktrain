package com.adamyan.java.train.dto;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class StudentsGroupsDTO {

    private Map<String, List<StudentDTO>> map;

    public StudentsGroupsDTO() {
        this.map = new LinkedHashMap<>();
    }

    public void addStudent(String groupName, StudentDTO studentDTO) {
        List<StudentDTO> list = map.get(groupName);
        if (list == null) {
            map.put(groupName, new ArrayList<>());
            list = map.get(groupName);
        }
        list.add(studentDTO);
    }

    public Map<String, List<StudentDTO>> getMap() {
        return map;
    }
}
