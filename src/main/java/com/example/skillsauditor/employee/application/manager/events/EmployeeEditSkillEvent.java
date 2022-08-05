package com.example.skillsauditor.employee.application.manager.events;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EmployeeEditSkillEvent {

    private String id;
    private String description;
}
