package com.mongosearch.web;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SearchContoller {

    @RequestMapping("/")
    public String homePage(){
        return "Hello World";
    }
}
