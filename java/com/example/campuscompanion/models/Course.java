package com.example.campuscompanion.models;

public class Course {
    private final int id;
    private String name;
    private String instructor;

    public Course(int id, String name, String instructor) {
        this.id = id;
        this.name = name;
        this.instructor = instructor;
    }

    public int getId() { return id; }
    public String getName() { return name; }
    public String getInstructor() { return instructor; }

    public void setName(String name) { this.name = name; }
    public void setInstructor(String instructor) { this.instructor = instructor; }
}
