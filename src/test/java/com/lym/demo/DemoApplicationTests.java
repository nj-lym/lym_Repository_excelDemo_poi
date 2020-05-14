package com.lym.demo;

import com.alibaba.excel.support.ExcelTypeEnum;
import com.lym.demo.domain.Emp;
import com.lym.demo.service.EmpService;
import com.lym.demo.util.ExcelUtils;
import org.apache.poi.hssf.usermodel.*;
import org.apache.poi.ss.usermodel.HorizontalAlignment;
import org.apache.poi.ss.usermodel.VerticalAlignment;
import org.apache.poi.ss.util.CellRangeAddress;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.reflect.Field;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

@SpringBootTest
class DemoApplicationTests
{

    @Autowired
    private EmpService empService;

    @Test
    void contextLoads()
    {
        String filePath = "C:\\Users\\lym.DESKTOP-44MAT4B\\Desktop\\" + "员工信息表" + ExcelTypeEnum.XLS.getValue();//文件路径
        HSSFWorkbook workbook = new HSSFWorkbook();//创建Excel文件(Workbook)
        HSSFSheet sheet = workbook.createSheet();//创建工作表(Sheet)
        sheet = workbook.getSheetAt(0);//创建工作表(Sheet)
        //设置列宽
        sheet.setDefaultColumnWidth(15);
        //设置样式
        HSSFCellStyle cellStyle = workbook.createCellStyle();
        cellStyle.setAlignment(HorizontalAlignment.CENTER);
        cellStyle.setVerticalAlignment(VerticalAlignment.CENTER);
        HSSFFont font = workbook.createFont();
        font.setFontName("中华新魏");
        font.setBold(true);
        font.setFontHeightInPoints((short) 16);
        cellStyle.setFont(font);
        //设置表头
        HSSFRow titleRow = sheet.createRow(0);
        titleRow.createCell(0).setCellValue("员工信息表");
        //合并单元格
        sheet.addMergedRegion(new CellRangeAddress(0, 2, 0, 6));
        titleRow.getCell(0).setCellStyle(cellStyle);
        System.out.println(sheet.getLastRowNum());
        //设置表头字段
        HSSFRow handRow = sheet.createRow(sheet.getLastRowNum() + 3);
        handRow.createCell(0).setCellValue("编号");
        handRow.createCell(handRow.getLastCellNum()).setCellValue("员工号");
        handRow.createCell(handRow.getLastCellNum()).setCellValue("姓名");
        handRow.createCell(handRow.getLastCellNum()).setCellValue("薪资");
        handRow.createCell(handRow.getLastCellNum()).setCellValue("奖金");
        handRow.createCell(handRow.getLastCellNum()).setCellValue("入职时间");
        handRow.createCell(handRow.getLastCellNum()).setCellValue("部门号");

        for (int i = 0; i < handRow.getLastCellNum(); i++) {
            handRow.getCell(i).setCellStyle(cellStyle);
        }
        //设置数据体
        List<Emp> empList = empService.selectAll();
        HSSFRow bodyRow = null;
        List<HSSFRow> rowList = new ArrayList<>();
        int index = 1;
        for (Emp emp : empList) {
            bodyRow = sheet.createRow(sheet.getLastRowNum() + 1);
            bodyRow.createCell(0).setCellValue(index++);
            bodyRow.createCell(bodyRow.getLastCellNum()).setCellValue(emp.getEmpno());
            bodyRow.createCell(bodyRow.getLastCellNum()).setCellValue(emp.getEname());
            bodyRow.createCell(bodyRow.getLastCellNum()).setCellValue(emp.getSalary());
            bodyRow.createCell(bodyRow.getLastCellNum()).setCellValue(emp.getBonus());
            bodyRow.createCell(bodyRow.getLastCellNum()).setCellValue(new SimpleDateFormat("yyyy-MM-dd").format(emp.getHiredate()));
            bodyRow.createCell(bodyRow.getLastCellNum()).setCellValue(emp.getDeptno());
            rowList.add(bodyRow);
        }
        //设置数据体样式
        for (int i = 0; i < rowList.size(); i++) {
            for (int j = 0; j < rowList.get(i).getLastCellNum(); j++) {
                rowList.get(i).getCell(j).setCellStyle(cellStyle);
            }
        }
        try {
            FileOutputStream out = new FileOutputStream(filePath);
            workbook.write(out);//保存Excel文件
            out.close();//关闭文件流
            System.out.println("OK!");
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    void test()
    {
        String [][] titleColumn={{"编号","员工号", "姓名", "薪资", "奖金", "入职时间", "部门号"},{"id","empno","ename","salary","bonus","hiredate","deptno"}};
        String[] bean={"empno","ename","salary","bonus","hiredate","deptno"};
        List<Emp> empList = empService.selectAll();
        String fileName = "员工信息表";//文件路径
        ExcelUtils.exportExcel(titleColumn,new String[]{},empList,fileName);

    }

    @Test
    public void main() throws Exception
    {
        //使用反射第一步:获取操作类FieldDemo所对应的Class对象
        Class<?> cls = Class.forName("com.lym.demo.domain.Emp");
        //使用FieldDemo类的class对象生成 实例
        Object obj = cls.newInstance();
        //通过Class类中getField(String name)： 获取类特定的方法，name参数指定了属性的名称

        Field field = cls.getDeclaredField("empno");
        field.setAccessible(true);
        //拿到了Field类的实例后就可以调用其中的方法了
        //方法:get(Object obj) 返回指定对象obj上此 Field 表示的字段的值
        System.out.println("属性值:  " + field.get(obj));

        //方法: set(Object obj, Object value)  将指定对象变量上此 Field 对象表示的字段设置为指定的新值
        field.set(obj, 55);
        System.out.println("--> get(Object obj):  " + field.get(obj));
    }

}
