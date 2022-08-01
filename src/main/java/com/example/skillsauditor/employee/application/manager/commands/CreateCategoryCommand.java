package com.example.skillsauditor.employee.application.manager.commands;

import com.example.skillsauditor.skill.domain.skill.interfaces.ICreateCategoryCommand;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class CreateCategoryCommand implements ICreateCategoryCommand {

    private String description;
}
