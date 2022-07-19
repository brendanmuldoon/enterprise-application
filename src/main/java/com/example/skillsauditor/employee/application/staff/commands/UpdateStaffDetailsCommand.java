package com.example.skillsauditor.employee.application.staff.commands;

import com.example.skillsauditor.employee.domain.common.Address;
import com.example.skillsauditor.employee.domain.common.FullName;
import com.example.skillsauditor.employee.domain.common.SecurityCredentials;
import com.example.skillsauditor.employee.domain.staff.interfaces.IUpdateStaffDetailsCommand;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class UpdateStaffDetailsCommand implements IUpdateStaffDetailsCommand {

    private String staffId;
    private FullName fullName;
    private Address address;
    private String role;
    private SecurityCredentials  securityCredentials;
}
