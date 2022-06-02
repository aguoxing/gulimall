package com.gulimall.common.core;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

import java.util.Map;

/**
 * @author gwoksing
 * @date 2022/6/2 16:08
 */
public class SpringUtils2 implements ApplicationContextAware {
    private static ApplicationContext applicationContext;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        SpringUtils2.applicationContext = applicationContext;
    }

    public static <T> T getBean(String name) {
        if (applicationContext.containsBean(name)) {
            return (T) applicationContext.getBean(name);
        } else {
            return null;
        }
    }

    public static <T> T getBean(Class<T> clazz) {
        T bean = applicationContext.getBean(clazz);
        return applicationContext.getBean(clazz);
    }

    public static <T> T getBean(String name, Class<T> clazz) {
        return applicationContext.getBean(name, clazz);
    }

    public static <T> Map<String, T> getBeansOfType(Class<T> baseType) {
        return applicationContext.getBeansOfType(baseType);
    }
}
