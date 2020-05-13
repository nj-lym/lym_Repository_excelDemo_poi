package com.lym.demo.util;

import com.alibaba.excel.support.ExcelTypeEnum;
import lombok.extern.slf4j.Slf4j;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.ss.util.CellRangeAddress;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.Iterator;
import java.util.List;
import java.util.Map;


/**
 * @Description
 * @Auther lym
 * @Date 2020-05-09 15:41
 * @Version 1.0
 */
@Slf4j
public class ExcelUtils
{


    public ExcelUtils()
    {

    }

    public static <T> void exportExcel(String[][] columnNames, String[] columnWidth, List<T> rows, String excelName)
    {
        try {
            HSSFWorkbook workbook = createHSSFWorkbook(columnNames, columnWidth, rows, excelName);
            String fileName = "C:\\Users\\lym.DESKTOP-44MAT4B\\Desktop\\" + excelName + ExcelTypeEnum.XLS.getValue();
            fileName = new String(fileName.getBytes("utf-8"), "utf-8"); // 取消乱码
            OutputStream out = new FileOutputStream(fileName);
            workbook.write(out);
            out.close();
            System.out.println("成功导出Excel，excel名为：" + excelName);
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void exportExcel(HttpServletRequest request, HttpServletResponse response, String[][] columnNames, String[] columnWidth, List<Map<String, Object>> rows, String excelName)
    {
        try {
            HSSFWorkbook workbook = createHSSFWorkbook(columnNames, columnWidth, rows, excelName);
            String fileName = excelName + ExcelTypeEnum.XLS;
            fileName = new String(fileName.getBytes("utf-8"), "utf-8"); // 取消乱码
            response.setContentType("octets/stream");
            response.addHeader("Content-Disposition", "attachment;filename="
                                                      + fileName);
            OutputStream out = response.getOutputStream();
            workbook.write(out);
            out.close();
            System.out.println("成功导出Excel，excel名为：" + excelName);
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }


    public static <T> HSSFWorkbook createHSSFWorkbook(String[][] columnNames, String[] columnWidth, List<T> rows, String excelName)
    {

        HSSFWorkbook workbook = new HSSFWorkbook(); // 创建工作薄，相当于一个文件

        Sheet sheet = workbook.createSheet(); // 创建一个表
        sheet.setDefaultColumnWidth((short) 14); // 设置默认列宽
        //sheet.setColumnWidth(0, 18 * 256); // 设置单位列列宽

        sheet.setMargin(HSSFSheet.TopMargin, 0.64); // 页边距（上）
        sheet.setMargin(HSSFSheet.BottomMargin, 0.64); // 页边距（下）
        sheet.setMargin(HSSFSheet.LeftMargin, 0.64); // 页边距（左）
        sheet.setMargin(HSSFSheet.RightMargin, 0.64); // 页边距（右）

        PrintSetup ps = sheet.getPrintSetup();
        ps.setPaperSize(PrintSetup.A4_PAPERSIZE); // 设置纸张大小
        ps.setLandscape(true); // 打印方向，true：横向，false：纵向(默认)

        // 标题样式
        CellStyle titleStyle = workbook.createCellStyle();
        titleStyle.setAlignment(HorizontalAlignment.CENTER); // 水平居中
        titleStyle.setVerticalAlignment(VerticalAlignment.CENTER); // 垂直居中
        // 标题字体
        Font titleFont = workbook.createFont();
        titleFont.setFontHeightInPoints((short) 14); // 字体大小
        titleFont.setFontName("中华新魏");
        titleStyle.setFont(titleFont);

        // 填报单位的样式
        CellStyle titleStyle_2 = workbook.createCellStyle();
        titleStyle_2.setAlignment(HorizontalAlignment.CENTER); // 水平居右
        titleStyle_2.setVerticalAlignment(VerticalAlignment.CENTER); // 垂直居中
        // 标题字体
        Font titleFont_2 = workbook.createFont();
        titleFont_2.setFontHeightInPoints((short) 14);
        titleFont_2.setFontName("中华新魏");
        titleFont.setBold(true);
        titleStyle_2.setFont(titleFont_2);

        // 填报单位的样式
        CellStyle titleStyle_u = workbook.createCellStyle();
        titleStyle_u.setAlignment(HorizontalAlignment.CENTER); // 水平居左
        titleStyle_u.setVerticalAlignment(VerticalAlignment.CENTER); // 垂直居中
        // 标题字体
        Font titleFont_u = workbook.createFont();
        titleFont_u.setUnderline(HSSFFont.U_SINGLE);
        titleFont_u.setFontHeightInPoints((short) 11);
        titleFont_u.setFontName("宋体");
        titleStyle_u.setFont(titleFont_u);

        // 表头样式
        CellStyle headerStyle = workbook.createCellStyle();
        headerStyle.setAlignment(HorizontalAlignment.CENTER); // 水平居中
        headerStyle.setVerticalAlignment(VerticalAlignment.CENTER); // 垂直居中
//        headerStyle.setWrapText(true); // 设置多行显示
        //这两句话是表示将表头单元格格式设置为文本型，在后面只要调用-----.setDataFormat(format.getFormat("@"))的方法就可以将数据设置为文本型。
        DataFormat format = workbook.createDataFormat();
        headerStyle.setDataFormat(format.getFormat("@"));
        // 表头字体
        Font headerFont = workbook.createFont();
        headerFont.setFontHeightInPoints((short) 12);
        headerFont.setFontName("中华新魏");
        headerFont.setBold(true);
        headerStyle.setFont(headerFont);

        // 数据样式
        CellStyle dataStyle = workbook.createCellStyle();
        dataStyle.setAlignment(HorizontalAlignment.CENTER); // 水平居中
        dataStyle.setVerticalAlignment(VerticalAlignment.CENTER); // 垂直居中
        dataStyle.setDataFormat(format.getFormat("@"));      //将数据单元格格式设置为文本类型
        // 数据字体
        Font dataFont = workbook.createFont();
        dataFont.setFontHeightInPoints((short) 12);
        dataFont.setFontName("微软雅黑");
        dataStyle.setFont(dataFont);

        // 尾部样式
        CellStyle footStyle = workbook.createCellStyle();
        footStyle.setAlignment(HorizontalAlignment.CENTER); // 水平居中
        footStyle.setVerticalAlignment(VerticalAlignment.CENTER); // 垂直居中
        // 尾部字体
        Font footFont = workbook.createFont();
        footFont.setFontHeightInPoints((short) 11);
        footFont.setFontName("宋体");
        footStyle.setFont(footFont);

//        CellStyle commonStyle = workbook.createCellStyle();


        // 表格标题行
        Row row0 = sheet.createRow(0);
        row0.setHeight((short) (3 * 256));
        Cell cell0_0 = row0.createCell(0); // 创建单元格，参数说明的是第几个单元格
        cell0_0.setCellStyle(titleStyle);
        cell0_0.setCellValue(excelName); // 设置单元格 和里面的内容

        if (columnWidth != null) {
            if (columnWidth.length > 0) {
                Integer clWidth;
                for (int i = 0; i < columnWidth.length; i++) {
                    if (columnWidth[i] != null && !"".equals(columnWidth[i])) {
                        clWidth = Integer.valueOf(columnWidth[i]);
                        sheet.setColumnWidth(i, clWidth * 256);
                    }
                }
            }
        }

        Row row = null;
        Cell cell = null;
        for (int i = 0; i < columnNames.length; i++) {
            row = sheet.createRow(sheet.getLastRowNum() + 1);
            row.setHeight((short) (2 * 256));
            for (int j = 0; j < columnNames[i].length; j++) {
                cell = row.createCell(j);
                cell.setCellValue(columnNames[i][j]);
                cell.setCellStyle(headerStyle);

            }
        }

        sheet.getRow(columnNames.length).setZeroHeight(true);
        // 合并单元格
        sheet.addMergedRegion(new CellRangeAddress(0, 0, 0, columnNames[0].length - 1)); // 合并大标题行
//        String[] names = columnNames[columnNames.length - 1];

        // 数据填充,标题占一行，columnNames占columnNames.length行，之后才到数据行

        String name = null;
        String methodName = null;

        Iterator<T> it = rows.iterator();
        T t = null;
        while (it.hasNext()) {
            t = (T) it.next();
            Class clzz = t.getClass();
            Field[] fields = t.getClass().getDeclaredFields();
            //创建一行
            row = sheet.createRow(sheet.getLastRowNum() + 1);
            //创建单元格
            for (int i = 0; i < fields.length - 1; i++) {
                name = fields[i].getName();
                methodName = "get" + (name.substring(0, 1)).toUpperCase() + name.substring(1, name.length());
                try {
                    //获取执行的方法
                    Method method = clzz.getDeclaredMethod(methodName);
                    //获取方法的返回值类型
                    String returnType = method.getReturnType().getTypeName();
                    //获取属性的值
                    Object value = method.invoke(t);
                     cell = row.createCell(i);
                    if (returnType.equals("java.util.Date") || returnType.equals("java.sql.Date")) {
                        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
                        cell.setCellValue(dateFormat.format(value));
                    }
                    else {
                        cell.setCellValue(value.toString());
                    }
                    cell.setCellStyle(dataStyle);
                }
                catch (Exception e) {
                    e.printStackTrace();
                }
            }

        }
        return workbook;
    }

}
