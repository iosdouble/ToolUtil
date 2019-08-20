package com.nh.code.util.cache.redis;

import org.springframework.data.redis.core.RedisTemplate;

import java.util.concurrent.TimeUnit;

/**
 * @Classname RedisUtil
 * @Description TODO
 * @Date 2019/8/20 10:47 AM
 * @Created by nihui
 */
public class RedisUtil {
    /**
     *
     * @author nihui
     * @version 1.0
     * @description 如果bean不为null，会自动转成用户想要的bean，但是如果类型无法转换，会报出运行时异常
     * @param reidsTemplate
     * @param key
     * @return 通过reidsTemplate获取key对应的bean
     */
    @SuppressWarnings("unchecked")
    public static<T> T getBean(RedisTemplate<String, Object> reidsTemplate, Object key){
        Object obj=reidsTemplate.opsForValue().get(key);
        T t=null;
        if(obj!=null){
            t=(T) obj;
        }
        return t;
    }

    /**
     *
     * @author nihui
     * @version 1.0
     * @description 向Redis中存入一个对象，并且没有时间限制
     * @param reidsTemplate
     * @param key
     * @param value
     */
    public static<T> void setBean(RedisTemplate<String, Object> reidsTemplate,String key,T value){
        reidsTemplate.opsForValue().set(key,value);
    }

    /**
     *
     * @author nihui
     * @version 1.0
     * @description 向Redis中存入一个对象，并且可以设置时间限制，如果time为小于等于0的值，则默认为不限时间，单位为秒
     * @param reidsTemplate
     * @param key
     * @param value
     * @param time
     */
    public static<T> void setBean(RedisTemplate<String, Object> reidsTemplate,String key,T value,long time){
        if(time <= 0){
            setBean(reidsTemplate, key, value);
            return;
        }
        reidsTemplate.opsForValue().set(key, value, time, TimeUnit.SECONDS);
    }
}
