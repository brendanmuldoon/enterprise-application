package com.example.skillsauditor.employee.domain.staff.interfaces;

import com.example.skillsauditor.employee.application.staff.commands.RemoveStaffSkillCommand;
import com.example.skillsauditor.employee.application.staff.commands.UpdateStaffDetailsCommand;
import com.example.skillsauditor.employee.domain.common.Address;
import com.example.skillsauditor.employee.domain.common.FullName;
import com.example.skillsauditor.employee.domain.common.SecurityCredentials;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

public interface IUpdateStaffDetailsCommand {
    String getStaffId();

    FullName getFullName();

    Address getAddress();

    String getRole();

    SecurityCredentials getSecurityCredentials();
}
