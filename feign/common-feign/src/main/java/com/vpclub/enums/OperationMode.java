package com.vpclub.enums;

public enum  OperationMode {
    ADD("add"),
    REDUCE("reduce");

    private String name;

    private OperationMode(String name){
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
