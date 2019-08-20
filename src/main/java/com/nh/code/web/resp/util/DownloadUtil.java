package com.nh.code.web.resp.util;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;

/**
 * @Classname DownloadUtil
 * @Description TODO
 * @Date 2019/8/20 2:19 PM
 * @Created by nihui
 */
public class DownloadUtil {
    public DownloadUtil() {
    }

    public static ResponseEntity<?> downloadFile(File file, String fileName) throws IOException {
        String downloadFileName = new String(fileName.getBytes("UTF-8"), "ISO-8859-1");
        HttpHeaders headers = new HttpHeaders();
        headers.setContentDispositionFormData("attachment", downloadFileName);
        headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
        return new ResponseEntity(FileUtils.readFileToByteArray(file), headers, HttpStatus.OK);
    }

    public static ResponseEntity<?> downloadFile(ByteArrayOutputStream byteArrayOutputStream, String fileName, String charset) throws IOException {
        String downloadFileName = new String(fileName.getBytes("UTF-8"), "ISO-8859-1");
        HttpHeaders headers = new HttpHeaders();
        headers.setContentDispositionFormData("attachment", downloadFileName);
        headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
        String baosStr = byteArrayOutputStream.toString(charset);
        byte[] baosStrByte = baosStr.getBytes(charset);
        return new ResponseEntity(baosStrByte, headers, HttpStatus.CREATED);
    }

    public static ResponseEntity<?> downloadFile(ByteArrayOutputStream byteArrayOutputStream, String fileName) throws IOException {
        return downloadFile(byteArrayOutputStream, fileName, "GB2312");
    }

    public static void downloadStream(InputStream inputStream, HttpServletResponse httpServletResponse) throws IOException {
        ServletOutputStream servletOutputStream = httpServletResponse.getOutputStream();
        IOUtils.copy(inputStream, servletOutputStream);
        inputStream.close();
        servletOutputStream.flush();
        servletOutputStream.close();
    }
}
