package com.thnoh.spring.dao;

import com.thnoh.spring.model.Course;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Name : CourseDao
 * DAO Layer
 *
 * 과목 조회 , id로 과목 조회 , 과목 생성, 과목 삭제 , 과목 수정
 *
 */
@Repository
@Transactional
public class CourseDao {

    @Autowired
    private SessionFactory sessionFactory;

    //교과목 전체 조회
    @SuppressWarnings("unchecked")
    public List<Course> getCourses(){

        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("from Course");
        List<Course> courseList = query.list();

        return courseList;
    }

    //id로 교과목 조회
    public Course getCourseById(int id) {

        Session session = sessionFactory.getCurrentSession();
        Course course = session.get(Course.class,id);

        return course;
    }

    //교과목 생성
    public void createCourse(Course course) {

        Session session = sessionFactory.getCurrentSession();
        session.saveOrUpdate(course);
        session.flush();
    }

    //교과목 삭제
    public void deleteCourse(Course course) {

        Session session = sessionFactory.getCurrentSession();
        session.delete(course);
        session.flush();
    }

    //교과목 수정
    public void updateCourse(Course course) {

        Session session = sessionFactory.getCurrentSession();
        session.saveOrUpdate(course);
        session.flush();
    }
}
