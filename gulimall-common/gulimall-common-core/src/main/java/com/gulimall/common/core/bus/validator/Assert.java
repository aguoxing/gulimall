package com.gulimall.common.core.bus.validator;


import com.gulimall.common.core.exception.ServiceException;
import com.gulimall.common.core.utils.StringUtils;

/**
 * 数据校验
 *
 * @author Mark sunlightcs@gmail.com
 */
public abstract class Assert {

    public static void isBlank(String str, String message) {
        if (StringUtils.isBlank(str)) {
            throw new ServiceException(message);
        }
    }

    public static void isNull(Object object, String message) {
        if (object == null) {
            throw new ServiceException(message);
        }
    }
}
