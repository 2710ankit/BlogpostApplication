package com.upgrad.TechnicalBlogApplication.service;

import com.upgrad.TechnicalBlogApplication.model.User;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    // Contain all the business logic and communicate to db
    public boolean login(User user) {
        if(user.getUsername().equals("ankit") && user.getPassword().equals("asdasd"))
            return true;
        else
            return false;
    }
}
