package com.willsalas.registration_login.dao;

import com.willsalas.registration_login.entity.User;
import jakarta.persistence.NoResultException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class UserDAOImpl implements UserDAO {

    @Autowired
    SessionFactory sessionFactory;
    @Override
    public void saveUser(User user) {
        Session session = sessionFactory.getCurrentSession();

        session.persist(user);
    }

    @Override
    public User findByEmail(String email) {
        Session session = sessionFactory.getCurrentSession();
        Query<User> query = session.createQuery("FROM User WHERE email = :email", User.class);
        query.setParameter("email", email);

        try {
            User user = query.getSingleResult();
            return user;
        } catch (NoResultException ex) {
            return null;
        }
    }

    @Override
    public boolean checkUserExists(String email, String password) {

        Session session = sessionFactory.getCurrentSession();

        Query query = session.createQuery("FROM User WHERE email = :email AND password = :password");
        query.setParameter("email", email);
        query.setParameter("password", password);

        try {
            User user = (User) query.getSingleResult();
            return true;
        } catch (NoResultException ex) {
            return false;
        }
    }
}
