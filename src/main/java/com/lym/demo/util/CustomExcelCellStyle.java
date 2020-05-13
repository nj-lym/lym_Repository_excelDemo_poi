package com.lym.demo.util;

import com.lym.demo.dao.CustomExcelFont;
import com.lym.demo.dao.CustomExcelStyle;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFDataFormat;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.usermodel.BorderStyle;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.HorizontalAlignment;
import org.apache.poi.ss.usermodel.VerticalAlignment;

/**
 * 自定义excel样式
 *
 * @Description
 * @Auther lym
 * @Date 2020-05-11 10:44
 * @Version 1.0
 */

public class CustomExcelCellStyle implements CustomExcelStyle,CustomExcelFont
{
    @Override
    public HSSFFont setHSSFFont(HSSFWorkbook workbook)
    {
        HSSFFont font = workbook.createFont();
        font.setFontName("中华新魏");
        font.setBold(true);
        font.setFontHeightInPoints((short) 16);

        return font;
    }

    @Override
    public HSSFCellStyle setExcelHandStyle(HSSFWorkbook workbook)
    {
        HSSFCellStyle cellStyle = workbook.createCellStyle();
        cellStyle.setVerticalAlignment(VerticalAlignment.CENTER);//单元格-垂直居中
        cellStyle.setAlignment(HorizontalAlignment.CENTER);//单元格-水平居中
        cellStyle.setFillPattern(FillPatternType.DIAMONDS);//背景色-方块填充
        cellStyle.setFont(setHSSFFont(workbook));//设置字体
        return cellStyle;
    }

    @Override
    public HSSFCellStyle setExcelBodyStyle(HSSFWorkbook workbook)
    {
        HSSFCellStyle cellStyle = workbook.createCellStyle();
        cellStyle.setVerticalAlignment(VerticalAlignment.CENTER);//单元格-垂直居中
        cellStyle.setAlignment(HorizontalAlignment.CENTER);//单元格-水平居中
        cellStyle.setFillForegroundColor(HSSFColor.HSSFColorPredefined.BLUE.getIndex());//前背景色-天蓝
        cellStyle.setFillBackgroundColor(HSSFColor.HSSFColorPredefined.LIGHT_YELLOW.getIndex());//后背景色-浅黄

        cellStyle.setBorderBottom(BorderStyle.MEDIUM_DASH_DOT_DOT);//底边框样式-倾斜断点
        cellStyle.setBottomBorderColor(HSSFColor.HSSFColorPredefined.DARK_RED.getIndex());//底边框颜色-暗红

        cellStyle.setDataFormat(HSSFDataFormat.getBuiltinFormat("yyyy-MM-dd"));//日期显示格式
        cellStyle.setFont(setHSSFFont(workbook));//设置字体
        return cellStyle;
    }
}
