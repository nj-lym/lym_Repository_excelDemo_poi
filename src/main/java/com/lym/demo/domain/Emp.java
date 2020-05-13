package com.lym.demo.domain;

import com.alibaba.excel.annotation.ExcelProperty;
import com.alibaba.excel.metadata.BaseRowModel;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * emp
 * @author 
 */
@Data
@ApiModel("员工信息")
public class Emp extends BaseRowModel implements Serializable {


    @ApiModelProperty("编号")
    @ExcelProperty("编号")
    private Integer id;

    @ApiModelProperty("员工号")
    @ExcelProperty("员工号")
    private Integer empno;

    @ApiModelProperty("姓名")
    @ExcelProperty("姓名")
    private String ename;

    @ApiModelProperty("薪资")
    @ExcelProperty("薪资")
    private Double salary;

    @ApiModelProperty("奖金")
    @ExcelProperty("奖金")
    private Double bonus;

    @ApiModelProperty("入职时间")
    @ExcelProperty("入职时间")
    private Date hiredate;

    @ApiModelProperty("部门号")
    @ExcelProperty("部门号")
    private Integer deptno;

    private static final long serialVersionUID = 1L;
}