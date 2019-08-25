package com.team.house.util;

import com.team.house.service.DistrictService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test1 {
    public static void main(String[] args) {
        ApplicationContext cx=new ClassPathXmlApplicationContext("applicationContext.xml");
        DistrictService service = (DistrictService) cx.getBean("districtServiceImpl");
        int i = service.deleteDistrict(1007);
        System.out.println(i);
    }


}
