package com.nh.code.util.excel;

import com.nh.code.util.string.FontContants;
import org.apache.poi.ss.usermodel.HorizontalAlignment;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFFont;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 * @Classname ExcelStyleUtil
 * @Description TODO
 * @Date 2019/8/20 10:42 AM
 * @Created by nihui
 */
public class ExcelStyleUtil {
    /**
     *
     * @author nihui
     * @version 1.0
     * @description 获取单元格样式（居中、粗体、微软雅黑、18号字）
     * @param excel
     * @return
     */
    public static XSSFCellStyle getCenterBoldStyle(XSSFWorkbook excel) {
        XSSFCellStyle style = excel.createCellStyle();
        style.setAlignment(HorizontalAlignment.CENTER);

        XSSFFont font = excel.createFont();
        font.setFontName(FontContants.WEI_RUAN_YAN_HEI);
        font.setFontHeightInPoints((short) 18);
        font.setBold(true);

        style.setFont(font);

        return style;
    }

    /**
     *
     * @author nihui
     * @version 1.0
     * @description 获取单元格样式（居左、微软雅黑、18号字）
     * @param excel
     * @return
     */
    public static XSSFCellStyle getLeftStyle(XSSFWorkbook excel) {
        XSSFCellStyle style = excel.createCellStyle();
        style.setAlignment(HorizontalAlignment.LEFT);

        XSSFFont font = excel.createFont();
        font.setFontName(FontContants.WEI_RUAN_YAN_HEI);
        font.setFontHeightInPoints((short) 18);
        font.setBold(false);

        style.setFont(font);

        return style;
    }
}
