package com.example.base.java.demobasejava.design_pattern.dynamic_proxy;

/**
 * @author benjamin
 * created at 2019/7/16
 */
public class TeacherCang implements Girl {
    public boolean dating(float length) {
        if (length >= 1.7F) {
            System.out.println("身高可以，可以约！");
            return true;
        }
        System.out.println("身高不可以，不可约！");
        return false;
    }
}

