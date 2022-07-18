package com.example.skillsauditor.employee.ui.staff;

import com.example.skillsauditor.employee.domain.staff.interfaces.IRemoveSkillCommand;

public interface IStaffApplicationService {

    void removeStaffSkill(IRemoveSkillCommand removeSkillCommand);
}
