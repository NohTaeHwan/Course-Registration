package com.thnoh.spring.controller;

import com.thnoh.spring.model.Course;
import com.thnoh.spring.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.*;

/**
 * Name : CourseRestController
 * (Rest)Controller Layer
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
     ********** GET Courses
     *
     * Method : GET
     * description : get all courses
     *
     * @return ResponseEntity(courseList , status 200)
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
     ********** Get course by condition
     *
     * Method : POST
     * description : get course with specific condition
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
     * method : POST
     * description : create course
     *
     * TODO 새로 만든 교과목이 중복인지 체크하는 로직
     * TODO form에서 적절치 못한 값은 추가되지 못하도록 해야함. 그리고 학기는 콤보박스로 구성되는게 좋겠음.
     *
     * @param course
     * @param uriBuilder
     * @return ResponseEntity(headers , status 201)
     */
    @RequestMapping(value = "/courses",method = RequestMethod.POST)
    public ResponseEntity<Void> createCourse(@RequestBody Course course,
                                               UriComponentsBuilder uriBuilder){

        courseService.createCourse(course);
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(uriBuilder.path("/course_api/courses/{id}").buildAndExpand(course.getCode()).toUri());

        return new ResponseEntity<>(headers,HttpStatus.CREATED);
    }

    /**
     ******** Delete Course
     *
     * method : DELETE
     * description : delete course by {id}
     * @param id
     * @return
     */
    @RequestMapping(value = "/courses/{id}",method = RequestMethod.DELETE)
    public ResponseEntity<Course> deleteCourseById(@PathVariable("id") int id){

        Course course = courseService.getCourseById(id);
        courseService.deleteCourse(course);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);

    }

    /**
     ********* Update Course
     *
     * method : PUT
     * description : update course
     *
     * @param course
     * @return
     */
    @RequestMapping(value = "/courses",method = RequestMethod.PUT)
    public ResponseEntity<Void> updateCourse(@RequestBody Course course){

        courseService.updateCourse(course);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}



