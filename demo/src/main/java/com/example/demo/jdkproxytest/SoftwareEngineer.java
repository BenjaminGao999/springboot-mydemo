package com.example.demo.jdkproxytest;

/**
 * Created by PengRong on 2018/12/25.
 * 动态代理委托类实现， 实现接口 Person。 被动态生成的代理类代理
 */
public class SoftwareEngineer implements Person {

    private String name;


    public SoftwareEngineer() {
    }

    public SoftwareEngineer(String name) {
        this.name = name;
    }


    @Override
    public void goWorking(String name, String dst) {
        System.out.println("name =" + name + " ， 去 " + dst + " 工作");
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}

