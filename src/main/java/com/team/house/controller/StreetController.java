package com.team.house.controller;

import com.github.pagehelper.PageInfo;
import com.team.house.entity.District;
import com.team.house.entity.Street;
import com.team.house.service.StreetService;
import com.team.house.util.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/admin")
public class StreetController {
    @Autowired
    private StreetService streetService;

    @RequestMapping("/getStreetByDid")
    @ResponseBody
    public Map<String,Object> getStreetByDid(Integer did,Page page){
        //返回结果
        PageInfo<Street> street = streetService.getStreetByDistrict(did,page);
       // System.out.println(street);
        Map<String,Object> map=new HashMap<>();
        map.put("total", street.getTotal());
        map.put("rows", street.getList());
        return map;

    }
    @RequestMapping("/getDistrictById")
    public String getDistrictById(Integer did, Model model){
        //返回结果
        streetService.getDistrictById(did);
        model.addAttribute("did", did);//存入id信息
        return "redirect:addStreet";

    }

//添加街道
    @RequestMapping("/addStreet")
    @ResponseBody
    public String addStreet(Street street,Integer did){
        //存入区域id
        streetService.getDistrictById(did);

       street.setDistrictId(did);
        //Integer streetDistrictId = street.getDistrictId(did);
        //String name = street.getName();System.out.println(did);
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

    @RequestMapping("/delStreet")
    @ResponseBody
    public String delStreet(Integer id){

        int temp = -1;
        try {//调用业务实现添加
            temp = this.streetService.delStreet(id);
            //传统实现跳转到视图
            //返回数据
        } catch (Exception e) {
            e.printStackTrace();//都会打印系统日志
        }

        return "{\"result\":"+temp+"}";//返回结果

    }
    @RequestMapping("/updateStreet")
    @ResponseBody
    public String updateStreet(Street street){
        //street.getId();
        int temp = -1;
        try {//调用业务实现添加
            temp = this.streetService.updateStreet(street);
            //传统实现跳转到视图
            //返回数据
        } catch (Exception e) {
            e.printStackTrace();//都会打印系统日志
        }

        return "{\"result\":"+temp+"}";//返回结果

    }
}
