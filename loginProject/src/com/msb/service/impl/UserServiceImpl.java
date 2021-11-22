package com.msb.service.impl;

import com.msb.dao.UserDao;
import com.msb.dao.impl.UserDaoImpl;
import com.msb.entity.User;
import com.msb.service.UserService;

public class UserServiceImpl implements UserService {

    UserDao userDao = new UserDaoImpl();

    @Override
    public User check(User user) {
        return userDao.checkUser(user);
    }
}
