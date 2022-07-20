package com.example.skillsauditor.employee.domain.staff.interfaces;

import com.example.skillsauditor.employee.application.staff.commands.CreateStaffCommand;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

@JsonDeserialize(as = CreateStaffCommand.class)
public interface ICreateStaffCommand {

    String getFirstName();
    String getSurname();
    String getHouseNumber();
    String getStreetName();
    String getPostcode();
    String getRole();
    String getUsername();
    String getPassword();

}
