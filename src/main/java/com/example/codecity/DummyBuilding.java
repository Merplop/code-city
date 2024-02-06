package com.example.codecityjavafx;

public class DummyBuilding {
    private final String superClass;
    private final int numMethods;
    private String name;
    public DummyBuilding(String n, int l, String name) {
        this.superClass = n;
        this.numMethods = l;
        this.name = name;
    }

    public String getSuperClass() {
        return this.superClass;
    }

    public int getNumMethods() {
        return this.numMethods;
    }

    public String getName() {
        return name;
    }
}
