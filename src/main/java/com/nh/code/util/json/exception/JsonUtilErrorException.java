package com.nh.code.util.json.exception;

/**
 * @Classname JsonUtilErrorException
 * @Description TODO
 * @Date 2019/7/22 4:46 PM
 * @Created by nihui
 */
public class JsonUtilErrorException extends RuntimeException {
    private static final long serialVersionUID = 2245838135582780142L;

    public JsonUtilErrorException(String message, Throwable cause) {
        super(message, cause);
    }
}
