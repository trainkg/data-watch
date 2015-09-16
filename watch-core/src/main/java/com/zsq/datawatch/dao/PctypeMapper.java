package com.zsq.datawatch.dao;

import com.zsq.datawatch.entity.Pctype;

public interface PctypeMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Pctype record);

    int insertSelective(Pctype record);

    Pctype selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Pctype record);

    int updateByPrimaryKey(Pctype record);
}