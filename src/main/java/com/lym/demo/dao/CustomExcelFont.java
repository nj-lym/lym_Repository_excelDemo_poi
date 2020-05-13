package com.lym.demo.dao;

import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

/**
 * 自定义excel字体
 * @Description
 * @Auther lym
 * @Date 2020-05-11 10:57
 * @Version 1.0
 */

public interface CustomExcelFont
{
    public HSSFFont setHSSFFont(HSSFWorkbook workbook);
}
