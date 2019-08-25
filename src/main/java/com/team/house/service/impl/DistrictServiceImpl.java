package com.team.house.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.team.house.entity.District;
import com.team.house.entity.DistrictExample;
import com.team.house.mapper.DistrictMapper;
import com.team.house.mapper.StreetMapper;
import com.team.house.service.DistrictService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
public class DistrictServiceImpl implements DistrictService {

    @Autowired
    private DistrictMapper districtMapper;
    @Autowired
    private StreetMapper streetMapper;

    @Override
    public List<District> getAll() {
        //添加封装查询条件相关的参数
        DistrictExample example = new DistrictExample();
        List<District> districts = districtMapper.selectByExample(example);

        return districts;
    }

    @Override
    public PageInfo<District> getAllByPage(int page, int pageSize) {
        //开启分页
        PageHelper.startPage(page,pageSize );
        //查询所有区域信息
        List<District> districts = districtMapper.selectByExample(null);
        //获取分页的相关信息
        PageInfo pageInfo = new PageInfo(districts);
        System.out.println("页码"+pageInfo.getPageNum());
        System.out.println("页大小"+pageInfo.getPageSize());
        System.out.println("总页数"+pageInfo.getPages());
        System.out.println("总行数"+pageInfo.getTotal());
        System.out.println("当前页的记录数"+pageInfo.getList());
        System.out.println("首页"+pageInfo.getNavigateFirstPage());
        System.out.println("上一页"+pageInfo.getPrePage());
        System.out.println("下一页"+pageInfo.getNextPage());
        System.out.println("尾页"+pageInfo.getNavigateLastPage());

        return pageInfo;
    }

    @Override//添加区域信息，返回影响的行数信息
    public int addDistrict(District district) {
        return districtMapper.insertSelective(district);
    }

    @Override
    public District selectOne(Integer id) {
        return districtMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateDistrict(District district) {
       // District district1 = districtMapper.selectByPrimaryKey(id);

        return districtMapper.updateByPrimaryKeySelective(district);
    }

    @Override
    @Transactional//添加事务，删除区域同时，删除街道，保证事务的一致性
    public int deleteDistrict(Integer id) {
        try {
            //删除区域的同时，删除街道   先删除外键，再删除主键
            //1.删除区域下的街道     DELETE FROM street WHERE district_id=id
            streetMapper.delStreetByDistrict(id);
            //2.删除区域
            districtMapper.deleteByPrimaryKey(id);
        } catch (Exception e) {
            return -1;
        }
        return 1;
    }

    @Override
    public int delStreetByDistrict(Integer id) {
        return streetMapper.delStreetByDistrict(id);
    }

    @Override
    public int delMoreDistrict(Integer[] ids) {
        return districtMapper.delMoreDistrict(ids);
    }

   /* @Override
    public int batchDel(Integer[] ids) {
        DistrictExample e = new DistrictExample();
        DistrictExample.Criteria c = e.createCriteria();
        c.andIdIn(Arrays.asList(ids));
        return districtMapper.deleteByPrimaryKey(e);
    }*/
}
