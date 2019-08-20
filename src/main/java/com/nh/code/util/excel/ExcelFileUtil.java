package com.nh.code.util.excel;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.*;

/**
 * @Classname ExcelFileUtil
 * @Description TODO
 * @Date 2019/8/20 10:41 AM
 * @Created by nihui
 */
public class ExcelFileUtil {

    /**
     *
     * @author nihui
     * @version 1.0
     * @description 根据输入流获取XSSFWorkbook对象（excel 2007以上）
     * @param inputStream 输入流
     * @return XSSFWorkbook
     * @throws IOException
     */
    public static XSSFWorkbook readExcel(InputStream inputStream) throws IOException{
        XSSFWorkbook xssfWorkbook=new XSSFWorkbook(inputStream);
        return xssfWorkbook;
    }
    /**
     *
     * @author nihui
     * @version 1.0
     * @description 根据路径获取获取XSSFWorkbook对象（excel 2007以上），增加缓存处理
     * @param path 路径
     * @return XSSFWorkbook
     * @throws IOException
     */
    public static XSSFWorkbook readExcel(String path) throws IOException{
        File file=new File(path);
        InputStream inputStream=new FileInputStream(file);
        BufferedInputStream bufferedInputStream=new BufferedInputStream(inputStream);
        return readExcel(bufferedInputStream);
    }
}
