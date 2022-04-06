package com.genspark.demo.Service;

import com.genspark.demo.Entity.Course;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Service
public class courseImpl implements CourseService{

    List<Course> list;

    public courseImpl() {
        list = new ArrayList<>();
        list.add(new Course(100, "Spring Framework", "Pradeep"));
        list.add(new Course(120, "Java Core", "Adam"));
        list.add(new Course(102, "Spring Boot", "Pradeep"));
        list.add(new Course(130, "Hibernate", "Jacob"));
    }

    @Override
    public List<Course> getAllCourses() {
        return list;
    }

    @Override
    public Course getCourse(int id) {
        Course c = null;
        for (Course obj : list) {
            if (obj.getCourseID() == id) {
                c = obj;
                break;
            }
        }
        return c;
    }

    @Override
    public Course addCourse(Course course) {
        list.add(course);
        return course;
    }

    @Override
    public Course updateCourse(Course course) {
        String title = course.getCourseTitle();
        String instructor = course.getCourseInstructor();
        Course c = null;

        for(Course obj : list) {
            if (course.getCourseID() == obj.getCourseID()) {
                obj.setCourseTitle(title);
                obj.setCourseInstructor(instructor);
                break;
            }
        }
        return c;
    }

    @Override
    public String deleteCourse(int id) {
        for (Course obj : list) {
            if (obj.getCourseID() == id) {
                list.remove(obj);
                break;
            }
        }
        return "Course " + id + " deleted";
    }
}
