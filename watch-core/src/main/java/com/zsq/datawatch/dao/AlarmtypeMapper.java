package com.zsq.datawatch.dao;

import java.util.List;

import com.zsq.datawatch.entity.Alarmtype;

public interface AlarmtypeMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Alarmtype record);

    int insertSelective(Alarmtype record);

    Alarmtype selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Alarmtype record);

    int updateByPrimaryKey(Alarmtype record);

	List<Alarmtype> findAll();
}