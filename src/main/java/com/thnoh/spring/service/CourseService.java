package com.thnoh.spring.service;

import com.thnoh.spring.dao.CourseDao;
import com.thnoh.spring.model.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseService {

    @Autowired
    private CourseDao courseDao;

    public List<Course> getCourses(){
        return courseDao.getCourses();
    }

    public Course getCourseById(int id){ return courseDao.getCourseById(id); }

    public void createCourse(Course course) { courseDao.createCourse(course); }

    public void deleteCourse(Course course) {
        courseDao.deleteCourse(course);
    }

    public void updateCourse(Course course) { courseDao.updateCourse(course); }
}
