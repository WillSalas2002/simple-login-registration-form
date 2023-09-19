package com.willsalas.registration_login.dao;

import com.willsalas.registration_login.entity.User;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDAO {
    public void saveUser(User user);

    User findByEmail(String email);

    boolean checkUserExists(String email, String password);
}
