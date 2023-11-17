package com.mtopgul.other.methodDelegate;

import net.sf.cglib.reflect.MethodDelegate;

/**
 * @author muhammed-topgul
 * @since 17/11/2023 08:06
 */
public class MethodDelegateTest {
    public static void main(String[] args) {
        SampleBean bean = new SampleBean();
        bean.setValue("Java");
        BeanDelegate delegate = (BeanDelegate) MethodDelegate.create(bean, "getValue", BeanDelegate.class);
        assert "Java".equals(delegate.getDelegatedValue());
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

interface BeanDelegate {
    String getDelegatedValue();
}
