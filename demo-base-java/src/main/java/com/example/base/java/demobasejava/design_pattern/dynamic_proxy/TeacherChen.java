package com.example.base.java.demobasejava.design_pattern.dynamic_proxy;

/**
 * @author benjamin
 * created at 2019/7/16
 */
public class TeacherChen implements Boy {

    public boolean dating(char cup) {
        if (cup == 'E') {
            System.out.println("这个女老板品德正好，可以约！");
            return true;
        }
        System.out.println("这个女老板品德不行，不可以约！");
        return false;
    }

    public void show() {
        System.out.println("开始进入拍摄模式。。。。。。。。");
    }

}

