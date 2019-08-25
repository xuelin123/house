package com.team.house.service;

import com.github.pagehelper.PageInfo;
import com.team.house.entity.Type;

import java.util.List;

public interface TypeService {

    //查询所有区域信息
    public List<Type> getAll();
    //查询所有区域信息加分页展示
    public PageInfo<Type> getAllByPage(int page, int pageSize);
    /*
     * 添加区域信息
     * */
    public int addType(Type type);
    /*
     * 修改区域信息
     * 1.查询要修改的单条对象数据*/
    public Type selectOne(Integer id);

    /*
     * 修改选中单条数据信息*/
    public  int updateType(Type type);

    /*批量删除通过id数组循环遍历删除
     * */

    /*public  int batchDel(Integer[] ids);*/

    public  int deleteType(Integer id);
    /*
     * 删除街道，根据区域id对其相关的解到进行删除
     * */
  //  public  int delStreetByType(Integer id);

    /*
     * 批量删除区域
     * */
    public int delMoreType(Integer [] ids);

}
