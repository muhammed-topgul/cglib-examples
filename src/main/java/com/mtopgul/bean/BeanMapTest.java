package com.mtopgul.bean;

import net.sf.cglib.beans.BeanMap;

/**
 * @author muhammed-topgul
 * @since 16/11/2023 08:03
 */
public class BeanMapTest {
    public static void main(String[] args) {
        SampleBean bean = new SampleBean();
        bean.setValue("Hello, CGLIB!");

        BeanMap map = BeanMap.create(bean);
        assert "Hello, CGLIB!".equals(map.get("value"));
    }
}
