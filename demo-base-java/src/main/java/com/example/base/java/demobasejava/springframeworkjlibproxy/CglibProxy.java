package com.example.base.java.demobasejava.springframeworkjlibproxy;

/**
 * @author benjamin
 * created at 2019/7/3
 */

import com.example.base.java.demobasejava.proxyTest.MyInterface;
import com.example.base.java.demobasejava.proxyTest.MyInterfaceImpl;
import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

public class CglibProxy implements MethodInterceptor {
    private Enhancer enhancer = new Enhancer();

    public Object getProxy(Class cls) {
        enhancer.setSuperclass(cls);
        enhancer.setCallback(this);
        return enhancer.create();
    }

    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        System.out.println(o.getClass());
        System.out.println("开始执行 " + method.getName());
        //我们一般使用proxy.invokeSuper(obj,args)方法。这个很好理解，就是执行原始类的方法。还有一个方法proxy.invoke(obj,args)，这是执行生成子类的方法。
        //如果传入的obj就是子类的话，会发生内存溢出，因为子类的方法不停地进入intercept方法，而这个方法又去调用子类的方法，两个方法直接循环调用了。
        Object returnValue = methodProxy.invokeSuper(o, objects);
        //Object returnValue = methodProxy.invoke(o,objects);
        System.out.println("结束执行 " + method.getName());
        return returnValue;
    }

    public static void main(String[] args) {
        CglibProxy cglibProxy = new CglibProxy();
        MyInterface proxy = (MyInterface) cglibProxy.getProxy(MyInterfaceImpl.class);
        proxy.method();

    }
}

