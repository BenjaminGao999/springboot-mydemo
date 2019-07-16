package com.example.base.java.demobasejava.design_pattern.statis_proxy;

/**
 * @author benjamin
 * created at 2019/7/16
 */
public class TuHao {

    private float length;

    public TuHao(float length) {
        super();
        this.length = length;
    }

    public float getLength() {
        return length;
    }

    public void setLength(float length) {
        this.length = length;
    }

    //约会
    public void dating(Girl g) {
        g.dating(length);
    }

}

