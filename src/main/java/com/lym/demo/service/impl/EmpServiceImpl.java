package com.lym.demo.service.impl;

import com.lym.demo.domain.Emp;
import com.lym.demo.mapper.EmpMapper;
import com.lym.demo.service.EmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Description
 * @Auther lym
 * @Date 2020-05-08 16:16
 * @Version 1.0
 */
@Service
public class EmpServiceImpl implements EmpService
{
    @Autowired
    private EmpMapper empMapper;

    @Override
    public int deleteByPrimaryKey(Integer empno)
    {
        return empMapper.deleteByPrimaryKey(empno);
    }

    @Override
    public int insert(Emp record)
    {
        return empMapper.insert(record);
    }

    @Override
    public int insertSelective(Emp record)
    {
        return empMapper.insertSelective(record);
    }

    @Override
    public Emp selectByPrimaryKey(Integer empno)
    {
        return empMapper.selectByPrimaryKey(empno);
    }

    @Override
    public List<Emp> selectAll()
    {
        return empMapper.selectAll();
    }

    @Override
    public int updateByPrimaryKeySelective(Emp record)
    {
        return empMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(Emp record)
    {
        return empMapper.updateByPrimaryKey(record);
    }
}
