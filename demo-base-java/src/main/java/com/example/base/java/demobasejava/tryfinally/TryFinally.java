package com.example.base.java.demobasejava.tryfinally;

/**
 * @author benjamin
 * created at 2019/10/22
 */
public class TryFinally {

    public static void main(String[] args) {


        try{

            int i = 10 / 0;
        }finally {

            System.out.println("异常");
        }
    }
}
