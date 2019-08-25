package com.team.house.controller;

import com.github.pagehelper.PageInfo;
import com.team.house.entity.District;
import com.team.house.service.DistrictService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;

@Controller
@RequestMapping("/admin")
public class DistrictController {
    @Autowired
    private DistrictService service;


    @RequestMapping("/getALLDistrict")
    @ResponseBody
    public List<District> getALLDistrict(){
        //查询所有区域
        List<District> list = service.getAll();
        return list;


    }
    @RequestMapping("/getALLDistrictByPage")
    @ResponseBody
    public HashMap<String, Object> getALLDistrictByPage(int page, int rows){
        //查询所有区域和分页展示
        PageInfo<District> list = service.getAllByPage(page, rows);
        HashMap<String,Object> map=new HashMap();
        map.put("total", list.getTotal());
        map.put("rows",list.getList() );

        return map;

    }
    @RequestMapping("/addDistrict")
    @ResponseBody
    public String addDistrict(District district){
        int temp = -1;
        try {//调用业务实现添加
            temp = service.addDistrict(district);
            //传统实现跳转到视图
            //返回数据
        } catch (Exception e) {
            e.printStackTrace();//都会打印系统日志
        }

        return "{\"result\":"+temp+"}";//返回结果

    }
    //通过主键查询单 条
    @RequestMapping("/getOneDistrict")
    @ResponseBody
    public District getOneDistrict(Integer id){
        District district = service.selectOne(id);
       // model.addAttribute("Type",Type );
        return district;
    }

    //通过主键查询单 条进行修改
    @RequestMapping("/updateDistrict")
    @ResponseBody
    public String  updateDistrict(District district ){
     // Type Type1 = service.selectOne(id);
        int temp = -1;
        try {
            temp = service.updateDistrict(district);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return "{\"result\":"+temp+"}";//返回结果
    }

    /*
    * 通过主键id进行删除操作
    * */
    @RequestMapping("/deleteDistrict")
    @ResponseBody
    public String  deleteDistrict(Integer id ){
        //  Type Type1 = service.selectOne(id);
        int temp = -1;
        try {
            temp = service.deleteDistrict(id);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "{\"result\":"+temp+"}";//返回结果
    }

    @RequestMapping("/delMoreDistrict")
    @ResponseBody
    public String  delMoreDistrict(String ids ){
       //将字符串转化为数组
        String[] ss = ids.split(",");
        Integer [] id=new Integer[ss.length];
        for (int i=0;i<ss.length;i++) {
            id[i]=new Integer(ss[i]);

        }
        //调用业务
        int temp = -1;
        try {
            temp =this.service.delMoreDistrict(id);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "{\"result\":"+temp+"}";//返回结果
    }


}
