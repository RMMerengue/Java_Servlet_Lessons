package com.cookie.service;

import com.cookie.entity.User;

public interface UserService {
    public User check(User user);

    public User getUserById(int id);
}
