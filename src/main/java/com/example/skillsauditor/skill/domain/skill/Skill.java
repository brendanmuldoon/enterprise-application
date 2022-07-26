package com.example.skillsauditor.skill.domain.skill;

import com.example.skillsauditor.employee.domain.common.Entity;
import com.example.skillsauditor.employee.domain.common.Identity;
import com.example.skillsauditor.skill.domain.skill.interfaces.IEditSkillCommand;
import lombok.ToString;

@ToString
public class Skill extends Entity { // Aggregate

    private String description;
    private String category;

    protected Skill(Identity id, String description, String category) {
        super(id);
        setDescription(description);
        this.category = category;
    }

    public static Skill skillOf(Identity newId, String description, String category) {
        return new Skill(newId, description, category);
    }


    private void setDescription(String description) {
        assertArgumentNotEmpty(description, "Skill description must not be empty");
        this.description=description;
    }

    public Identity id() {
        return this.id;
    }

    public String description() {
        return this.description;
    }

    public String category() {
        return this.category;
    }

    public void update(IEditSkillCommand editSkillCommand) {
        this.description = editSkillCommand.getDescription();
        this.category = editSkillCommand.getCategoryId();
    }
}
