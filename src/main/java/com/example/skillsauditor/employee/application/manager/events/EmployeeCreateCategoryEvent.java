package com.example.skillsauditor.employee.application.manager.events;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;

@Getter
@Setter
@ToString
public class EmployeeCreateCategoryEvent implements Serializable {

    private String id;
    private String description;
}
