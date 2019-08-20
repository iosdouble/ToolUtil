package com.nh.code.web.resp.generator.impl;

import com.nh.code.web.resp.generator.IDownloadGenerator;
import org.apache.commons.compress.utils.IOUtils;
import org.apache.commons.io.FileUtils;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

import javax.servlet.http.HttpServletResponse;
import java.io.*;

/**
 * @Classname DownloadGeneratorImpl
 * @Description TODO
 * @Date 2019/8/20 12:22 PM
 * @Created by nihui
 */
public class DownloadGeneratorImpl implements IDownloadGenerator {
    public DownloadGeneratorImpl() {
    }

    public ResponseEntity<?> downloadFile(File file, String fileName) throws IOException {
        String downloadFileName = new String(fileName.getBytes("UTF-8"), "ISO-8859-1");
        HttpHeaders headers = new HttpHeaders();
        headers.setContentDispositionFormData("attachment", downloadFileName);
        headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
        return new ResponseEntity(FileUtils.readFileToByteArray(file), headers, HttpStatus.OK);
    }

    public ResponseEntity<?> downloadFile(ByteArrayOutputStream byteArrayOutputStream, String fileName, String charset) throws IOException {
        String downloadFileName = new String(fileName.getBytes("UTF-8"), "ISO-8859-1");
        HttpHeaders headers = new HttpHeaders();
        headers.setContentDispositionFormData("attachment", downloadFileName);
        headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
        String baosStr = byteArrayOutputStream.toString(charset);
        byte[] baosStrByte = baosStr.getBytes(charset);
        return new ResponseEntity(baosStrByte, headers, HttpStatus.CREATED);
    }

    public ResponseEntity<?> downloadFile(ByteArrayOutputStream byteArrayOutputStream, String fileName) throws IOException {
        return this.downloadFile(byteArrayOutputStream, fileName, "GB2312");
    }

    public void downloadStream(InputStream inputStream, HttpServletResponse httpServletResponse) {
        try {
            OutputStream outputStream = httpServletResponse.getOutputStream();
            Throwable var4 = null;

            try {
                InputStream inputStreamCopy = inputStream;
                Throwable var6 = null;

                try {
                    IOUtils.copy(inputStream, outputStream);
                    outputStream.flush();
                } catch (Throwable var31) {
                    var6 = var31;
                    throw var31;
                } finally {
                    if (inputStream != null) {
                        if (var6 != null) {
                            try {
                                inputStreamCopy.close();
                            } catch (Throwable var30) {
                                var6.addSuppressed(var30);
                            }
                        } else {
                            inputStream.close();
                        }
                    }

                }
            } catch (Throwable var33) {
                var4 = var33;
                throw var33;
            } finally {
                if (outputStream != null) {
                    if (var4 != null) {
                        try {
                            outputStream.close();
                        } catch (Throwable var29) {
                            var4.addSuppressed(var29);
                        }
                    } else {
                        outputStream.close();
                    }
                }

            }
        } catch (IOException var35) {
            var35.printStackTrace();
        }

    }
}
