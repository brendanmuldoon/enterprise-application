package com.example.skillsauditor.skill.domain.skill;

import com.example.skillsauditor.employee.domain.common.Entity;
import com.example.skillsauditor.employee.domain.common.Identity;
import lombok.ToString;

@ToString
public class Skill extends Entity { // Aggregate

    private String description;
    private Category category;

    protected Skill(Identity id, String description, Category category) {
        super(id);
        setDescription(description);
        this.category = category;
    }


    private void setDescription(String description) {
        assertArgumentNotEmpty(description, "Skill description must not be empty");
        this.description=description;
    }

    public String description() {
        return this.description;
    }

    public Category category() {
        return this.category;
    }
}
