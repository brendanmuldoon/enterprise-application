package com.example.skillsauditor.common;


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
