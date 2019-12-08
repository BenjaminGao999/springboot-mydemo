package com.example.base.java.demobasejava.springframeworkjlibproxy;

import com.example.base.java.demobasejava.proxyTest.MyInterface;
import com.example.base.java.demobasejava.proxyTest.MyInterfaceImpl;
import org.springframework.cglib.proxy.InvocationHandler;
import org.springframework.cglib.proxy.Proxy;

import java.lang.reflect.Method;


/**
 * @author benjamin
 * created at 2019/7/3
 */
public class CJLIBProxyTest {

    public static void main(String[] args) {


//        Class proxyClass = getProxyClass(MyInterface.class.getClassLoader(), new Class[]{MyInterface.class});

//        MyInterfaceImpl myInterface = new MyInterfaceImpl();
//
//        MyInterface instance = (MyInterface) Proxy.newProxyInstance(MyInterface.class.getClassLoader(), new Class[]{MyInterface.class}, new InvocationHandler() {
//            @Override
//            public Object invoke(Object o, Method method, Object[] objects) throws Throwable {
//
//                System.out.println("before method ");
//
//                method.invoke(myInterface, args);
//
//                System.out.println("after method ");
//
//                return null;
//            }
//        });
//
//
//        instance.method();



    }


}
