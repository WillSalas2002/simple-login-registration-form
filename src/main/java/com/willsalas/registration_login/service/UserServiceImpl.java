package com.willsalas.registration_login.service;

import com.willsalas.registration_login.dao.UserDAO;
import com.willsalas.registration_login.entity.User;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDAO userDAO;

    @Transactional
    @Override
    public void saveUser(User user) {
        userDAO.saveUser(user);
    }

    @Transactional
    @Override
    public User findByEmail(String email) {

        return userDAO.findByEmail(email);
    }

    @Transactional
    @Override
    public boolean checkUserExists(String email, String password) {
        return userDAO.checkUserExists(email, password);
    }
}
