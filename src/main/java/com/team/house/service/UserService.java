package com.team.house.service;

import com.github.pagehelper.PageInfo;
import com.team.house.entity.Users;
import com.team.house.util.UserConditon;

public interface UserService {
    /*
    * 查询所有注册用户 并进行分页显示
    * 带条件查询所有用户
    * */
    public PageInfo<Users> getAllRUsers(UserConditon userConditon);
    /*
    *用户注册
    *
    * */
    public  int regUser(Users users);
    /*
    * 检查用户名是否存在
    * 返回受影响的行数
    * 返回1说明存在 返回0说明不存在*/
    public  int isUserNameExists(String username);

    /**
     *登录功能
     * @param 用户名
     * @param 密码
     * @return 用户对象
     */
    public Users login(String username,String password);
}
