package com.example.base.java.demobasejava.reference;

/**
 * @author benjamin
 * created at 2019/6/30
 */
public class FinalizedTestObj {


    @Override
    protected void finalize() throws Throwable {
        super.finalize();

        // 起死回生了
        FinalizedTestObj2.obj = this;
    }


    public void print(String str) {

        System.out.println(str == null ? "null" : str);
    }
}
