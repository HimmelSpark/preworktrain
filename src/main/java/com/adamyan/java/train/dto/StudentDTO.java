package com.adamyan.java.train.dto;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

public class StudentDTO {

    @Getter @Setter private Long id;
    @Getter @Setter private String name;
    @Getter @Setter private Long group_id;

    @JsonCreator
    public StudentDTO(
            @JsonProperty("id") Long id,
            @JsonProperty("name") String name,
            @JsonProperty("group_id") Long group_id
    ) {
        this.id = id;
        this.name = name;
        this.group_id = group_id;
    }

    private StudentDTO(){}

    public static Builder newBuilder() {
        return new StudentDTO().new Builder();
    }

    public class Builder {

        private Builder(){}

        public Builder setId(Long id) {
            StudentDTO.this.setId(id);
            return this;
        }

        public Builder setName(String name) {
            StudentDTO.this.setName(name);
            return this;
        }

        public Builder setGroupId(Long groupId) {
            StudentDTO.this.setGroup_id(groupId);
            return this;
        }

        public StudentDTO build() {
            return StudentDTO.this;
        }
    }
}
