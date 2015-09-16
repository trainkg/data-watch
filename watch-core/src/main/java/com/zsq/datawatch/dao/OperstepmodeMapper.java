package com.zsq.datawatch.dao;

import com.zsq.datawatch.entity.Operstepmode;

public interface OperstepmodeMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Operstepmode record);

    int insertSelective(Operstepmode record);

    Operstepmode selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Operstepmode record);

    int updateByPrimaryKey(Operstepmode record);
}