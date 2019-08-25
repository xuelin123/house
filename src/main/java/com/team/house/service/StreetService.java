package com.team.house.service;

import com.github.pagehelper.PageInfo;
import com.team.house.entity.District;
import com.team.house.entity.Street;
import com.team.house.util.Page;

import java.util.List;


public interface StreetService {
    /*根据区域id查询其对应的街道*/
    public PageInfo<Street> getStreetByDistrict(Integer did, Page page);

    /**
     * 根据区域id查询单条信息
     * @param did
     * @returnd
     */
   public District getDistrictById(Integer did);
    /*
    *根据区域id
     * 添加街道 */
    public int addStreet(Street street);
    /*
     * 修改区域信息
     * 1.查询要修改的单条对象数据*/
    public Street selectOne(Integer id);
    /*修改街道信息*/
    public int updateStreet(Street street);
    /*删除街道*/
    public int delStreet(Integer id);

    /**
     * 根据区域id查询对应的街道
     * @param did
     * @return list集合
     */
    public List<Street> getStreetByDistrict(Integer did);
}
