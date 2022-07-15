package com.example.skillsauditor.employee.domain.common;

import java.util.UUID;

public class UniqueIDFactory {
    public static Identity createID(){
        return new Identity(UUID.randomUUID().toString());
    }
}
