package com.mtopgul.other;

import net.sf.cglib.core.Signature;
import net.sf.cglib.proxy.InterfaceMaker;
import org.objectweb.asm.Type;

import java.lang.reflect.Method;
import java.util.Arrays;

/**
 * @author muhammed-topgul
 * @since 16/11/2023 08:30
 */
public class InterfaceMakerTest {
    public static void main(String[] args) {
        Signature fooSignature = new Signature("foo", Type.DOUBLE_TYPE, new Type[]{Type.INT_TYPE, Type.SHORT_TYPE});
        InterfaceMaker interfaceMaker = new InterfaceMaker();
        interfaceMaker.add(fooSignature, new Type[0]);
        Class newInterface = interfaceMaker.create();
        Method[] methods = newInterface.getMethods();
        System.out.println(methods.length);                                  // 1
        System.out.println(methods[0].getName());                            // foo
        System.out.println(Arrays.toString(methods[0].getParameterTypes())); // [int, short]
        System.out.println(methods[0].getReturnType());                      // double
    }
}
