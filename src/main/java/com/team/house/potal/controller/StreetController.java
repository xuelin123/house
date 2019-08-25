package com.team.house.potal.controller;

import com.github.pagehelper.PageInfo;
import com.team.house.entity.Street;
import com.team.house.service.StreetService;
import com.team.house.util.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller(value = "streetController2")
@RequestMapping("/page")
public class StreetController {
    @Autowired
    private StreetService streetService;

    @RequestMapping("/getStreet")
    @ResponseBody
    public List<Street> getStreetByDid(Integer did){
        //返回结果
       List<Street> list = streetService.getStreetByDistrict(did);
        return list;

    }
//添加街道
    @RequestMapping("/addStreet")
    @ResponseBody
    public String addStreet(Street street){
        //存入区域id
     //   street.setDistrictId(did);

        int temp = -1;
        try {//调用业务实现添加
            temp = this.streetService.addStreet(street);
            //传统实现跳转到视图
            //返回数据
        } catch (Exception e) {
            e.printStackTrace();//都会打印系统日志
        }

        return "{\"result\":"+temp+"}";//返回结果

    }

}
