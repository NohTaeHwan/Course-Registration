package com.thnoh.spring.controller;

import com.thnoh.spring.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ShowSubjectController {

    @Autowired
    private CourseService courseService;

    @RequestMapping(value = "/showSubjects")
    public String showSubjects(Model model){

        return "showSubjects";
    }


}
