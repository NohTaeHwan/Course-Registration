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

}
