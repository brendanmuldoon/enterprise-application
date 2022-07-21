package com.example.skillsauditor.employee.application.manager.queries;

import com.example.skillsauditor.employee.domain.manager.interfaces.IGetTeamBySkillIdQuery;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class GetTeamBySkillIdQuery implements IGetTeamBySkillIdQuery {

    private String managerId;
    private String skillId;

}
