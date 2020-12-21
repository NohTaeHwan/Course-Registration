package com.thnoh.spring.controller;

import com.thnoh.spring.model.Course;
import com.thnoh.spring.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * CourseRestController
 *
 * 1. course 조회(all)
 * 2. course 조회(year,semester,division)
 *
 */
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
    @RequestMapping(value = "/courses",method = RequestMethod.GET)
    public ResponseEntity<List<Course>> getAllCourses(){

        List<Course> courses = courseService.getCourses();

        if(courses.isEmpty()){

            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        return new ResponseEntity<>(courses,HttpStatus.OK);
    }

    /**
     * Method : POST
     * get specific courses
     *
     * @param course (@RequestBody)
     * @return ResponseEntity(filteredCourses , status 200)
     */
    @RequestMapping(value = "/spec_courses",method = RequestMethod.POST)
    public ResponseEntity<List<Course>> getFilteredCourses(@RequestBody Course course){

        int year = course.getYear();
        int semester = course.getSemester();
        String division = course.getDivision();

        //System.out.println("연도 : "+year + " 학기 : "+ semester + " 학과 : "+division);

        if(division.equals("NONE")){
            System.out.println("[error] please select division");
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        List<Course> courses = courseService.getCourses();
        //리턴할 filtering된 교과목 리스트
        List<Course> filteredCourses = new ArrayList<>();

        //학기 , 연도 , 학과가 같다면 filteredCourses 에 추가.
        for(Course element : courses){
            if(element.getDivision().equals(division) && element.getSemester()==semester && element.getYear() == year){
                filteredCourses.add(element);
            }
        }

        return new ResponseEntity<>(filteredCourses,HttpStatus.OK);
    }

    /**
     ******** Create Course
     *
     * TODO CourseService, CourseDao 까지 createCourse 확장
     *
     * @param course
     * @param uriBuilder
     * @return
     */
    @RequestMapping(value = "/courses",method = RequestMethod.POST)
    public ResponseEntity<Course> createCourse(@RequestBody Course course,
                                               UriComponentsBuilder uriBuilder){




        return new ResponseEntity<>(HttpStatus.CREATED);
    }

}



