package com.team.house.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.team.house.entity.Type;
import com.team.house.entity.TypeExample;
import com.team.house.mapper.TypeMapper;
import com.team.house.service.TypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class TypeServiceImpl implements TypeService {
@Autowired
    private  TypeMapper typeMapper;

    @Override
    public List<Type> getAll() {
        return typeMapper.selectByExample(new TypeExample());
    }

    @Override
    public PageInfo<Type> getAllByPage(int page, int pageSize) {
        //开启分页
        PageHelper.startPage(page,pageSize );
        TypeExample example = new TypeExample();
        TypeExample.Criteria c  = example.createCriteria();
        List<Type> types = typeMapper.selectByExample(example);
        PageInfo<Type> pageInfo = new PageInfo<>(types);//封装分页条件进行分页展示
        return pageInfo;
    }

    @Override
    public int addType(Type type) {
        return typeMapper.insertSelective(type);
    }

    @Override
    public Type selectOne(Integer id) {
        return typeMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateType(Type type) {
        return typeMapper.updateByPrimaryKeySelective(type);
    }



    @Override
    public int deleteType(Integer id) {
        return typeMapper.deleteByPrimaryKey(id);
    }


    @Override
    public int delMoreType(Integer[] ids) {

        return typeMapper.delMorType(ids);
    }
}
