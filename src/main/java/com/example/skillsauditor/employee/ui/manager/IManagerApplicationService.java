package com.example.skillsauditor.employee.ui.manager;

import com.example.skillsauditor.employee.application.manager.commands.DeleteSkillCommand;
import com.example.skillsauditor.employee.application.manager.commands.EditSkillCommand;
import com.example.skillsauditor.employee.domain.manager.interfaces.*;

public interface IManagerApplicationService {
    void addStaffToManagerTeam(IUpdateManagerTeamCommand updateManagerTeamCommand);

    void createSkill(ICreateSkillCommand createSkillCommand);

    void editSkill(EditSkillCommand editSkillCommand);

    void deleteSkill(DeleteSkillCommand deleteSkillCommand);

    void createCategory(ICreateCategoryCommand createSkillCommand);

    void editCategory(IEditCategoryCommand editCategoryCommand);

    void deleteCategory(IDeleteCategoryCommand deleteCategoryCommand);
}
