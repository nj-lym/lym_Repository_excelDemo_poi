package com.lym.demo.mapper;

import com.lym.demo.domain.Emp;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface EmpMapper {
    int deleteByPrimaryKey(Integer empno);

    int insert(Emp record);

    int insertSelective(Emp record);

    Emp selectByPrimaryKey(Integer empno);

    List<Emp> selectAll();

    int updateByPrimaryKeySelective(Emp record);

    int updateByPrimaryKey(Emp record);
}