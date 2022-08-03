package com.example.skillsauditor.employee.application.manager.commands;

import com.example.skillsauditor.skill.domain.skill.interfaces.IEditCategoryCommand;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EditCategoryCommand implements IEditCategoryCommand {

    private String id;
    private String description;
}
