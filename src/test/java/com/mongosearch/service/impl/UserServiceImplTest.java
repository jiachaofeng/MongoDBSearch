package com.mongosearch.service.impl;

import com.mongosearch.MainApp;
import com.mongosearch.domain.entity.User;
import com.mongosearch.domain.repository.UserRepository;
import com.mongosearch.service.IUserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.mongodb.core.query.TextCriteria;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = MainApp.class)
public class UserServiceImplTest {

    @Autowired
    private IUserService userService;

    @Test
    public void getUserByUserName() {
    }

    @Test
    public void saveUser() {
        User user1 = new User("test1","123456","test-1");
        User user2 = new User("test2","123456","test-2");
        userService.saveUser(user1);
        userService.saveUser(user2);
    }

    @Test
    public void fullTextSearch() {
        String searchValue = "test";
        List<User> users = userService.fullTextSearch(searchValue);
        System.out.println(users.size());
        for(User user: users){
            System.out.println(user.toString());
        }
    }
}