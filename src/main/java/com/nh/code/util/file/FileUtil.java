package com.nh.code.util.file;

import org.apache.commons.lang3.StringUtils;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * @Classname FileUtil
 * @Description TODO
 * @Date 2019/7/22 5:03 PM
 * @Created by nihui
 */
public class FileUtil {
    public FileUtil() {
    }

    public static List<File> getFileList(String dirPath, String regex) {
        List<File> fileList = new ArrayList();
        File fileDir = new File(dirPath);
        if (fileDir != null && fileDir.exists() && !fileDir.isFile()) {
            File[] fileArray = fileDir.listFiles();
            if (fileArray != null && fileArray.length != 0) {
                File[] var5 = fileArray;
                int var6 = fileArray.length;

                for(int var7 = 0; var7 < var6; ++var7) {
                    File file = var5[var7];
                    if (file.isFile()) {
                        String fileName = file.getName();
                        if (StringUtils.isNotBlank(regex)) {
                            if (fileName.matches(regex)) {
                                fileList.add(file);
                            }
                        } else {
                            fileList.add(file);
                        }
                    }
                }

                return fileList;
            } else {
                return fileList;
            }
        } else {
            return fileList;
        }
    }

    public static List<File> getFileList(String dirPath) {
        return getFileList(dirPath, (String)null);
    }

    public static List<File> getSortFileList(String dirPath, String regex) {
        List<File> fileList = getFileList(dirPath, regex);
        fileList.sort(new Comparator<File>() {
            public int compare(File o1, File o2) {
                if (o1.isDirectory() && o2.isFile()) {
                    return -1;
                } else {
                    return o1.isFile() && o2.isDirectory() ? 1 : o1.getName().compareTo(o2.getName());
                }
            }
        });
        return fileList;
    }

    public static List<File> getSortFileList(String dirPath) {
        return getSortFileList(dirPath, (String)null);
    }

    public static boolean mkDir(String path) {
        File file = new File(path);
        if (file.exists()) {
            return !file.isFile();
        } else {
            boolean result = file.mkdirs();
            return result;
        }
    }

    public static boolean mkFile(File file, boolean overWrite) {
        if (!overWrite) {
            if (file.exists()) {
                if (file.isDirectory()) {
                    return false;
                }

                return false;
            }
        } else if (file.exists()) {
            if (file.isDirectory()) {
                return false;
            }

            file.delete();
        }

        if (file.getParentFile().exists() && file.getParentFile().isDirectory()) {
            try {
                file.createNewFile();
                return true;
            } catch (IOException var4) {
                var4.printStackTrace();
                return false;
            }
        } else {
            String path = file.getParent();
            if (mkDir(path)) {
                try {
                    file.createNewFile();
                    return true;
                } catch (IOException var5) {
                    var5.printStackTrace();
                    return false;
                }
            } else {
                return false;
            }
        }
    }

    public static boolean mkFile(String fileFullName, boolean overWrite) {
        File file = new File(fileFullName);
        return mkFile(file, overWrite);
    }

    public static File getFileHisOrCreate(String fileFullName, boolean isCreate, boolean overWrite) {
        File file = new File(fileFullName);
        boolean result;
        if (file.exists()) {
            if (file.isDirectory()) {
                return null;
            } else if (overWrite) {
                result = mkFile(file, overWrite);
                return result ? file : null;
            } else {
                return file;
            }
        } else if (isCreate) {
            result = mkFile(file, overWrite);
            return result ? file : null;
        } else {
            return null;
        }
    }

    public static String getFileNameSuffix(String fileName, boolean hasPoint) {
        int index = fileName.lastIndexOf(".");
        if (!hasPoint) {
            ++index;
        }

        String suffix = fileName.substring(index);
        return suffix;
    }
}
