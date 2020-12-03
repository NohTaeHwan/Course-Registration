package com.thnoh.spring.controller;

import com.thnoh.spring.model.Course;
import com.thnoh.spring.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/course_api")
public class CourseRestController {

    @Autowired
    private CourseService courseService;

    /**
     * Method : GET
     * get all courses
     *
     * @return ResponseEntity { courseList , status code : 200 }
     */
    @RequestMapping(value = "/course",method = RequestMethod.GET)
    public ResponseEntity<List<Course>> getAllCourses(){

        List<Course> courses = courseService.getCourses();

        if(courses.isEmpty()){

            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        return new ResponseEntity<>(courses,HttpStatus.OK);
    }




}



