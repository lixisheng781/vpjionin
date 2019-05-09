package com.vpclub.enums;

public enum  UserRole {
    SYSTEM("平台", 1),
    USER("用户", 2),
    MERCHANT("学校", 3)
    ;

    private String name;
    private int value;

    private UserRole(String name, int value) {
        this.name = name;
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public int getValue() {
        return value;
    }

}
