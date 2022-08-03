package com.example.skillsauditor.employee.ui.manager;

import com.example.skillsauditor.employee.application.manager.commands.*;
import com.example.skillsauditor.employee.domain.manager.interfaces.IUpdateManagerTeamCommand;
import com.example.skillsauditor.employee.domain.manager.interfaces.ICreateCategoryCommand;
import com.example.skillsauditor.skill.domain.skill.interfaces.IDeleteCategoryCommand;
import com.example.skillsauditor.skill.domain.skill.interfaces.IEditCategoryCommand;

import java.net.URISyntaxException;

public interface IManagerApplicationService {
    void addStaffToManagerTeam(IUpdateManagerTeamCommand updateManagerTeamCommand);

    void createSkill(CreateSkillCommand createSkillCommand);

    void editSkill(EditSkillCommand editSkillCommand);

    void deleteSkill(DeleteSkillCommand deleteSkillCommand);

    void createCategory(ICreateCategoryCommand createSkillCommand);

    void editCategory(IEditCategoryCommand editCategoryCommand);

    void deleteCategory(IDeleteCategoryCommand deleteCategoryCommand) throws URISyntaxException;
}
