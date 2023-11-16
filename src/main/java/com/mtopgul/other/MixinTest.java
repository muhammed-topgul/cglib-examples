package com.mtopgul.other;

import net.sf.cglib.proxy.Mixin;

/**
 * @author muhammed-topgul
 * @since 16/11/2023 08:22
 */
public class MixinTest {
    public static void main(String[] args) {
        Mixin mixin = Mixin.create(new Class[]{
                        Interface1.class,
                        Interface2.class,
                        MixinInterface.class
                },
                new Object[]{
                        new Class1(),
                        new Class2()
                });

        MixinInterface mixinDelegate = (MixinInterface) mixin;
        System.out.println("Fist behaviour".equals(mixinDelegate.first()));    // true
        System.out.println("Second behaviour".equals(mixinDelegate.second())); // true
    }
}

interface Interface1 {
    String first();
}

interface Interface2 {
    String second();
}

interface MixinInterface extends Interface1, Interface2 {
}

class Class1 implements Interface1 {
    @Override
    public String first() {
        return "Fist behaviour";
    }
}

class Class2 implements Interface2 {
    @Override
    public String second() {
        return "Second behaviour";
    }
}