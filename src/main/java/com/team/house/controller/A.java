package com.team.house.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class A {

    @RequestMapping("/go")
    public String gogo(){
        return "go";
    }
    @RequestMapping("/go1")
    public String gogo1(){
        return "go";
    }
}
