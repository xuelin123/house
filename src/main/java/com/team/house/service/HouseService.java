package com.team.house.service;

import com.github.pagehelper.PageInfo;
import com.team.house.entity.House;
import com.team.house.util.HouseCondition;
import com.team.house.util.Page;

import java.util.List;

public interface HouseService {

    /**
     * 发布出租房信息
     * @param house
     * @return 返回受影响的行数
     */
    public int addHouse(House house);

    /**
     *
     * @param page 分页
     * @param userid 用户编号
     * @return 房屋信息
     */
    public PageInfo<House> getHouseByUser(Page page, Integer userid);

    /**
     * 查询单条房屋信息
     * @param id
     * @return
     */
    public House getOneHouse(String id);

    /**
     * 修改房屋信息
     * @param house
     * @return 影响行数
     */
    public int updateHouse(House house);

    /**
     * 修改出租房的状态信息
     * 删除出租房 状态传1
     * 恢复出租房 状态传0
     * @param id 出租房编号
     * @param state 状态信息
     * @return 影响行数
     */
    public int delHouseState(String id,Integer state);

    /**
     * 通过审核状态查询出租房信息
     * @param page 分页信息
     * @param state 审核状态
     * @return  影响行数
     */
    public PageInfo<House> getHouseByIsPass(Page page , Integer state );

    /**
     * 修改出租房的审核状态
     * 通过审核  状态传1
     * 消息审核  状态传0
     * @param id  出租房编号
     * @param state  状态信息
     * @return 影响行数
     */
    public int PassHouse(String id,Integer state);

    /**
     * 浏览所有出租房信息
     * @param houseCondition 查询条件
     * @return 出租房信息
     */
    public PageInfo<House> serachHouse(HouseCondition houseCondition);

    /**
     * 根据主题查询出租房详情信息
     * @param title
     * @return 出租房信息
     */
    public House getHouseById(String title);

}
