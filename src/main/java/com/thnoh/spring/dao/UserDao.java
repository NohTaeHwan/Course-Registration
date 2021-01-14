package com.thnoh.spring.dao;

import com.thnoh.spring.model.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.TypedQuery;
import java.util.List;

/**
 * Name : UserDao
 * DAO Layer
 *
 * 유저 생성 , id로 유저 조회 ,  username으로 유저 조회
 * 모든 유저 조회 , 유저 삭제 , 모든 유저 삭제 , 유저 수정
 *
 */
@Repository
@Transactional
public class UserDao {

//    @Autowired
  //  private PasswordEncoder passwordEncoder;

    @Autowired
    private SessionFactory sessionFactory;

    //유저 생성
    public void addUser(User user){

        Session session = sessionFactory.getCurrentSession();
        //user.setPassword(passwordEncoder.encode(user.getPassword()));
        session.saveOrUpdate(user);

        session.flush();
    }

    //id로 유저 조회
    public User getUserById(int userId){
        Session session = sessionFactory.getCurrentSession();
        return session.get(User.class,userId);
    }

    //username으로 유저 조회
    @SuppressWarnings("unchecked")
    public User getUserByUsername(String username){

        Session session = sessionFactory.getCurrentSession();

        TypedQuery<User> query = session.createQuery("from User where username = ?0");

        query.setParameter(0,username);

        return query.getSingleResult();

    }

    //모든 유저 조회
    @SuppressWarnings("unchecked")
    public List<User> getAllUsers(){
        Session session = sessionFactory.getCurrentSession();

        TypedQuery<User> query = session.createQuery("from User");
        List<User> userList = query.getResultList();

        return userList;

    }

    //유저 삭제
    public void deleteUser(User user) {

        Session session = sessionFactory.getCurrentSession();
        session.delete(user);
        session.flush();

    }

    //모든 유저 삭제
    public void deleteAllUsers(){
        List<User> userList = getAllUsers();

        for(User user:userList){
            if(!user.getAuthority().equals("ROLE_ADMIN"))
                deleteUser(user);
        }
    }

    //유저 수정
    public void updateUser(User user){

        Session session = sessionFactory.getCurrentSession();
        session.saveOrUpdate(user);
        session.flush();

    }
}
