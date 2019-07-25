package com.adamyan.java.train.controller;

import com.adamyan.java.train.dto.GroupDTO;
import com.adamyan.java.train.service.GroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/rest/group")
public class GroupController {

    private final GroupService groupService;

    @Autowired
    public GroupController(GroupService groupService) {
        this.groupService = groupService;
    }


    @PostMapping("/create")
    public ResponseEntity create(@RequestBody GroupDTO groupDTO) {
        return ResponseEntity.status(HttpStatus.OK).body(groupService.addGroup(groupDTO));
    }

    @GetMapping("/getbyid/{id}")
    public ResponseEntity getById(@PathVariable(name = "id") Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(groupService.getById(id));
    }

    @GetMapping("/all")
    public ResponseEntity getAllGroups() {
        return ResponseEntity.status(HttpStatus.OK).body(groupService.getAllGroups());
    }
}
