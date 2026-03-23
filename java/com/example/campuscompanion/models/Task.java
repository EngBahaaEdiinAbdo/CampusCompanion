package com.example.campuscompanion.models;

public class Task {
    private final int id;
    private String title;
    private String due;
    private boolean done;

    public Task(int id, String title, String due, boolean done) {
        this.id = id;
        this.title = title;
        this.due = due;
        this.done = done;
    }

    public int getId() { return id; }
    public String getTitle() { return title; }
    public String getDue() { return due; }
    public boolean isDone() { return done; }

    public void setTitle(String title) { this.title = title; }
    public void setDue(String due) { this.due = due; }
    public void setDone(boolean done) { this.done = done; }
}
