package com.example.base.java.demobasejava.generic_type_erasure;

/**
 * @author benjamin
 * created at 2019/7/9
 */
public class Node<T> {

    public T data;

    public Node(T data) {
        this.data = data;
    }

    public void setData(T data) {
        System.out.println("Node.setData");
        this.data = data;
    }
}


