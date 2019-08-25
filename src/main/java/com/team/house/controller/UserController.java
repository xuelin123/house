package com.team.house.controller;

import com.github.pagehelper.PageInfo;
import com.team.house.entity.Users;
import com.team.house.service.UserService;
import com.team.house.util.UserConditon;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/admin")
public class UserController {
    @Autowired
    private UserService userService;

    @RequestMapping("/getAllRUsers")
    @ResponseBody
    public Map<String,Object> getAllRUsers(UserConditon userConditon){

        PageInfo<Users> users = userService.getAllRUsers(userConditon);
        Map<String,Object> map=new HashMap<>();
        map.put("total", users.getTotal());//获取页码
        map.put("rows",users.getList() );//获取页记录数
        return map;
    }



}
