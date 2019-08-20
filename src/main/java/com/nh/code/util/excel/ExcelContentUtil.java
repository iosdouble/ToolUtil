package com.nh.code.util.excel;

import com.nh.code.util.date.DateTimeUtil;
import org.apache.poi.ss.usermodel.CellType;

import java.util.Date;
import java.util.List;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 * @Classname ExcelContentUtil
 * @Description TODO
 * @Date 2019/8/20 10:33 AM
 * @Created by nihui
 */
public class ExcelContentUtil {
    public ExcelContentUtil() {
    }

    public static void createTitleRow(XSSFWorkbook excel, XSSFSheet sheet, String[] titleArray) {
        if (titleArray != null && titleArray.length != 0) {
            XSSFRow titleRow = sheet.createRow(0);
            XSSFCellStyle titleStyle = ExcelStyleUtil.getCenterBoldStyle(excel);

            for(int i = 0; i < titleArray.length; ++i) {
                XSSFCell titleCell = titleRow.createCell(i);
                titleCell.setCellStyle(titleStyle);
                titleCell.setCellValue(titleArray[i]);
            }

        }
    }

    public static void createContentRow(XSSFWorkbook excel, XSSFSheet sheet, int rowNum, String[] contentArray) {
        if (contentArray != null && contentArray.length != 0) {
            XSSFRow row = sheet.createRow(rowNum);
            XSSFCellStyle style = ExcelStyleUtil.getLeftStyle(excel);

            for(int i = 0; i < contentArray.length; ++i) {
                XSSFCell titleCell = row.createCell(i);
                titleCell.setCellStyle(style);
                titleCell.setCellValue(contentArray[i]);
            }

        }
    }

    public static void createContentRow(XSSFWorkbook excel, XSSFSheet sheet, int rowNum, List<String> contentList) {
        if (contentList != null && contentList.size() != 0) {
            XSSFRow row = sheet.createRow(rowNum);
            XSSFCellStyle style = ExcelStyleUtil.getLeftStyle(excel);

            for(int i = 0; i < contentList.size(); ++i) {
                XSSFCell titleCell = row.createCell(i);
                titleCell.setCellStyle(style);
                titleCell.setCellValue((String)contentList.get(i));
            }

        }
    }

    public static String readCellContentToString(XSSFCell xssfCell) {
        CellType xssfCellType = xssfCell.getCellTypeEnum();
        String result = null;
        switch(xssfCellType) {
            case STRING:
                result = xssfCell.getStringCellValue();
                break;
            case NUMERIC:
                double tempResult = xssfCell.getNumericCellValue();
                result = String.valueOf(tempResult);
        }

        return result;
    }

    public static Double readCellContentToDouble(XSSFCell xssfCell) {
        CellType xssfCellType = xssfCell.getCellTypeEnum();
        Double result = null;
        switch(xssfCellType) {
            case STRING:
                String tempResult = xssfCell.getStringCellValue();
                result = Double.valueOf(tempResult);
                break;
            case NUMERIC:
                result = xssfCell.getNumericCellValue();
        }

        return result;
    }

    public static Date readCellContentToDate(XSSFCell xssfCell) {
        CellType xssfCellType = xssfCell.getCellTypeEnum();
        Date result = null;
        switch(xssfCellType) {
            case STRING:
                String tempResult = xssfCell.getStringCellValue();
                result = DateTimeUtil.getFormatDateTime(tempResult, "yyyy/MM/dd");
                break;
            case NUMERIC:
                result = xssfCell.getDateCellValue();
        }

        return result;
    }
}
