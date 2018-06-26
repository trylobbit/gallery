package com.satyla.model;

public enum RoleType {
    USER("USER"),
    ADMIN("ADMIN");

    private String name;

    RoleType(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
