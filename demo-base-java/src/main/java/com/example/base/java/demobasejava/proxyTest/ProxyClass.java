package com.example.base.java.demobasejava.proxyTest;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @author benjamin
 * created at 2019/7/3
 */
class ProxyClass implements InvocationHandler {
    Object obj;

    public ProxyClass(Object o) {
        obj = o;
    }

    public Object invoke(Object proxy, Method m, Object[] args) throws Throwable {
        Object result = null;
        try {
            System.out.println("before the method is called ");
            result = m.invoke(obj, args);
        } catch (Exception eBj) {
        } finally {
            System.out.println("after the method is called");
        }
        return result;
    }
}


