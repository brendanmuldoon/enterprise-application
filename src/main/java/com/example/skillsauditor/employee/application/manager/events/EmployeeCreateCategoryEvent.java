package com.example.skillsauditor.employee.application.manager.events;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class EmployeeCreateCategoryEvent{

    private String id;
    private String description;
}
