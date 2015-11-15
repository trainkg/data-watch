package com.zsq.datawatch.dao;

import java.util.List;

import com.zsq.datawatch.entity.Opermode;

public interface OpermodeMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Opermode record);

    int insertSelective(Opermode record);

    Opermode selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Opermode record);

    int updateByPrimaryKey(Opermode record);

	List<Opermode> findAll();
}