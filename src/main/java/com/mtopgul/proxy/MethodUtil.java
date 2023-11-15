package com.mtopgul.proxy;

import java.lang.reflect.Method;

/**
 * @author muhammed-topgul
 * @since 15/11/2023 09:15
 */
public class MethodUtil {
    public static void printMeta(String when, Method method) {
        System.out.printf("> %s invoking %s.%s();%n", when, method.getDeclaringClass().getSimpleName(), method.getName());
    }
}
