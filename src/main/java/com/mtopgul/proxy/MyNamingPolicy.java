package com.mtopgul.proxy;

import net.sf.cglib.core.NamingPolicy;
import net.sf.cglib.core.Predicate;

/**
 * @author muhammed-topgul
 * @since 16/11/2023 08:14
 */
public class MyNamingPolicy implements NamingPolicy {
    @Override
    public String getClassName(String prefix, String source, Object key, Predicate predicate) {
        if (prefix == null) {
            prefix = "com.mtopgul.empty.Object";
        } else if (prefix.startsWith("java")) {
            prefix = "$" + prefix;
        }
        return prefix + "$$" + Integer.toHexString(key.hashCode());
    }
}
