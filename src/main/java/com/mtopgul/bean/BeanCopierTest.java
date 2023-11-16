package com.mtopgul.bean;

import net.sf.cglib.beans.BeanCopier;

/**
 * @author muhammed-topgul
 * @since 16/11/2023 07:54
 */
public class BeanCopierTest {
    public static void main(String[] args) {
        BeanCopier copier = BeanCopier.create(SampleBean.class, OtherSampleBean.class, false);
        SampleBean bean = new SampleBean();
        bean.setValue("Java");
        OtherSampleBean otherBean = new OtherSampleBean();
        copier.copy(bean, otherBean, null);
        System.out.println("Java".equals(otherBean.getValue())); // true
    }
}

class OtherSampleBean {
    private String value;

    public void setValue(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}