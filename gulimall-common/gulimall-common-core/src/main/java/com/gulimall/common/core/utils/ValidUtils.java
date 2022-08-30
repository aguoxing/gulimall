package com.gulimall.common.core.utils;

import com.gulimall.common.core.exception.base.BaseException;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Optional;

/**
 * @author gwoksing
 * @date 2022/6/8 11:51
 */
public class ValidUtils {

    public void nullException(Object o, String... fields) {

    }

    private void ifException(Object obj, String... params) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Class<?> clazz = obj.getClass();
        for (String param : params) {
            Method method = clazz.getMethod("get" + param.substring(0, 1).toUpperCase() + param.substring(1));
            Object invoke = method.invoke(obj);
            Optional.ofNullable(invoke).orElseThrow(() -> new BaseException(param + " 参数为空"));
        }
    }

}
