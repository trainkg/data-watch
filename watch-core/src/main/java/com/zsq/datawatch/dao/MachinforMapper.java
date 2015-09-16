package com.zsq.datawatch.dao;

import com.zsq.datawatch.entity.Machinfor;

public interface MachinforMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Machinfor record);

    int insertSelective(Machinfor record);

    Machinfor selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Machinfor record);

    int updateByPrimaryKey(Machinfor record);
}