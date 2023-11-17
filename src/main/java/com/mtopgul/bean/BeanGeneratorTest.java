package com.mtopgul.bean;

import net.sf.cglib.beans.BeanGenerator;

import java.lang.reflect.Method;

/**
 * @author muhammed-topgul
 * @since 16/11/2023 07:48
 */
public class BeanGeneratorTest {
    public static void main(String[] args) throws ReflectiveOperationException {
        BeanGenerator beanGenerator = new BeanGenerator();
        beanGenerator.addProperty("name", String.class);

        Object myBean = beanGenerator.create();
        Method setter = myBean.getClass().getMethod("setName", String.class);
        setter.invoke(myBean, "Some string value set by a CGLIB");
        Method getter = myBean.getClass().getMethod("getName");

        assert "Some string value set by a CGLIB".equals(getter.invoke(myBean)); // true
    }
}
