package com.example.skillsauditor.employee.application.manager.queries;

import com.example.skillsauditor.skill.domain.skill.DTO.CategoryDTO;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@EqualsAndHashCode
@Getter
@Setter
@ToString
public class EmployeeSkillDTO {


    private String id;
    private String description;
    private CategoryDTO category;

}
