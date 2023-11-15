package com.mtopgul.proxy.interceptor;

import com.mtopgul.proxy.MethodUtil;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * @author muhammed-topgul
 * @since 15/11/2023 08:52
 */
public class BasicInterceptor implements MethodInterceptor {
    @Override
    public Object intercept(Object obj, Method method, Object[] args, MethodProxy proxy) throws Throwable {
        MethodUtil.printMeta("Before", method);
        Object result = proxy.invokeSuper(obj, args);
        MethodUtil.printMeta("After", method);
        return result;
    }
}
