package com.example.skillsauditor.employee.ui.manager;

import com.example.skillsauditor.employee.application.manager.commands.DeleteSkillCommand;
import com.example.skillsauditor.employee.application.manager.commands.EditSkillCommand;
import com.example.skillsauditor.employee.domain.manager.interfaces.IUpdateManagerTeamCommand;
import com.example.skillsauditor.employee.application.manager.commands.CreateSkillCommand;

public interface IManagerApplicationService {
    void addStaffToManagerTeam(IUpdateManagerTeamCommand updateManagerTeamCommand);

    void createSkill(CreateSkillCommand createSkillCommand);

    void editSkill(EditSkillCommand editSkillCommand);

    void deleteSkill(DeleteSkillCommand deleteSkillCommand);
}
