package com.thnoh.spring.dao;

import com.thnoh.spring.model.Course;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public class CourseDao {

    @Autowired
    private SessionFactory sessionFactory;

    @SuppressWarnings("unchecked")
    public List<Course> getCourses(){

        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("from Course");
        List<Course> courseList = query.list();

        return courseList;
    }

}
