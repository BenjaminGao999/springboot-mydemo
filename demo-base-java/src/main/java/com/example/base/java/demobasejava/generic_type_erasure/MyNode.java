package com.example.base.java.demobasejava.generic_type_erasure;

/**
 * @author benjamin
 * created at 2019/7/9
 */
public class MyNode extends Node<Integer> {
    public MyNode(Integer data) {
        super(data);
    }


    public void setData(Integer data) {
        System.out.println("MyNode.setData");
        super.setData(data);
    }
}

