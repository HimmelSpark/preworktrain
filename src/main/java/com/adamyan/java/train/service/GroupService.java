package com.adamyan.java.train.service;

import com.adamyan.java.train.dto.GroupDTO;
import com.adamyan.java.train.repository.GroupRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GroupService {

    private final GroupRepository groupRepository;

    @Autowired
    public GroupService(GroupRepository groupRepository) {
        this.groupRepository = groupRepository;
    }

    public GroupDTO addGroup(GroupDTO groupDTO) {
        return groupRepository.createGroup(groupDTO);
    }

    public GroupDTO getById(Long id) {
        return groupRepository.getById(id);
    }

    public List<GroupDTO> getAllGroups() {
        return groupRepository.getAllGroups();
    }
}
