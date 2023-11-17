package com.mtopgul.other.fastClass;

import net.sf.cglib.reflect.FastClass;
import net.sf.cglib.reflect.FastMethod;

import java.lang.reflect.InvocationTargetException;

/**
 * @author muhammed-topgul
 * @since 17/11/2023 08:40
 */
public class FastClassTest {
    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException {
        FastClass fastClass = FastClass.create(SampleBean.class);
        FastMethod fastMethod = fastClass.getMethod(SampleBean.class.getMethod("getValue"));
        SampleBean bean = new SampleBean();
        bean.setValue("Java");
        assert "Java".equals(fastMethod.invoke(bean, new Object[0]));
    }
}
