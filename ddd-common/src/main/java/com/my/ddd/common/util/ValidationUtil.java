package com.my.ddd.common.util;

import com.my.ddd.common.exception.ValidationException;

/**
 * 校验工具类
 *
 */
public class ValidationUtil {

    public static void isTrue(boolean expect, String code, Object... params) {
        if (!expect) {
            throw ValidationException.of(code, params);
        }
    }

    public static void isFalse(boolean expect, String code, Object... params) {
        isTrue(!expect, code, params);
    }

}