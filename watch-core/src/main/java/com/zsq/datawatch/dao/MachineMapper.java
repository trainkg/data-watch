package com.zsq.datawatch.dao;

import com.zsq.datawatch.entity.Machine;

public interface MachineMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Machine record);

    int insertSelective(Machine record);

    Machine selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Machine record);

    int updateByPrimaryKey(Machine record);
}