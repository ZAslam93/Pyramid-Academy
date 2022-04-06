package com.genspark.demo.Service;

import com.genspark.demo.Entity.Course;

import java.util.List;

public interface CourseService {

    List<Course> getAllCourses();

    Course getCourse(int id);

    Course addCourse(Course course);

    Course updateCourse(Course course);

    String deleteCourse(int id);
}
