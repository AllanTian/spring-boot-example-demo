package com.example.springbootmemcachexmemcached.common;


import com.alibaba.fastjson.JSON;
import com.example.springbootmemcachexmemcached.factory.TuringMemcachedFactory;


import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName: MemcachedService
 * @Description: (描述)  处理逻辑层使用 Memcached 存储和获取 缓存的 一个对象和List集合对象的逻辑工具类
 * @Author: WHT
 * @Version: V1.0
 * @Date: 2020/10/13 09:58
 */
public class MemcachedService {

    /**
     * 将一个对象数据写入缓存之中
     *
     * @param cacheKey 存储缓存的 key
     * @param object   对应key的区分可以为 ID 或其他字段
     * @param t        泛型类
     * @param <T>      泛型
     */
    public static <T> void setMemcached(String cacheKey, Object object, T t) {

        String newCacheKey = cacheKey + object;

        if (object == null || t == null) {
            return;
        }

        String json = JSON.toJSONString(t);

        // 设置到memcached中，有效期1天
        TuringMemcachedFactory.add(newCacheKey, json, TuringMemcachedFactory.ONE_DAY);

    }

    /**
     * 获取一个对象缓存数据
     *
     * @param cacheKey 存储缓存的 key
     * @param object   对应key的区分可以为 ID 或其他字段
     * @param tClass   泛型类的class
     * @param <T>      泛型
     * @return 泛型类
     */
    public static <T> T getMemcached(String cacheKey, Object object, Class<T> tClass) {

        String newCacheKey = cacheKey + object;

        if (object == null) {

            return null;
        }

        Object obj = TuringMemcachedFactory.get(newCacheKey);

        if (obj != null) {

            String jsonTrackingBean = (String) obj;

            return JSON.parseObject(jsonTrackingBean, tClass);

        } else {

            return null;
        }
    }


    /**
     * 将范型 List集合对象数据 转为 json字符串集合 写入对应的key 缓存之中
     *
     * @param tList    List 集合
     * @param cacheKey 存储缓存的 key
     * @param <T>      泛型
     */
    public static <T> void setMemcachedList(List<T> tList, String cacheKey) {


        List<String> jsonStrList = new ArrayList<String>();

        for (T t : tList) {

            jsonStrList.add(JSON.toJSONString(t));
        }

        // 设置到memcached中，有效期1天
        TuringMemcachedFactory.add(cacheKey, jsonStrList, TuringMemcachedFactory.ONE_DAY);

    }


    /**
     * 根据对应的 key 获取 json字符串集合缓存数据 遍历为 List集合对象
     *
     * @param cacheKey 存储缓存的 key
     * @param tClass   泛型类的class
     * @param <T>      泛型
     * @return 泛型集合
     */
    public static <T> List<T> getMemcachedList(String cacheKey, Class<T> tClass) {


        Object obj = TuringMemcachedFactory.get(cacheKey);

        if (obj instanceof List) {

            @SuppressWarnings("unchecked")
            List<String> jsonList = (List<String>) obj;

            if (jsonList.size() > 0) {

                List<T> tList = new ArrayList<T>();

                for (String s : jsonList) {

                    T t = (T) JSON.parseObject(s, tClass);

                    tList.add(t);
                }

                return tList;
            }
        }

        return null;

    }
}
