package com.example.skillsauditor.skill.domain.common;

import com.example.skillsauditor.employee.domain.common.Identity;

import java.util.UUID;

public class UniqueIDFactory {
    public static Identity createID(){
        return new Identity(UUID.randomUUID().toString());
    }
}
