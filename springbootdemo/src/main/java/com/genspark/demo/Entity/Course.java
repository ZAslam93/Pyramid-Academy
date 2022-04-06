package com.genspark.demo.Entity;

public class Course {
    private int courseID;
    private String courseTitle;
    private String courseInstructor;

    public Course() {
    }

    public Course(int courseID, String courseTitle, String courseInstructor) {
        this.courseID = courseID;
        this.courseTitle = courseTitle;
        this.courseInstructor = courseInstructor;
    }

    public int getCourseID() {
        return courseID;
    }

    public void setCourseID(int courseID) {
        this.courseID = courseID;
    }

    public String getCourseTitle() {
        return courseTitle;
    }

    public void setCourseTitle(String courseTitle) {
        this.courseTitle = courseTitle;
    }

    public String getCourseInstructor() {
        return courseInstructor;
    }

    public void setCourseInstructor(String courseInstructor) {
        this.courseInstructor = courseInstructor;
    }
}
