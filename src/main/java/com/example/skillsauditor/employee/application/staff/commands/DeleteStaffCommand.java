package com.example.skillsauditor.employee.application.staff.commands;

import com.example.skillsauditor.employee.domain.staff.interfaces.IDeleteStaffCommand;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class DeleteStaffCommand implements IDeleteStaffCommand {

    private String staffId;

}
