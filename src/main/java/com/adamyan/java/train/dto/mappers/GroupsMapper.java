package com.adamyan.java.train.dto.mappers;

import com.adamyan.java.train.dto.GroupDTO;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Component
public class GroupsMapper implements RowMapper<List<GroupDTO>> {
    @Override
    public List<GroupDTO> mapRow(ResultSet resultSet, int i) throws SQLException {
        List<GroupDTO> groups = new ArrayList<>();
        do {
            groups.add(new GroupDTO(resultSet.getLong("id"), resultSet.getString("groupName")));
        } while (resultSet.isAfterLast());
        return groups;
    }
}
