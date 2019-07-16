package com.example.springboot.mybatis.mybatisdemo.aop_transactional;

import com.alibaba.druid.pool.DruidPooledConnection;
import com.sun.org.apache.xerces.internal.impl.xpath.regex.RegularExpression;
import org.aopalliance.aop.Advice;
import org.springframework.aop.Advisor;
import org.springframework.aop.Pointcut;
import org.springframework.aop.PointcutAdvisor;
import org.springframework.aop.aspectj.AspectJAroundAdvice;

import org.springframework.aop.aspectj.AspectJExpressionPointcut;
import org.springframework.aop.aspectj.AspectJPointcutAdvisor;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.transaction.interceptor.TransactionInterceptor;
import org.springframework.transaction.interceptor.TransactionProxyFactoryBean;

import org.springframework.aop.framework.ProxyFactoryBean;




/**
 * @author benjamin
 * created at 2019/7/11
 */
public class AOPTransactionalExamples {


//     Thread.currentThread().getId();
//
//    ThreadLocal<DruidPooledConnection> tl = new ThreadLocal<>();
//    DruidPooledConnection conn = tl.get(); // 获取当前tl对象value
//
//    // 获取当前Thread对象的ThreadLocal对象？

    public static void main(String[] args) {


    }


}
