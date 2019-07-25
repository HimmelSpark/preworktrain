package com.adamyan.java.train.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
public class GroupStudentsEntity {

    @Getter @Setter private String groupName;
    @Getter @Setter private Long StudentId;
    @Getter @Setter private String name;

    public static Builder newBuilder() {
        return new GroupStudentsEntity().new Builder();
    }

    public class Builder {
        private Builder() {}

        public Builder setName(String name) {
            GroupStudentsEntity.this.setName(name);
            return this;
        }

        public Builder setGroupName(String groupName) {
            GroupStudentsEntity.this.setGroupName(name);
            return this;
        }

        public Builder setStudentId(Long id) {
            GroupStudentsEntity.this.setStudentId(id);
            return this;
        }

        public GroupStudentsEntity build() {
            return GroupStudentsEntity.this;
        }

    }
}
