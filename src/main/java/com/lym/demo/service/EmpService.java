package com.lym.demo.service;

import com.lym.demo.domain.Emp;

import java.util.List;

/**
 * @Description
 * @Auther lym
 * @Date 2020-05-08 16:16
 * @Version 1.0
 */

public interface EmpService
{
    int deleteByPrimaryKey(Integer empno);

    int insert(Emp record);

    int insertSelective(Emp record);

    Emp selectByPrimaryKey(Integer empno);

    List<Emp>selectAll();

    int updateByPrimaryKeySelective(Emp record);

    int updateByPrimaryKey(Emp record);
}
