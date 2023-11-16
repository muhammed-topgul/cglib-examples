package com.mtopgul.bean;

import net.sf.cglib.beans.ImmutableBean;

/**
 * @author muhammed-topgul
 * @since 16/11/2023 07:41
 */
public class ImmutableBeanTest {
    public static void main(String[] args) {
        SampleBean bean = new SampleBean();
        String result = "Java";
        bean.setValue(result);
        SampleBean immutableBean = (SampleBean) ImmutableBean.create(bean);
        System.out.println(immutableBean.getValue().equals(result)); // true

        String newResult = "Spring";
        bean.setValue(newResult);
        System.out.println(immutableBean.getValue().equals(newResult)); // true
        System.out.println(bean.getValue().equals(newResult)); // true

        immutableBean.setValue(newResult); // Exception in thread "main"
                                           // java.lang.IllegalStateException: Bean is immutable
    }
}

class SampleBean {
    private String value;

    public void setValue(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
