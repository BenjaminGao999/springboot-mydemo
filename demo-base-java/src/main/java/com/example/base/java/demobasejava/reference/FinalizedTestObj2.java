package com.example.base.java.demobasejava.reference;

/**
 * @author benjamin
 * created at 2019/6/30
 */
public class FinalizedTestObj2 {

    public static Object obj;


    public static void main(String[] args) throws Throwable {

        FinalizedTestObj obj1 = new FinalizedTestObj();

        obj1.finalize();

        System.out.println(obj == null ? null : obj);


    }
}
