package com.example.base.java.demobasejava.proxyTest;

//import org.springframework.cglib.proxy.Proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author benjamin
 * created at 2019/7/3
 */
public class Main {
    public static void main(String[] argv) throws Exception {


//        MyInterfaceImpl myInterface = new MyInterfaceImpl();
//
//
//        MyInterface instance = (MyInterface) Proxy.newProxyInstance(MyInterface.class.getClassLoader(), new Class[]{MyInterface.class}, new InvocationHandler() {
//            @Override
//            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
//
//                Object result = null;
//                try {
//                    System.out.println("before the method is called ");
//                    result = method.invoke(myInterface, args);
//                } catch (Exception eBj) {
//                } finally {
//                    System.out.println("after the method is called");
//                }
//                return result;
//            }
//        });
//
//        instance.method();


//        MyInterface proxy = (MyInterface) Proxy.newProxyInstance(MyInterface.class.getClassLoader(),
//                new Class[]{MyInterface.class}, new ProxyClass(new MyInterfaceImpl()));
//
//
//        proxy.method();



    }
}

