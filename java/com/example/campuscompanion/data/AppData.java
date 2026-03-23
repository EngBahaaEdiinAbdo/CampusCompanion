package com.example.campuscompanion.data;

import java.util.ArrayList;
import com.example.campuscompanion.models.Course;
import com.example.campuscompanion.models.Task;

public class AppData {
    private static final ArrayList<Course> courses = new ArrayList<>();
    private static final ArrayList<Task> tasks = new ArrayList<>();
    private static int courseSeq = 3;
    private static int taskSeq = 4;

    static {
        courses.add(new Course(1, "Android Development", "Dr. Ali"));
        courses.add(new Course(2, "Distributed Systems", "Dr. Rana"));

        tasks.add(new Task(1, "Prepare slides", "Wed", false));
        tasks.add(new Task(2, "Finish lab", "Thu", true));
        tasks.add(new Task(3, "Read chapter 5", "Sat", false));
    }

    public static ArrayList<Course> getCourses() { return courses; }
    public static ArrayList<Task> getTasks() { return tasks; }

    public static int nextCourseId() { return courseSeq++; }
    public static int nextTaskId() { return taskSeq++; }

    public static Course findCourse(int id) {
        for (Course c : courses) if (c.getId() == id) return c;
        return null;
    }

    public static Task findTask(int id) {
        for (Task t : tasks) if (t.getId() == id) return t;
        return null;
    }
}
