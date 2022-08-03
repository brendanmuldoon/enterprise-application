package com.example.skillsauditor.employee.application.manager.commands;

import com.example.skillsauditor.employee.domain.manager.interfaces.ICreateCategoryCommand;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class CreateCategoryCommand implements ICreateCategoryCommand {

    private String description;
}
