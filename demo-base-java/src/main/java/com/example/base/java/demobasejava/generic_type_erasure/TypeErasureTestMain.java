package com.example.base.java.demobasejava.generic_type_erasure;

/**
 * @author benjamin
 * created at 2019/7/9
 */
public class TypeErasureTestMain {

    public static void main(String[] args) {

        MyNode mn = new MyNode(5);
        Node n = mn;            // A raw type - compiler throws an unchecked warning
        n.setData("Hello");
//        n.setData(100);
        Integer x = mn.data;    // Causes a ClassCastException to be thrown.

    }
}
