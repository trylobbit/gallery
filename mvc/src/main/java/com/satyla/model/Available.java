package com.satyla.model;


public enum Available {
    YES("Yes"),
    NO("No");

    private String name;

    Available(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}

