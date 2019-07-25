package com.adamyan.java.train.repository;

import com.adamyan.java.train.dto.GroupDTO;
import com.adamyan.java.train.dto.mappers.GroupMapper;
import com.adamyan.java.train.dto.mappers.GroupsMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class GroupRepository {

    private final JdbcTemplate jdbc;
    private final GroupMapper groupMapper;
    private final GroupsMapper groupsMapper;

    @Autowired
    public GroupRepository(JdbcTemplate jdbc, GroupMapper groupMapper, GroupsMapper groupsMapper) {
        this.jdbc = jdbc;
        this.groupMapper = groupMapper;
        this.groupsMapper = groupsMapper;
    }

    public GroupDTO createGroup(GroupDTO groupDTO) {
        String sql = "INSERT INTO groups (groupname) VALUES (?) RETURNING id";
        Long id = jdbc.queryForObject(sql, new Object[] {groupDTO.getGroupName()}, Long.class);
        groupDTO.setGroupID(id);
        return groupDTO;
    }

    public GroupDTO getById(Long id) {
        String sql = "SELECT * FROM groups WHERE id = ?";
        GroupDTO groupDTO = jdbc.queryForObject(sql, groupMapper, id);
        return groupDTO;
    }

    public List<GroupDTO> getAllGroups() {
        String sql = "SELECT * FROM groups";
        List<GroupDTO> groups = jdbc.query(sql, groupMapper);
        return groups;
    }

}
