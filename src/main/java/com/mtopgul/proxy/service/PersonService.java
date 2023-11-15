package com.mtopgul.proxy.service;

/**
 * @author muhammed-topgul
 * @since 15/11/2023 07:32
 */
@Service
public class PersonService {
    public void performAction() {
        System.out.println("Original action in MyService.");
    }

    public String getMessage() {
        return "Hello, I am Person Service";
    }

    @Proxy
    public void proxyMethod() {
        System.out.println("I am method that annotated wit @Proxy");;
    }

    public void nonProxyMethod() {
        System.out.println("I am method that non-annotated wit @Proxy");;
    }
}
