package com.thnoh.spring.service;

import com.thnoh.spring.dao.CourseDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CourseService {

    @Autowired
    private CourseDao courseDao;

}
