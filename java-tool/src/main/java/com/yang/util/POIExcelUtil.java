package com.yang.util;

import com.yang.model.Student;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.*;
import java.util.*;

public class POIExcelUtil {

    public static Workbook getExcelWorkbook(String filePath) throws Exception {
        Workbook workbook = null;
        FileInputStream fileInputStream = null;

        try {
            if (!filePath.endsWith(".xls") && !filePath.endsWith(".xlsx")) {
                throw new Exception("The file is not excel document!");
            }

            File file = new File(filePath);
            if (!file.exists()) {
                throw new Exception("The file is not exist!");
            }

            fileInputStream = new FileInputStream(filePath);
            if (filePath.endsWith("xls")) {//2003格式
                workbook = new HSSFWorkbook(fileInputStream);
            } else if (filePath.endsWith("xlsx")) {//2007格式
                workbook = new XSSFWorkbook(fileInputStream);
            }

        } catch (Exception e) {
            e.printStackTrace();
            throw new Exception("analysis excel exception!", e);
        } finally {
            if (null != fileInputStream) {
                fileInputStream.close();
            }
        }

        return workbook;
    }

    public static Workbook getExcelWorkbook2(String filePath) throws Exception {
        Workbook workbook = null;

        try {
            if (!filePath.endsWith(".xls") && !filePath.endsWith(".xlsx")) {
                throw new Exception("The file is not excel document!");
            }

            File file = new File(filePath);
            if (!file.exists()) {
                throw new FileNotFoundException("The file is not exist!");
            }

            workbook = WorkbookFactory.create(file);

        } catch (Exception e) {
            e.printStackTrace();
            throw new Exception("analysis excel exception!", e);
        }

        return workbook;
    }

    public static Workbook getExcelWorkbook(File file) throws Exception {
        Workbook workbook = null;

        if (null == file || !file.exists()) {
            throw new Exception("The file is not exist!");
        }

        try {
            workbook = WorkbookFactory.create(file);
        } catch (Exception e) {
            e.printStackTrace();
            throw new Exception("analysis excel exception!", e);
        }

        return workbook;
    }

    /**
     * excel导出
     *
     * @param filePath   导出的文件路径
     * @param sheetName  导出的sheet名称
     * @param list       数据集合
     * @param titles     第一行表头
     * @param fieldNames 字段名称数组
     */
    public static <T> void export(String filePath, String sheetName, List<T> list,
                                  String[] titles, String[] fieldNames) throws Exception {

        if (!filePath.endsWith(".xls") && !filePath.endsWith(".xlsx")) {
            throw new Exception("The file is not excel document!");
        }

        Workbook workbook = null;
        Sheet sheet = null;

        if (filePath.endsWith("xls")) {//2003格式
            workbook = new HSSFWorkbook();
        } else if (filePath.endsWith("xlsx")) {//2007格式
            workbook = new XSSFWorkbook();
        }

        if (null == sheetName || "".equals(sheetName)) {
            sheetName = "sheet1";
        }

        if (null == workbook) {
            throw new Exception("create workbook error!");
        }

        sheet = workbook.createSheet(sheetName);
        CellStyle commonStyle = CellStyleUtil.createStyle(workbook);

        // 设置表头
        Row topRow = sheet.createRow(0);
        for (int i = 0; i < titles.length; i++) {
            setCellValue(topRow.createCell(i), titles[i], commonStyle);
        }

        for (int i = 0; i < list.size(); i++) {
            T t = list.get(i);
            Row row = sheet.createRow(i + 1);
            for (int j = 0; j < fieldNames.length; j++) {
                try {
                    Object ret = PropertyUtil.getProperty(t, fieldNames[j]);
                    setCellValue(row.createCell(j), ret + "", commonStyle);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }

        FileOutputStream outputStream = null;

        try {
            outputStream = new FileOutputStream(filePath);
            workbook.write(outputStream);
        } catch (IOException e) {
            throw new Exception("write excel file error!", e);
        } finally {
            if (null != outputStream) {
                outputStream.flush();
                outputStream.close();
            }
        }
    }

    /**
     * excel导入
     *
     * @param keys     字段名称数组，如  ["id", "name", ... ]
     * @param filePath 文件物理地址
     */
    public static List<Map<String, Object>> imp(String filePath, String[] keys) throws Exception {
        if (!filePath.endsWith(".xls") && !filePath.endsWith(".xlsx")) {
            throw new Exception("The file is not excel document!");
        }

        if (null == keys) {
            throw new Exception("keys can not be null!");
        }

        List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();

        Workbook wookbook = getExcelWorkbook(filePath);
        // 获取第一个工作表信息
        Sheet sheet = wookbook.getSheetAt(0);
        //获得数据的总行数
        int totalRowNum = sheet.getLastRowNum();
        // 获得表头
        Row rowHead = sheet.getRow(0);
        // 获得表头总列数
        int cols = rowHead.getPhysicalNumberOfCells();
        // 传入的key数组长度与表头长度不一致
        if (keys.length != cols) {
            throw new Exception("keys length does not match head row's cols!");
        }

        Row row = null;
        Cell cell = null;
        Object value = null;
        Map<String, Object> map = null;

        // 遍历所有行
        for (int i = 1; i <= totalRowNum; i++) {
            // 清空数据，避免遍历时读取上一次遍历数据
            row = null;
            cell = null;
            value = null;
            map = new HashMap<String, Object>();

            row = sheet.getRow(i);
            if (null == row) continue;    // 若该行第一列为空，则默认认为该行就是空行

            // 遍历该行所有列
            for (short j = 0; j < cols; j++) {
                cell = row.getCell(j);
                if (null == cell) continue;    // 为空时，下一列

                // 根据poi返回的类型，做相应的get处理
                if (Cell.CELL_TYPE_STRING == cell.getCellType()) {
                    value = cell.getStringCellValue();
                } else if (Cell.CELL_TYPE_NUMERIC == cell.getCellType()) {
                    value = cell.getNumericCellValue();
                    // 由于日期类型格式也被认为是数值型，此处判断是否是日期的格式，若是，则读取为日期类型
                    if (cell.getCellStyle().getDataFormat() > 0) {
                        value = cell.getDateCellValue();
                    }
                } else if (Cell.CELL_TYPE_BOOLEAN == cell.getCellType()) {
                    value = cell.getBooleanCellValue();
                } else if (Cell.CELL_TYPE_BLANK == cell.getCellType()) {
                    value = cell.getDateCellValue();
                } else {
                    throw new Exception("At row: %s, col: %s, can not discriminate type!");
                }

                map.put(keys[j], value);
            }

            list.add(map);
        }

        return list;
    }

    private static void setCellValue(Cell cell, String value, CellStyle cellStyle) {
        cell.setCellValue(value);
        cell.setCellStyle(cellStyle);
    }

    public static void main(String[] args) {
        String filePath = "/Users/yangjun/Desktop/chengjia/student.xls";
        //Workbook wb = null;
        //try {
        //    wb = getExcelWorkbook2(fileNamePath);
        //} catch (FileNotFoundException e) {
        //    e.printStackTrace();
        //    System.out.println(e.getMessage());
        //} catch (Exception e) {
        //    e.printStackTrace();
        //}

        String[] titles = new String[]{"Id", "学号", "名字", "年龄", "性别", "成绩"};
        String[] fieldNames = new String[]{"id", "sno", "name", "age1", "sex", "score"};
        List<Student> expList = new ArrayList<Student>();

        Student student = new Student();
        student.setScore(98);
        student.setSno("1010110");
        student.setAge(18);
        student.setId(1001L);
        student.setSex(1);
        student.setName("yj");

        Student student2 = new Student();
        student2.setScore(100);
        student2.setSno("1010111");
        student2.setAge(18);
        student2.setId(1002L);
        student2.setSex(2);
        student2.setName("yjj");

        expList.add(student);
        expList.add(student2);

        try {
            export(filePath, "", expList, titles, fieldNames);

            List<Map<String, Object>> impList = imp(filePath, fieldNames);
            for (Map<String, Object> map : impList) {
                System.out.println(map.get("sno"));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
