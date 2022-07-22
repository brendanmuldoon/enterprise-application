package com.example.skillsauditor.skill.domain.skill;

import com.example.skillsauditor.employee.domain.common.Identity;
import com.example.skillsauditor.skill.domain.common.Entity;

public class Category extends Entity {

    private String description;

    protected Category(Identity id, String description) {
        super(id);
        setDescription(description);
    }

    private void setDescription(String description) {
        assertArgumentNotEmpty(description, "Category description must not be null");
        this.description=description;
    }

    public String description(){
        return this.description;
    }
}
