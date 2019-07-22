package com.nh.file;

import org.apache.commons.lang3.StringUtils;

import java.io.*;
import java.nio.charset.Charset;

/**
 * @Classname IOUtil
 * @Description TODO
 * @Date 2019/7/22 5:04 PM
 * @Created by nihui
 */
public class IOUtil {
    public IOUtil() {
    }

    public static boolean inputStreamToFile(InputStream inputStream, File file, Boolean isClosedIs) throws IOException {
        if (isClosedIs == null) {
            isClosedIs = true;
        }

        if (file != null && !file.isDirectory()) {
            BufferedInputStream bis = new BufferedInputStream(inputStream);
            OutputStream os = new FileOutputStream(file);
            BufferedOutputStream bos = new BufferedOutputStream(os);
            byte[] buffer = new byte[1024];
            boolean var7 = false;

            int i;
            while((i = bis.read(buffer)) != -1) {
                bos.write(buffer, 0, i);
            }

            bos.flush();
            bos.close();
            os.close();
            bis.close();
            if (isClosedIs) {
                inputStream.close();
            }

            return true;
        } else {
            return false;
        }
    }

    public static boolean inputStreamToFile(InputStream inputStream, String fileFullName, boolean isCreate, boolean overWrite, boolean isClosedIs) throws IOException {
        File file = FileUtil.getFileHisOrCreate(fileFullName, isCreate, overWrite);
        return inputStreamToFile(inputStream, file, isClosedIs);
    }

    public static boolean fileToOutputStream(File file, OutputStream outputStream) throws IOException {
        if (file != null && !file.isDirectory()) {
            InputStream is = new FileInputStream(file);
            BufferedInputStream bis = new BufferedInputStream(is);
            BufferedOutputStream bos = new BufferedOutputStream(outputStream);
            byte[] buffer = new byte[1024];
            boolean var6 = false;

            int i;
            while((i = bis.read(buffer)) != -1) {
                bos.write(buffer, 0, i);
            }

            is.close();
            bis.close();
            bos.flush();
            outputStream.flush();
            bos.close();
            bis.close();
            return true;
        } else {
            return false;
        }
    }

    public static boolean fileToOutputStream(String fileFullName, OutputStream outputStream) throws IOException {
        File file = new File(fileFullName);
        return fileToOutputStream(file, outputStream);
    }

    public static String getStr4File(File file, String charset) throws IOException {
        if (StringUtils.isBlank(charset)) {
            charset = "UTF-8";
        }

        if (file != null && !file.isDirectory()) {
            FileInputStream fis = new FileInputStream(file);
            BufferedInputStream bis = new BufferedInputStream(fis);
            InputStreamReader isr = new InputStreamReader(bis, Charset.forName(charset));
            BufferedReader br = new BufferedReader(isr);
            StringBuffer sb = new StringBuffer();

            while(br.ready()) {
                sb.append(br.readLine());
            }

            br.close();
            isr.close();
            bis.close();
            fis.close();
            return sb.toString();
        } else {
            return null;
        }
    }

    public static String getStr4File(String fileFullPath, String charset) throws IOException {
        return getStr4File(new File(fileFullPath), charset);
    }

    public static String getStr4File(String filePath, String fileName, String charset) throws IOException {
        return getStr4File(new File(filePath + "/" + fileName), charset);
    }

    public static File setStr2File(String str, File file, String charset, boolean isAppend) throws IOException {
        if (file == null) {
            return null;
        } else {
            if (StringUtils.isBlank(charset)) {
                charset = "UTF-8";
            }

            if (!file.exists() && !file.isFile()) {
                return null;
            } else {
                OutputStream os = new FileOutputStream(file, isAppend);
                BufferedOutputStream bos = new BufferedOutputStream(os);
                OutputStreamWriter osw = new OutputStreamWriter(bos, Charset.forName(charset));
                BufferedWriter bw = new BufferedWriter(osw);
                bw.write(str);
                bw.flush();
                osw.flush();
                bos.flush();
                os.flush();
                bw.close();
                osw.close();
                bos.close();
                os.close();
                return file;
            }
        }
    }

    public static File setStr2File(String str, String fileFullName, String charset, boolean isCreate, boolean overWrite, boolean isAppend) throws IOException {
        File file = FileUtil.getFileHisOrCreate(fileFullName, isCreate, overWrite);
        return setStr2File(str, file, charset, isAppend);
    }

    public static boolean setByteArr2File(byte[] bytes, File file) {
        if (file == null) {
            return false;
        } else if (!file.exists() && !file.isFile()) {
            return false;
        } else {
            OutputStream os = null;
            BufferedOutputStream bos = null;

            boolean var5;
            try {
                os = new FileOutputStream(file);
                bos = new BufferedOutputStream(os);
                bos.write(bytes);
                return true;
            } catch (FileNotFoundException var17) {
                var17.printStackTrace();
                var5 = false;
                return var5;
            } catch (IOException var18) {
                var18.printStackTrace();
                var5 = false;
            } finally {
                try {
                    bos.flush();
                    os.flush();
                    bos.close();
                    os.close();
                } catch (IOException var16) {
                    var16.printStackTrace();
                    return false;
                }
            }

            return var5;
        }
    }

    public static boolean file2File(String sourceFileFullName, String descFileFullName, boolean isCreate, boolean overWrite) throws IOException {
        InputStream inputStream = new FileInputStream(sourceFileFullName);
        boolean result = inputStreamToFile(inputStream, descFileFullName, isCreate, overWrite, true);
        return result;
    }

    public static File file2TempFile(String sourceFileFullName, String tempFilePrefix, String tempFileSuffix, File tmpDir) throws IOException {
        File tempFile = File.createTempFile(tempFilePrefix, tempFileSuffix, tmpDir);
        boolean result = file2File(sourceFileFullName, tempFile.getPath(), false, false);
        if (result) {
            return tempFile;
        } else {
            tempFile.delete();
            return null;
        }
    }

    public static OutputStreamWriter getOutputStreamWriter(OutputStream outputStream, String charset) throws FileNotFoundException, UnsupportedEncodingException {
        if (StringUtils.isBlank(charset)) {
            charset = "UTF-8";
        }

        OutputStreamWriter outputStreamWriter = new OutputStreamWriter(outputStream, charset);
        return outputStreamWriter;
    }

    public static OutputStreamWriter getOutputStreamWriter(File file, String charset) throws FileNotFoundException, UnsupportedEncodingException {
        FileOutputStream fileOutputStream = new FileOutputStream(file);
        OutputStreamWriter outputStreamWriter = getOutputStreamWriter((OutputStream)fileOutputStream, charset);
        return outputStreamWriter;
    }

    public static BufferedWriter getBufferedWriter(File file, String charset) throws FileNotFoundException, UnsupportedEncodingException {
        OutputStreamWriter outputStreamWriter = getOutputStreamWriter(file, charset);
        BufferedWriter bufferedWriter = new BufferedWriter(outputStreamWriter);
        return bufferedWriter;
    }
}
