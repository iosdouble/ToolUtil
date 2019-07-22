package com.nh.json;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.module.SimpleModule;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import com.google.common.collect.Maps;
import com.nh.json.exception.JsonUtilErrorException;
import org.apache.commons.lang3.StringUtils;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 * @Classname JSONUtil
 * @Description TODO JSON数据转换
 * @Date 2019/7/22 4:42 PM
 * @Created by nihui
 */
public class JSONUtil {

    public static <T> String toJson(T t) {
        if (t == null) {
            return null;
        } else {
            ObjectMapper mapper = new ObjectMapper();
            String json = null;

            try {
                json = mapper.writeValueAsString(t);
                return json;
            } catch (JsonProcessingException var4) {
                var4.printStackTrace();
                throw new JsonUtilErrorException("toJson转换错误", var4);
            }
        }
    }

    public static <T> String toJsonAndLongToString(T t) {
        if (t == null) {
            return null;
        } else {
            ObjectMapper mapper = new ObjectMapper();
            SimpleModule simpleModule = new SimpleModule();
            simpleModule.addSerializer(Long.class, ToStringSerializer.instance);
            simpleModule.addSerializer(Long.TYPE, ToStringSerializer.instance);
            mapper.registerModule(simpleModule);
            String json = null;

            try {
                json = mapper.writeValueAsString(t);
                return json;
            } catch (JsonProcessingException var5) {
                var5.printStackTrace();
                throw new JsonUtilErrorException("toJsonAndLongToString转换错误", var5);
            }
        }
    }

    public static <T> T toObject(String json, String path, Class<T> clazz) {
        if (StringUtils.isBlank(json)) {
            return null;
        } else {
            ObjectMapper mapper = new ObjectMapper();
            T t = null;
            if (StringUtils.isBlank(path)) {
                try {
                    t = mapper.readValue(json, clazz);
                    return t;
                } catch (IOException var7) {
                    var7.printStackTrace();
                    throw new JsonUtilErrorException("toObject转换错误", var7);
                }
            } else {
                try {
                    JsonNode jsonRoot = mapper.readTree(json);
                    JsonNode jsonNode = jsonRoot.at(path);
                    if (jsonNode.isMissingNode()) {
                        return t;
                    } else {
                        t = mapper.readValue(jsonNode.toString(), clazz);
                        return t;
                    }
                } catch (IOException var8) {
                    var8.printStackTrace();
                    throw new JsonUtilErrorException("toObject转换错误", var8);
                }
            }
        }
    }

    public static <T> T toObject(String json, Class<T> clazz) {
        return StringUtils.isBlank(json) ? null : toObject(json, (String)null, clazz);
    }

    public static <T> List<T> toObjectList(String json, Class<T> clazz) {
        if (StringUtils.isBlank(json)) {
            return null;
        } else {
            ObjectMapper mapper = new ObjectMapper();
            JavaType javaType = mapper.getTypeFactory().constructParametricType(ArrayList.class, new Class[]{clazz});

            try {
                List<T> tList = (List)mapper.readValue(json, javaType);
                return tList;
            } catch (IOException var5) {
                var5.printStackTrace();
                throw new JsonUtilErrorException("toObjectList转换错误", var5);
            }
        }
    }

    public static <T> List<T> toObjectList(String json, String path, Class<T> clazz) {
        if (StringUtils.isBlank(json)) {
            return null;
        } else {
            ObjectMapper mapper = new ObjectMapper();
            mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
            if (StringUtils.isBlank(path)) {
                JavaType javaType = mapper.getTypeFactory().constructParametricType(ArrayList.class, new Class[]{clazz});

                try {
                    List<T> tList = (List)mapper.readValue(json, javaType);
                    return tList;
                } catch (IOException var8) {
                    var8.printStackTrace();
                    throw new JsonUtilErrorException("toObjectList转换错误", var8);
                }
            } else {
                try {
                    JsonNode jsonRoot = mapper.readTree(json);
                    JsonNode jsonNode = jsonRoot.at(path);
                    if (jsonNode.isMissingNode()) {
                        return null;
                    } else {
                        JavaType javaType = mapper.getTypeFactory().constructParametricType(ArrayList.class, new Class[]{clazz});
                        List<T> tList = (List)mapper.readValue(jsonNode.toString(), javaType);
                        return tList;
                    }
                } catch (IOException var9) {
                    var9.printStackTrace();
                    throw new JsonUtilErrorException("toObjectList转换错误", var9);
                }
            }
        }
    }

    public static <T, V> Map<T, V> toObjectMap(String json, Class<T> keyClazz, Class<V> valueClazz) {
        if (StringUtils.isBlank(json)) {
            return null;
        } else {
            ObjectMapper mapper = new ObjectMapper();
            JavaType javaType = mapper.getTypeFactory().constructParametricType(Map.class, new Class[]{keyClazz, valueClazz});

            try {
                Map<T, V> map = (Map)mapper.readValue(json, javaType);
                return map;
            } catch (IOException var6) {
                var6.printStackTrace();
                throw new JsonUtilErrorException("toObjectMap转换错误----->" + json, var6);
            }
        }
    }

    public static <T, V> TreeMap<T, V> toObjectTreeMap(String json, Class<T> keyClazz, Class<V> valueClazz) {
        if (StringUtils.isBlank(json)) {
            return null;
        } else {
            ObjectMapper mapper = new ObjectMapper();
            JavaType javaType = mapper.getTypeFactory().constructParametricType(TreeMap.class, new Class[]{keyClazz, valueClazz});

            try {
                TreeMap<T, V> map = (TreeMap)mapper.readValue(json, javaType);
                return map;
            } catch (IOException var6) {
                var6.printStackTrace();
                throw new JsonUtilErrorException("toObjectTreeMap转换错误", var6);
            }
        }
    }

    public static <T> T toObjectT(String json, Class<T> keyClazz, Class... valueClazz) {
        if (StringUtils.isBlank(json)) {
            return null;
        } else {
            ObjectMapper mapper = new ObjectMapper();
            JavaType javaType = mapper.getTypeFactory().constructParametricType(keyClazz, valueClazz);

            try {
                T t = mapper.readValue(json, javaType);
                return t;
            } catch (IOException var6) {
                var6.printStackTrace();
                throw new JsonUtilErrorException("toObjectT转换错误", var6);
            }
        }
    }

    public static String addJsonStrNode(String json, Map<String, Object> nodes) {
        ObjectMapper mapper = new ObjectMapper();
        Map<String, Object> jsonMap = null;
        String jsonResult = null;

        try {
            jsonMap = toObjectMap(json, String.class, Object.class);
            jsonMap.putAll(nodes);
            jsonResult = mapper.writeValueAsString(jsonMap);
            return jsonResult;
        } catch (IOException var6) {
            var6.printStackTrace();
            throw new JsonUtilErrorException("addJsonStrNode转换错误", var6);
        }
    }

    public static String mergeToStr(String... jsons) {
        if (jsons == null) {
            return null;
        } else {
            Map<String, Object> jsonMapResult = Maps.newHashMap();

            for(int i = 0; i < jsons.length; ++i) {
                if (StringUtils.isNoneBlank(new CharSequence[]{jsons[i]})) {
                    Map<String, Object> jsonMap = toObjectMap(jsons[i], String.class, Object.class);
                    if (jsonMap != null) {
                        jsonMapResult.putAll(jsonMap);
                    }
                }
            }

            String result = toJson(jsonMapResult);
            return result;
        }
    }
}
