package com.team.house.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.team.house.entity.District;
import com.team.house.entity.Street;
import com.team.house.entity.StreetExample;
import com.team.house.mapper.DistrictMapper;
import com.team.house.mapper.StreetMapper;
import com.team.house.service.StreetService;
import com.team.house.util.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StreetServiceImpl implements StreetService  {
   @Autowired
   private StreetMapper streetMapper;
    @Autowired
    private DistrictMapper districtMapper;

    @Override
    public PageInfo<Street> getStreetByDistrict(Integer did, Page page) {
        //开启分页
        PageHelper.startPage(page.getPage(),page.getRows());
        StreetExample example = new StreetExample();
        StreetExample.Criteria c  = example.createCriteria();
        c.andDistrictIdEqualTo(did);//封装查询的条件

        List<Street> list = streetMapper.selectByExample(example);

        return  new PageInfo<Street>(list);


    }

    @Override
    public District getDistrictById(Integer did) {
        return districtMapper.selectByPrimaryKey(did);
    }

    @Override
    public int addStreet(Street street) {
        return streetMapper.insertSelective(street);
    }



    /**
     *
     * @param id
     * @return
     */
    @Override
    public Street selectOne(Integer id) {
        return streetMapper.selectByPrimaryKey(id);
    }

    /**
     *
     * @param street
     * @return
     */
    @Override
    public int updateStreet(Street street) {
        return streetMapper.updateByPrimaryKeySelective(street);
    }

    /**
     *
     * @param id
     * @return
     */
    @Override
    public int delStreet(Integer id) {
        return streetMapper.deleteByPrimaryKey(id);
    }

    /**
     * 实现区域id查询其对应的街道
     * @param did
     * @return list
     */
    @Override
    public List<Street> getStreetByDistrict(Integer did) {
        StreetExample example = new StreetExample();
        StreetExample.Criteria c = example.createCriteria();
        c.andDistrictIdEqualTo(did);//封装条件
        List<Street> list = streetMapper.selectByExample(example);
        return list;
    }
}
