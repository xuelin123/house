package com.team.house.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.team.house.entity.Users;
import com.team.house.entity.UsersExample;
import com.team.house.mapper.UsersMapper;
import com.team.house.service.UserService;
import com.team.house.util.MD5Utils;
import com.team.house.util.UserConditon;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UsersMapper usersMapper;

    @Override
    public PageInfo<Users> getAllRUsers(UserConditon userConditon) {
       //开启分页
        PageHelper.startPage(userConditon.getPage(),userConditon.getRows() );

        //封装查询条件
        UsersExample example = new UsersExample();
        UsersExample.Criteria c  = example.createCriteria();
        c.andIsadminEqualTo(+new Integer(0));//注册用户
        //添加搜索条件
        if (userConditon.getName()!=null) {
            c.andNameLike("%"+userConditon.getName()+"%");
        }
        if (userConditon.getTelephone()!=null) {
            c.andTelephoneLike("%"+userConditon.getTelephone()+"%");
        }
        List<Users> users  = usersMapper.selectByExample(example);


        PageInfo<Users> pageInfo=new PageInfo<>(users);

        return pageInfo;

    }

    @Override
    public int regUser(Users users) {
        //设置注册用户
       users.setIsadmin(new Integer(0));
       //采用MD5对用户输入的密码进行加密处理
        users.setPassword(MD5Utils.md5Encrypt(users.getPassword()));

        return usersMapper.insertSelective(users );
    }

    @Override
    public int isUserNameExists(String username) {

        return usersMapper.getUserCount(username);
    }

    @Override
    public Users login(String username, String password) {
        UsersExample example = new UsersExample();
        UsersExample.Criteria criteria = example.createCriteria();
        //知道注册用户
      //  criteria.andIsadminEqualTo(0);
        //知道用户名和密码
        criteria.andNameEqualTo(username);
        /**
         字符串类型条件必须用“%”进行拼接否则无法取到相应的参数值*/
        criteria.andPasswordEqualTo(MD5Utils.md5Encrypt(password));//密码进行加密
        //执行
        List<Users> list = usersMapper.selectByExample(example);

        if (list.size()==0) {
            return null;
        } else {
            return list.get(0);
        }
    }
}
