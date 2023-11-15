package com.mtopgul.proxy.interceptor;

import com.mtopgul.proxy.MethodUtil;
import com.mtopgul.proxy.service.Proxy;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;
import java.util.Objects;

/**
 * @author muhammed-topgul
 * @since 15/11/2023 08:52
 */
public class MethodMetaInterceptor implements MethodInterceptor {
    @Override
    public Object intercept(Object obj, Method method, Object[] args, MethodProxy proxy) throws Throwable {
        Object result;
        if (method.isAnnotationPresent(Proxy.class)) {
            System.out.println("> Proxy will be trigger...");
            MethodUtil.printMeta("Before", method);
            result = proxy.invokeSuper(obj, args);
            MethodUtil.printMeta("After", method);
        } else {
            result = proxy.invokeSuper(obj, args);
        }
        return result;
    }
}
