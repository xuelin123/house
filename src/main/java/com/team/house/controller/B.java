package com.team.house.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class B {

    @RequestMapping("/go")
    public String gogo(){
        return "go";
    }

}
