package com.yang.test;

import com.yang.service.ExcelTemplateService;
import org.apache.poi.ss.usermodel.Workbook;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.FileOutputStream;
import java.io.IOException;

public class ExcelTemplateTest extends BaseTest {

    @Autowired
    ExcelTemplateService excelTemplateService;

    @Test
    public void test() {
        String filePath = "/Users/yangjun/Desktop/chengjia/test.xlsx";
        Workbook wb = excelTemplateService.createWb(filePath, "小米科技", "2018-07");
        FileOutputStream outputStream = null;

        try {
            outputStream = new FileOutputStream(filePath);
            wb.write(outputStream);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (null != outputStream) {
                try {
                    outputStream.flush();
                    outputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
