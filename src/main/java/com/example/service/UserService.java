package com.example.service;

import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.dao.UserDAO;
import com.example.model.User;

@Service
public class UserService {
	

    private UserDAO userDAO;

    // Constructor Injection
    @Autowired
    public UserService(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

   

    public void createUser(User user) throws SQLException {
        userDAO.createUser(user);
    }

   
}
