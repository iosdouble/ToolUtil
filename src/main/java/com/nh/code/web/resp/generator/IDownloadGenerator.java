package com.nh.code.web.resp.generator;

import org.springframework.http.ResponseEntity;

import javax.servlet.http.HttpServletResponse;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;

/**
 * @Classname IDownloadGenerator
 * @Description TODO
 * @Date 2019/8/20 12:20 PM
 * @Created by nihui
 */
public interface IDownloadGenerator {
    ResponseEntity<?> downloadFile(File var1, String var2) throws IOException;

    ResponseEntity<?> downloadFile(ByteArrayOutputStream var1, String var2, String var3) throws IOException;

    ResponseEntity<?> downloadFile(ByteArrayOutputStream var1, String var2) throws IOException;

    void downloadStream(InputStream var1, HttpServletResponse var2) throws IOException;
}
