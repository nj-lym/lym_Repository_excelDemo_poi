package com.lym.demo.domain;

import com.lym.demo.dao.CustomExcelFont;
import com.lym.demo.dao.CustomExcelStyle;
import lombok.Data;

import java.util.List;

/**
 * sheet模板
 *
 * @Description
 * @Auther lym
 * @Date 2020-05-11 11:33
 * @Version 1.0
 */
@Data
public class SheetTemplateDTO<T>
{
    private String sheetName;
    //单行表头
    private List<String>hand;
    //多行表头
    private String[][] headArrays;
    //列宽
    private String[] columnWidts;
    private CustomExcelStyle customExcelStyle;
    private CustomExcelFont customExcelFont;
    public List<T> dataList;
}
