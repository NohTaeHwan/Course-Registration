package com.thnoh.spring.controller;

import com.thnoh.spring.model.Course;
import com.thnoh.spring.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping(value = "/admin")
public class AdminController {

    @Autowired
    private CourseService courseService;

    @RequestMapping(value = "/showCourse")
    public String adminCourse(Model model){

        //List<Course> courses = courseService.getCourses();
        //model.addAttribute("courses",courses);

        return "adminCourse";
    }

    @RequestMapping(value = "/addCourse")
    public String addCourse(Model model){

        Course course = new Course();
        model.addAttribute("course",course);

        return "addCourse";
    }
}
