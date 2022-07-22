package com.example.skillsauditor.skill.domain.common;

import com.example.skillsauditor.employee.domain.common.AssertionConcern;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public abstract class IdentifiedValueObject extends AssertionConcern {
    private long id = -1; //surrogate id for ORM

    protected long id(){
        return id;
    }
}
