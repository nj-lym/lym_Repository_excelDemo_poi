package com.lym.demo.dao;

import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

/**
 * 自定义excel样式接口
 * @Description
 * @Auther lym
 * @Date 2020-05-11 10:54
 * @Version 1.0
 */

public interface CustomExcelStyle
{
    public HSSFCellStyle setExcelHandStyle(HSSFWorkbook workbook);
    public HSSFCellStyle setExcelBodyStyle(HSSFWorkbook workbook);
}
