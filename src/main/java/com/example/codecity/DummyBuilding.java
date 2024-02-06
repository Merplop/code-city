package com.example.codecityjavafx;

import java.io.IOException;

/**
 * Placeholder class for back end building information.
 */

public class DummyBuilding {
    // Superclass of class in question
    private final String superClass;
    // Number of methods = height
    private final int numMethods;
    // Name of class
    private String name;
    /**
     * Class constructor
     *
     * @param n The primary stage for this application.
     * @param nm Number of methods the class (building) has
     * @param name Name of class
     */
    public DummyBuilding(String n, int nm, String name) {
        this.superClass = n;
        this.numMethods = nm;
        this.name = name;
    }

    /**
     *
     * @return Superclass of this class
     */

    public String getSuperClass() {
        return this.superClass;
    }

    /**
     *
     * @return Number of methods, used to calculate height of building
     */

    public int getNumMethods() {
        return this.numMethods;
    }

    /**
     *
     * @return Name of class
     */

    public String getName() {
        return name;
    }
}
