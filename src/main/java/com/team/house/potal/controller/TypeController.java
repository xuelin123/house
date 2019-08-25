package com.team.house.potal.controller;

import com.github.pagehelper.PageInfo;
import com.team.house.entity.Type;
import com.team.house.service.TypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;

@Controller(value = "typeController2")
@RequestMapping("/page")
public class TypeController {
    @Autowired
    private TypeService service;


    @RequestMapping("/getALLType")
    @ResponseBody
    public List<Type> getALLType(){
        //查询所有区域
        List<Type> list = service.getAll();
        return list;


    }
    @RequestMapping("/getALLTypeByPage")
    @ResponseBody
    public HashMap<String, Object> getALLTypeByPage(int page, int rows){
        //查询所有区域和分页展示
        PageInfo<Type> list = service.getAllByPage(page, rows);
        HashMap<String,Object> map=new HashMap();
        map.put("total", list.getTotal());
        map.put("rows",list.getList() );

        return map;

    }
    @RequestMapping("/addType")
    @ResponseBody
    public String addType(Type Type){
        int temp = -1;
        try {//调用业务实现添加
            temp = service.addType(Type);
            //传统实现跳转到视图
            //返回数据
        } catch (Exception e) {
            e.printStackTrace();//都会打印系统日志
        }

        return "{\"result\":"+temp+"}";//返回结果

    }
    //通过主键查询单 条
    @RequestMapping("/getOneType")
    @ResponseBody
    public Type getOneType(Integer id){
        Type Type = service.selectOne(id);
       // model.addAttribute("Type",Type );
        return Type;
    }

    //通过主键查询单 条进行修改
    @RequestMapping("/updateType")
    @ResponseBody
    public String  updateType(Type Type ){
     // Type Type1 = service.selectOne(id);
        int temp = -1;
        try {
            temp = service.updateType(Type);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return "{\"result\":"+temp+"}";//返回结果
    }

    /*
    * 通过主键id进行删除操作
    * */
    @RequestMapping("/deleteType")
    @ResponseBody
    public String  deleteType(Integer id ){
        //  Type Type1 = service.selectOne(id);
        int temp = -1;
        try {
            temp = service.deleteType(id);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "{\"result\":"+temp+"}";//返回结果
    }

    @RequestMapping("/delMoreType")
    @ResponseBody
    public String  delMoreType(String ids ){
       //将字符串转化为数组
        String[] ss = ids.split(",");
        Integer [] id=new Integer[ss.length];
        for (int i=0;i<ss.length;i++) {
            id[i]=new Integer(ss[i]);

        }
        //调用业务
        int temp = -1;
        try {
            temp =this.service.delMoreType(id);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "{\"result\":"+temp+"}";//返回结果
    }


}
