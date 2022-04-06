package com.genspark.demo.Entity.Controller;

import com.genspark.demo.Entity.Course;
import com.genspark.demo.Service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class MyController {

    @Autowired
    private CourseService courseService;

    @GetMapping("/home")
    public String home() {
        return "<HTML><h1>Welcome to my first web app</h1></HTML>";
    }

//    @GetMapping("/hello")
//    public String hello(@RequestParam(value="name",defaultValue = "world") String name,
//                        @RequestParam(value="msg", defaultValue = "How are you doing?") String msg) {
//        return "Hello" + name + ". " + msg;
//    }

    @GetMapping("/courses")
    public List<Course> getCourses() {
        return this.courseService.getAllCourses();
    }

    @GetMapping("/courses/{courseID}")
    public Course getCourse(@PathVariable String courseID) {
        return this.courseService.getCourse(Integer.parseInt(courseID));
    }

    @PostMapping("/courses")
    public Course addCourse(@RequestBody Course course) {
        return this.courseService.addCourse(course);
    }

    @PutMapping("/courses")
    public Course updateCourse(@RequestBody Course course) {
        return this.courseService.updateCourse(course);
    }

    @DeleteMapping("/courses/{courseID}")
    public String deleteCourse(@PathVariable String courseID) {
        return this.courseService.deleteCourse(Integer.parseInt(courseID));
    }

}
