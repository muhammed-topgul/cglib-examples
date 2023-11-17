package com.mtopgul.other.interfaceMaker;

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
        assert methods.length == 1;
        assert methods[0].getName().equals("foo");
        assert Arrays.toString(methods[0].getParameterTypes()).equals("[int, short]");
        assert methods[0].getReturnType().toString().equals("double");
    }
}
