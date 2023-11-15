package com.mtopgul.proxy.interceptor;

import net.sf.cglib.proxy.FixedValue;

/**
 * @author muhammed-topgul
 * @since 15/11/2023 08:58
 */
public class FixedValueInterceptor implements FixedValue {
    @Override
    public String loadObject() throws Exception {
        return "Hello, I am new Fixed Value";
    }
}
