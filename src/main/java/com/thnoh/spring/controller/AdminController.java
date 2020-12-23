package com.thnoh.spring.controller;

import com.thnoh.spring.model.Course;
import com.thnoh.spring.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping(value = "/admin")
public class AdminController {

    @Autowired
    private CourseService courseService;

    //교과목 관리 페이지
    @RequestMapping(value = "/adminCourse")
    public String adminCourse(Model model){

        List<Course> courses = courseService.getCourses();
        model.addAttribute("courses",courses);

        return "adminCourse";
    }

    //교과목 추가 페이지
    @RequestMapping(value = "/addCourse")
    public String addCourse(Model model){

        Course course = new Course();
        model.addAttribute("course",course);

        return "addCourse";
    }

    //교과목 수정 페이지
    @RequestMapping(value = "/updateCourse/{id}")
    public String updateCourse(@PathVariable("id") int id,Model model){

        Course course = courseService.getCourseById(id);
        model.addAttribute("course",course);

        return "updateCourse";
    }
}
