package com.authority.dao;


import java.util.List;
import org.apache.ibatis.annotations.Param;

import com.authority.pojo.Criteria;
import com.authority.pojo.Wzsjjcarpeccancy;

public interface WzsjjcarpeccancyMapper {
    /**
     * 根据条件查询记录总数
     */
    int countByExample(Criteria example);

    /**
     * 根据条件删除记录
     */
    int deleteByExample(Criteria example);

    /**
     * 根据主键删除记录
     */
    int deleteByPrimaryKey(String id);

    /**
     * 保存记录,不管记录里面的属性是否为空
     */
    int insert(Wzsjjcarpeccancy record);

    /**
     * 保存属性不为空的记录
     */
    int insertSelective(Wzsjjcarpeccancy record);

    /**
     * 根据条件查询记录集
     */
    List<Wzsjjcarpeccancy> selectByExample(Criteria example);

    /**
     * 根据主键查询记录
     */
    Wzsjjcarpeccancy selectByPrimaryKey(String id);

    /**
     * 根据条件更新属性不为空的记录
     */
    int updateByExampleSelective(@Param("record") Wzsjjcarpeccancy record, @Param("example") Criteria example);

    /**
     * 根据条件更新记录
     */
    int updateByExample(@Param("record") Wzsjjcarpeccancy record, @Param("example") Criteria example);

    /**
     * 根据主键更新属性不为空的记录
     */
    int updateByPrimaryKeySelective(Wzsjjcarpeccancy record);

    /**
     * 根据主键更新记录
     */
    int updateByPrimaryKey(Wzsjjcarpeccancy record);
}