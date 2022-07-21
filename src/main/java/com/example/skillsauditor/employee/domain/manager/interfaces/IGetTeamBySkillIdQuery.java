package com.example.skillsauditor.employee.domain.manager.interfaces;

import com.example.skillsauditor.employee.application.manager.queries.GetTeamBySkillIdQuery;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

@JsonDeserialize(as = GetTeamBySkillIdQuery.class)
public interface IGetTeamBySkillIdQuery {

    String getManagerId();
    String getSkillId();
}
