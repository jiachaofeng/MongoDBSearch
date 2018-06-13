package com.mongosearch.service.impl;

import com.mongosearch.domain.entity.User;
import com.mongosearch.domain.repository.UserRepository;
import com.mongosearch.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.query.TextCriteria;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements IUserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public User getUserByUserName(String userName) {
        User user = null;
        List<User> userList = userRepository.findByUserName(userName);
        if(userList != null && userList.size() > 0){
            user = userList.get(0);
        }

        return user;
    }

    @Override
    public List<User> fullTextSearch(String fieldValue) {
        TextCriteria textCriteria = TextCriteria.forDefaultLanguage().matching(fieldValue);
        List<User> users = userRepository.findAllBy(textCriteria);
        return users;
    }

    @Override
    public void saveUser(User user) {
        userRepository.save(user);
    }
}
