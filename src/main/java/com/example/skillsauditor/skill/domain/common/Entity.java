package com.example.skillsauditor.skill.domain.common;


import com.example.skillsauditor.employee.domain.common.AssertionConcern;
import com.example.skillsauditor.employee.domain.common.Identity;

public abstract class Entity extends AssertionConcern {
   protected final Identity id;

    protected Entity(Identity id) {
        this.id = id;
    }

    public boolean equals(Object o){
        if (o == null && o.getClass() != this.getClass()){
            return false;
        }
        Entity another = (Entity) o;

        return another.id == this.id;
    }
}
