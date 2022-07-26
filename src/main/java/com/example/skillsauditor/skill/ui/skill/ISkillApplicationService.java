package com.example.skillsauditor.skill.ui.skill;

import com.example.skillsauditor.employee.domain.common.Identity;
import com.example.skillsauditor.skill.domain.skill.interfaces.ICreateSkillCommand;

public interface ISkillApplicationService {
    void createSkill(ICreateSkillCommand createSkillCommand);
}
