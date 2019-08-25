package com.team.house.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.team.house.entity.House;
import com.team.house.entity.HouseExample;
import com.team.house.mapper.HouseMapper;
import com.team.house.service.HouseService;
import com.team.house.util.HouseCondition;
import com.team.house.util.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HouseServiceImpl implements HouseService {
    @Autowired
    private HouseMapper houseMapper;

    @Override
    public int addHouse(House house) {
        return houseMapper.insertSelective(house);
    }

    /**
     *
     * @param page 分页
     * @param userid 用户编号
     * @return
     */
    @Override
    public PageInfo<House> getHouseByUser(Page page, Integer userid) {
      //开启分页 给rows属性设置默认值，后期可能不传页大小
        PageHelper.startPage(page.getPage(),page.getRows());
        List<House> list = houseMapper.getHouseByUser(userid);
        return new PageInfo<House>(list);//将分页条件封装到房屋信息中
    }

    @Override
    public House getOneHouse(String id) {
        return houseMapper.getHouseById(id);
    }

    @Override
    public int updateHouse(House house) {
        return houseMapper.updateByPrimaryKeySelective(house);
    }

    @Override
    public int delHouseState(String id, Integer state) {
        House house=new House();
        //设置id
        house.setId(id);
        //设置状态
        house.setIsdel(state);//1删除 0恢复

        return houseMapper.updateByPrimaryKeySelective(house);
    }

    @Override
    public PageInfo<House> getHouseByIsPass(Page page, Integer state ) {
        //开启分页
        PageHelper.startPage(page.getPage(), page.getRows());
       //查询所有

        List<House> list = houseMapper.getHouseIsPass(state);
        return new PageInfo<House>(list);
    }

    @Override
    public int PassHouse(String id, Integer state) {
        House house =new House() ;
        house.setId(id );//设置id
        house.setIspass(state);//设置审核状态

        return houseMapper.updateByPrimaryKeySelective(house);
    }

    @Override
    public PageInfo<House> serachHouse(HouseCondition houseCondition) {
        //开启分页
        PageHelper.startPage(houseCondition.getPage(),houseCondition.getRows() );
        //查询出租房
        List<House> list = houseMapper.getHouseBySearch(houseCondition);
        //进行分页展示
        return new PageInfo<>(list);
    }

    @Override
    public House getHouseById(String id) {
        House house = houseMapper.getHouseById(id);
        house.getId();
        return house ;
    }
}
