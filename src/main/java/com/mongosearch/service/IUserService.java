package com.mongosearch.service;

import com.mongosearch.domain.entity.User;

import java.util.List;

public interface IUserService {
    User getUserByUserName(String userName);
    void saveUser(User user);
    List<User> fullTextSearch(String fieldValue);
}
