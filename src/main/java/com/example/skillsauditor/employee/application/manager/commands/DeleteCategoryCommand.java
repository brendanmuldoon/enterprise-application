package com.example.skillsauditor.employee.application.manager.commands;

import com.example.skillsauditor.skill.domain.skill.interfaces.IDeleteCategoryCommand;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DeleteCategoryCommand  implements IDeleteCategoryCommand {

    private String id;
}
