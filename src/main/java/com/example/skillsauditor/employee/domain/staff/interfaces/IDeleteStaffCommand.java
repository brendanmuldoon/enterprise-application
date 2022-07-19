package com.example.skillsauditor.employee.domain.staff.interfaces;

import com.example.skillsauditor.employee.application.staff.commands.DeleteStaffCommand;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

@JsonDeserialize(as = DeleteStaffCommand.class)
public interface IDeleteStaffCommand {

    String getStaffId();
}
