package com.yang.service;

import com.yang.model.TableCell;
import com.yang.util.CellStyleUtil;
import com.yang.util.DateUtil;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

import static java.lang.Integer.parseInt;

@Service
public class ExcelTemplateService {

    public Workbook createWb(String filePath, String unitName, String yearMonth) {
        Workbook wb = null;

        if (filePath.endsWith("xls")) {//2003格式
            wb = new HSSFWorkbook();
        } else if (filePath.endsWith("xlsx")) {//2007格式
            wb = new XSSFWorkbook();
        } else {
            wb = new XSSFWorkbook();
        }

        Sheet sheet1 = wb.createSheet("班表");
        sheet1.setColumnWidth(0, 20 * 256);
        Sheet sheet2 = wb.createSheet("考勤汇总表");

        // 设置内容样式
        CellStyle commonStyle = CellStyleUtil.createStyle(wb);
        commonStyle.setAlignment(HorizontalAlignment.CENTER);
        commonStyle.setVerticalAlignment(VerticalAlignment.CENTER);

        CellStyle leftStyle = CellStyleUtil.createStyle(wb);
        leftStyle.setAlignment(HorizontalAlignment.LEFT);
        leftStyle.setVerticalAlignment(VerticalAlignment.CENTER);

        CellStyle redStyle = CellStyleUtil.createStyle(wb);
        redStyle.setAlignment(HorizontalAlignment.CENTER);
        redStyle.setVerticalAlignment(VerticalAlignment.CENTER);
        redStyle.setFillForegroundColor(IndexedColors.RED.index);
        redStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);

        CellStyle grayStyle = CellStyleUtil.createStyle(wb);
        grayStyle.setAlignment(HorizontalAlignment.CENTER);
        grayStyle.setVerticalAlignment(VerticalAlignment.CENTER);
        grayStyle.setFillForegroundColor(IndexedColors.GREY_50_PERCENT.index);
        grayStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);

        String yyyy = yearMonth.split("-")[0];
        String mm = yearMonth.split("-")[1];

        int month = parseInt(mm);
        Calendar aCalendar = Calendar.getInstance(Locale.CHINA);
        aCalendar.set(parseInt(yyyy), month - 1, 0);
        int day = aCalendar.get(Calendar.DAY_OF_MONTH);//上个月有多少天

        //月周期为上月的26号开始，到这个月的25号结束
        int date_col_total = day - 26 + 1 + 25;
        //总共多少列
        int colNum = date_col_total + 6;

        List<TableCell> list = new ArrayList<TableCell>();

        TableCell branchCell = new TableCell(0, 0, 1, 3, "门店", true, null);
        TableCell titleCell = new TableCell(0, 0, 4, date_col_total + 5, yearMonth + "月（专职/兼职考勤表）", true, null);
        TableCell branchNameCell = new TableCell(1, 1, 1, 3, unitName, true, null);
        TableCell currentMonthDayCountCell = new TableCell(1, 1, 4, date_col_total + 5, "当月天数：" + String.valueOf(day), true, null);
        TableCell roleCell = new TableCell(2, 3, 1, 1, "职位", true, null);
        TableCell nameCell = new TableCell(2, 3, 2, 2, "姓名", true, null);
        TableCell emailCell = new TableCell(2, 3, 3, 3, "邮箱", true, null);
        TableCell errorCell = new TableCell(3, 3, 0, 0, "错误提示列勿删", false, redStyle);

        list.add(branchCell);
        list.add(titleCell);
        list.add(branchNameCell);
        list.add(currentMonthDayCountCell);
        list.add(roleCell);
        list.add(nameCell);
        list.add(emailCell);
        list.add(errorCell);

        List<Date> dateList = new ArrayList<Date>();
        addDayList(parseInt(yyyy), month - 1, 26, day, dateList);
        addDayList(parseInt(yyyy), month, 1, 25, dateList);

        for (int i = 0; i < dateList.size(); i++) {
            Date date = dateList.get(i);
            aCalendar.setTime(date);
            String weekday = DateUtil.getWeekOfDate(date);
            TableCell tableCell = new TableCell(2, 2, 4 + i, 4 + i, String.valueOf(aCalendar.get(Calendar.DATE)), false, null);
            TableCell tableCell2 = new TableCell(3, 3, 4 + i, 4 + i, weekday, false, null);
            list.add(tableCell);
            list.add(tableCell2);
        }

        TableCell extraWorkTimeCell = new TableCell(2, 2, date_col_total + 4, date_col_total + 5, "加班（小时数）", true, null);
        list.add(extraWorkTimeCell);

        TableCell avgExtraWorkTimeCell = new TableCell(3, 3, date_col_total + 4, date_col_total + 4, "平均加班", false, null);
        TableCell holidayWorkTimeCell = new TableCell(3, 3, date_col_total + 5, date_col_total + 5, "国假日加班", false, null);
        list.add(avgExtraWorkTimeCell);
        list.add(holidayWorkTimeCell);

        TableCell dianzhangCell = new TableCell(4, 4, 1, 1, "店长", false, null);
        TableCell operatorCell = new TableCell(5, 5, 1, 1, "管家", false, null);
        list.add(dianzhangCell);
        list.add(operatorCell);

        //分割线
        TableCell lineCell = new TableCell(8, 8, 1, colNum - 1, "分割线", true, grayStyle);
        list.add(lineCell);

        TableCell cleanerCell = new TableCell(9, 9, 1, 1, "保洁", false, null);
        TableCell securityCell = new TableCell(10, 10, 1, 1, "保安", false, null);
        list.add(cleanerCell);
        list.add(securityCell);

        TableCell noteCell = new TableCell(11, 11, 1, colNum - 1,
                "说明：范例中满勤日为22天，实际出勤以当月出勤日期为准（以上考勤均由店长核实、确认！）", true, null);
        TableCell noteCell2 = new TableCell(12, 13, 1, colNum - 1,
                "符号及代表：出差:差   年休:年   休息日:休   加班补调休:调   病假:病   事假:事   迟到:迟   早退:退   旷工:旷   婚假:婚   产假:产   工伤假:伤   其它:请注明", true, null);
        list.add(noteCell);
        list.add(noteCell2);

        TableCell markCell = new TableCell(14, 14, 1, colNum - 1, "备注：", true, leftStyle);
        list.add(markCell);

        //分割线
        TableCell lineCell2 = new TableCell(15, 15, 1, colNum - 1, "分割线", true, grayStyle);
        list.add(lineCell2);

        TableCell markCell2 = new TableCell(16, 16, 1, colNum - 1, "注明：班表时间段", true, null);
        list.add(markCell2);

        //a班
        TableCell aCell = new TableCell(17, 17, 1, 1, "A班：", false, null);
        list.add(aCell);
        TableCell aTimeCell = new TableCell(17, 17, 2, 2, "9:00-17:30", false, null);
        list.add(aTimeCell);
        TableCell anoteCell = new TableCell(17, 17, 3, 8, "（其中0.5小时为就餐休息时间，工作时间为8小时）", true, leftStyle);
        list.add(anoteCell);
        //b班
        TableCell bCell = new TableCell(18, 18, 1, 1, "B班：", false, null);
        list.add(bCell);
        TableCell btimeCell = new TableCell(18, 18, 2, 2, "13:00-21:30", false, null);
        list.add(btimeCell);
        TableCell bnoteCell = new TableCell(18, 18, 3, 8, "（其中0.5小时为就餐休息时间，工作时间为8小时）", true, leftStyle);
        list.add(bnoteCell);
        //c班
        TableCell cCell = new TableCell(19, 19, 1, 1, "C班：", false, null);
        list.add(cCell);
        TableCell ctimeCell = new TableCell(19, 19, 2, 2, "8:00-20:00", false, null);
        list.add(ctimeCell);
        TableCell cnoteCell = new TableCell(19, 19, 3, 8, "（其中1小时为就餐休息时间，工作时间为11小时）", true, leftStyle);
        list.add(cnoteCell);
        //d班
        TableCell dCell = new TableCell(20, 20, 1, 1, "D班：", false, null);
        list.add(dCell);
        TableCell dtimeCell = new TableCell(20, 20, 2, 2, "20:00-8:00", false, null);
        list.add(dtimeCell);
        TableCell dnoteCell = new TableCell(20, 20, 3, 8, "（其中0.5小时为就餐休息时间，工作时间为11.5小时）", true, leftStyle);
        list.add(dnoteCell);

        for (int i = 0; i <= 20; i++) {
            Row row = sheet1.createRow(i);
            for (int j = 0; j < colNum; j++) {
                Cell cell = row.createCell(j);
                cell.setCellStyle(commonStyle);
            }
        }

        addMergedRegion(list, sheet1, commonStyle);

        //创建sheet2
        List<TableCell> list2 = new ArrayList<TableCell>();
        TableCell tableCell1 = new TableCell(0, 0, 0, 23, "XX店201X年X月份专职考勤汇总表", true, null);
        list2.add(tableCell1);

        TableCell tableCell2 = new TableCell(1, 1, 3, 8, "出勤情况 （单位：天）", true, null);
        list2.add(tableCell2);

        TableCell tableCell3 = new TableCell(1, 1, 9, 16, " 缺勤情况   （单位：天）", true, null);
        list2.add(tableCell3);

        TableCell tableCell4 = new TableCell(1, 1, 17, 21, " 奖金", true, null);
        list2.add(tableCell4);

        String[] t1 = new String[]{"序号", "部门", "姓名", "应出勤天", "实际出勤天", "平时加班", "周末加班", "法定加班", "夜班天数", "迟到", "早退",
                "病假", "事假", "旷工", "工伤", "婚/丧产", "本月已休年假", "夜班津贴", "客房计件", "销售奖金", "奖金", "其他", "是否外包", "备注"};
        for (int i = 0; i < t1.length; i++) {
            TableCell tableCell = new TableCell(2, 2, i, i, t1[i], false, null);
            list2.add(tableCell);
        }

        TableCell tableCell5 = new TableCell(3, 3, 0, 0, " 1", false, null);
        list2.add(tableCell5);

        TableCell tableCell6 = new TableCell(4, 4, 0, 0, " 2", false, null);
        list2.add(tableCell6);

        for (int i = 0; i < 6; i++) {
            Row row = sheet2.createRow(i);
            for (int j = 0; j < 24; j++) {
                Cell cell = row.createCell(j);
                cell.setCellStyle(commonStyle);
            }
        }

        addMergedRegion(list2, sheet2, commonStyle);

        return wb;
    }

    private void addMergedRegion(List<TableCell> list, Sheet sheet, CellStyle cellStyle) {
        for (TableCell tableCell : list) {
            Row row = sheet.getRow(tableCell.getFirstRow());
            Cell cell = row.getCell(tableCell.getFirstCol());
            cell.setCellValue(tableCell.getValue());
            if (tableCell.isNeedMerge()) {
                sheet.addMergedRegion(new CellRangeAddress(tableCell.getFirstRow(), tableCell.getLastRow(), tableCell.getFirstCol(), tableCell.getLastCol()));
            }

            if (null != tableCell.getStyle()) {
                cell.setCellStyle(tableCell.getStyle());
            } else {
                cell.setCellStyle(cellStyle);
            }
        }
    }

    private void addDayList(int year, int month, int beginDay, int endDay, List<Date> list) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        for (int i = beginDay; i <= endDay; i++) {
            String aDate = String.valueOf(year) + "-" + month + "-" + i;
            Date date = null;
            try {
                date = simpleDateFormat.parse(aDate);
                list.add(date);
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }
    }
}
