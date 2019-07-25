package com.adamyan.java.train.dto;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

public class GroupDTO {

    @JsonCreator
    public GroupDTO(
            @JsonProperty("groupID") Long groupID,
            @JsonProperty("groupName") String groupName) {
        this.groupID = groupID;
        this.groupName = groupName;
    }

    @Getter @Setter private Long groupID;
    @Getter @Setter private String groupName;
}
