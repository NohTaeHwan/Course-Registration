package com.thnoh.spring.controller;

import com.thnoh.spring.model.Course;
import com.thnoh.spring.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.*;

/**
 * Name : ShowSubjectController
 * Controller Layer
 *
 * View 요청 : 교과목 조회
 */
@Controller
public class ShowSubjectController {

    @Autowired
    private CourseService courseService;

    @RequestMapping(value = "/showSubjects")
    public String showSubjects(Model model){

        //form으로 만들어줄 비어있는 객체
        Course course = new Course();
        model.addAttribute("course",course);

        //select 속성에 담을 model
        List<Course> courses = courseService.getCourses();
        model.addAttribute("courses",courses);

        //연도 ,학기 ,학과
        Set<Integer> years = new HashSet<>();
        Set<Integer> semesters = new HashSet<>();
        Set<String> divisions = new HashSet<>();

        for(Course element : courses){
            years.add(element.getYear());
            semesters.add(element.getSemester());
            divisions.add(element.getDivision());
        }

        model.addAttribute("years",years);
        model.addAttribute("semesters",semesters);
        model.addAttribute("divisions",divisions);

        return "showSubjects";
    }

}
