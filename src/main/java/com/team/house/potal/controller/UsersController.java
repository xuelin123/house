package com.team.house.potal.controller;

import com.sun.glass.ui.Window;
import com.team.house.entity.Users;
import com.team.house.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/page")
public class UsersController {
    @Autowired
    private UserService userService;

    @RequestMapping("/reg")
    public  String reg(Users users){
        int temp = userService.regUser(users);
       if (temp>0){
        return "login";//登录页
       }else {
           return "regs";//注册页
       }

    }
        //检查用户名是否存在，异步返回数据
    @RequestMapping("/checkUserName")
    @ResponseBody
    public Map<String ,Object> checkUserName(String username){

        int temp = userService.isUserNameExists(username);
        //返回数据
        Map<String,Object> map=new HashMap<>() ;
        map.put("result",temp );
        return map;
    }
    /**
     * 实现登录
     */
        @RequestMapping("/login")
    public String  checkUserName(String username, String password, HttpSession httpSession){
            Users user = userService.login(username, password);

            if (user==null) {

                return "login";
            } else
                /**
                 * 注意：只要登入成功，必须使用session保存登入人的信息或者cookie保存
                 * session保存的信息在服务器与浏览器共存
                 */
                httpSession.setAttribute("userInfo",user );
                /**
                 * 设置保存的时间
                 */
                httpSession.setMaxInactiveInterval(600);//6分钟

              return "redirect:getHouse";
        }

    /**
     * 手机号验证登录
      * @param inputCode
     * @param httpSession
     * @return
     */
    @RequestMapping("/login2")
    public String  checkUserName(String inputCode, HttpSession httpSession){
     //设置生成的验证码
        String code = (String) httpSession.getAttribute("code");
        //比较验证码
        if (inputCode.equals(code)){
            //通过用户手机号查询单个用户信息，并保存到session中
            return "redirect:getHouse";
        }else {
            return "login";//返回登录界面
        }

    }

}
