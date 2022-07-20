package com.example.skillsauditor.employee.ui.staff;

import com.example.skillsauditor.employee.domain.staff.interfaces.*;

public interface IStaffApplicationService {

    void removeStaffSkill(IRemoveStaffSkillCommand removeSkillCommand);

    void addStaffSkill(IAddStaffSkillCommand addStaffSkillCommand);

    void updateStaffDetails(IUpdateStaffDetailsCommand updateStaffDetailsCommand);

    void deleteStaff(IDeleteStaffCommand deleteStaffCommand);

    void updateStaffSkill(IUpdateStaffSkillCommand updateStaffSkillCommand);

    void createStaff(ICreateStaffCommand createStaffCommand);
}
