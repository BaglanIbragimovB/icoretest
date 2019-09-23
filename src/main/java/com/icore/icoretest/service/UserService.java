package com.icore.icoretest.service;

import com.icore.icoretest.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.icore.icoretest.entity.User;

import java.util.List;

@Service
public class UserService {
    @Autowired
    UserDao userDao;
    public List<User> getAllUsers() {
        return userDao.findAll();
    }

    public User addUser(User user) {
        return this.userDao.save(user);
    }

    //other methods omitted for brevity
}