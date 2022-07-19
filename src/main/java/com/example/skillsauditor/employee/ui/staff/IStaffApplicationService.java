package com.example.skillsauditor.employee.ui.staff;

import com.example.skillsauditor.employee.domain.staff.interfaces.IAddStaffSkillCommand;
import com.example.skillsauditor.employee.domain.staff.interfaces.IRemoveStaffSkillCommand;
import com.example.skillsauditor.employee.domain.staff.interfaces.IUpdateStaffDetailsCommand;

public interface IStaffApplicationService {

    void removeStaffSkill(IRemoveStaffSkillCommand removeSkillCommand);

    void addStaffSkill(IAddStaffSkillCommand addStaffSkillCommand);

    void updateStaffDetails(IUpdateStaffDetailsCommand updateStaffDetailsCommand);
}
