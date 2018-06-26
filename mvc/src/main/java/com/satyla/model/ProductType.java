package com.satyla.model;

public enum ProductType {
    GRAPHICS("graphics"),
    WATERCOLOURS("watercolours"),
    DRAWING("drawings"),
    OIL_PAINTING("oil painting"),
    ACRYLIC_PAINTING("acrylic painting");

    private String name;

    ProductType(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
