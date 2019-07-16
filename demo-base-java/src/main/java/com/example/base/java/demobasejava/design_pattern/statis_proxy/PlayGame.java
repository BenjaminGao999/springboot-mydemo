package com.example.base.java.demobasejava.design_pattern.statis_proxy;

/**
 * @author benjamin
 * created at 2019/7/16
 */
public class PlayGame {

    public static void main(String[] args) {
        //创建土豪(使用者)、苍老师(目标对象)、tony(代理)三个对象
        TuHao th = new TuHao(1.7F);

        Girl tc = new TeacherCang();
        Tony tony = new Tony();
        //tony对苍老师进行代理
        tony.setGirl(tc);


        //土豪和tony约
        th.dating(tony);
    }

}