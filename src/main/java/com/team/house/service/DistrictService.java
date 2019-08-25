package com.team.house.service;

import com.github.pagehelper.PageInfo;
import com.team.house.entity.District;
import com.team.house.entity.Street;
import java.util.List;

public interface DistrictService {

    //查询所有区域信息
    public List<District> getAll();
    //查询所有区域信息加分页展示
    public PageInfo<District> getAllByPage(int page, int pageSize);
    /*
    * 添加区域信息
    * */
        public int addDistrict(District district);
        /*
        * 修改区域信息
        * 1.查询要修改的单条对象数据*/
        public District selectOne(Integer id);

    /*
    * 修改选中单条数据信息*/
        public  int updateDistrict(District district);

        /*批量删除通过id数组循环遍历删除
        * */

   /*public  int batchDel(Integer[] ids);*/

    public  int deleteDistrict(Integer id);
    /*
    * 删除街道，根据区域id对其相关的解到进行删除
    * */
        public  int delStreetByDistrict(Integer id);

        /*
        * 批量删除区域
        * */
        public int delMoreDistrict(Integer [] ids);
}
