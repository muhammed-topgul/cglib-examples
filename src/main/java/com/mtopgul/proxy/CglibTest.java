package com.mtopgul.proxy;

import com.mtopgul.proxy.interceptor.BasicInterceptor;
import com.mtopgul.proxy.interceptor.FixedValueInterceptor;
import com.mtopgul.proxy.interceptor.MethodMetaInterceptor;
import com.mtopgul.proxy.service.PersonService;
import net.sf.cglib.core.NamingPolicy;
import net.sf.cglib.proxy.Enhancer;

/**
 * @author muhammed-topgul
 * @since 15/11/2023 08:51
 */
public class CglibTest {
    private static void space() {
        System.out.println("\n");
    }
    public static void main(String[] args) {
        CglibTest cglibTest = new CglibTest();
        cglibTest.runBasicInterceptor();
        space();

        cglibTest.fixedValueInterceptor();
        space();

        cglibTest.methodMetaInterceptor();
    }

    private void runBasicInterceptor() {
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(PersonService.class);
        enhancer.setCallback(new BasicInterceptor());
        enhancer.setNamingPolicy(new MyNamingPolicy());
        PersonService proxyService = (PersonService) enhancer.create();
        proxyService.performAction();
    }

    private void fixedValueInterceptor() {
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(PersonService.class);
        enhancer.setCallback(new FixedValueInterceptor());
        PersonService proxyService = (PersonService) enhancer.create();
        System.out.println(proxyService.getMessage());
    }

    private void methodMetaInterceptor() {
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(PersonService.class);
        enhancer.setCallback(new MethodMetaInterceptor());
        PersonService proxyService = (PersonService) enhancer.create();
        proxyService.proxyMethod();
//        proxyService.nonProxyMethod();
    }
}
