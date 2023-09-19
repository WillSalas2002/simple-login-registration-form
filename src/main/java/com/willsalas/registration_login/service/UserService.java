package com.willsalas.registration_login.service;

import com.willsalas.registration_login.entity.User;
import org.springframework.stereotype.Service;

@Service
public interface UserService {

    public void saveUser(User user);
    public User findByEmail(String email);
    public boolean checkUserExists(String email, String password);
}
