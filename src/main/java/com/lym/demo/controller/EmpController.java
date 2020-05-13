package com.lym.demo.controller;

/*import com.alibaba.excel.ExcelWriter;
import com.alibaba.excel.metadata.Font;
import com.alibaba.excel.metadata.Sheet;
import com.alibaba.excel.metadata.TableStyle;
import com.alibaba.excel.support.ExcelTypeEnum;*/

import com.lym.demo.domain.Result;
import com.lym.demo.service.EmpService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/*
import javax.servlet.http.HttpServletResponse;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;*/

/**
 * @Description
 * @Auther lym
 * @Date 2020-05-08 17:25
 * @Version 1.0
 */
@RestController
@RequestMapping("/emp")
@Slf4j
public class EmpController
{
    @Autowired
    private EmpService empService;

    @GetMapping("/findAll")
    public Result findAll() throws Exception
    {
        return null;
    }


}
