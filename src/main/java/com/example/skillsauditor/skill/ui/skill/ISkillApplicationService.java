package com.example.skillsauditor.skill.ui.skill;

import com.example.skillsauditor.employee.application.manager.commands.DeleteSkillCommand;
import com.example.skillsauditor.employee.application.manager.commands.EditSkillCommand;
import com.example.skillsauditor.employee.domain.manager.interfaces.ICreateSkillCommand;

public interface ISkillApplicationService {
    //void createSkill(ICreateSkillCommand createSkillCommand);

    //void editSkill(EditSkillCommand editSkillCommand);

    void deleteSkill(DeleteSkillCommand deleteSkillCommand);
}
