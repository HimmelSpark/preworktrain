package com.adamyan.java.train.dto.mappers;


import com.adamyan.java.train.dto.GroupDTO;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;

@Component
public class GroupMapper implements RowMapper<GroupDTO> {

    @Override
    public GroupDTO mapRow(ResultSet resultSet, int i) throws SQLException {
        return new GroupDTO(resultSet.getLong("id"), resultSet.getString("groupname"));
    }
}