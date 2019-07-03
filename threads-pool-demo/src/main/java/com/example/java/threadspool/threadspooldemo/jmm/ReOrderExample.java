package com.example.java.threadspool.threadspooldemo.jmm;

/**
 * @author benjamin
 * created at 2019/7/2
 * <p>
 * 重排序
 */
public class ReOrderExample {

    static class ReOrderInnerExample {

        int a = 0;
        boolean flag = false;

        public void writer() {
            a = 1;                   //1
            flag = true;             //2
        }

        public void reader() {
            if (flag) {                //3
                int i = a * a;        //4
            }
        }

    }


    public static void main(String[] args) {

        // 多线程环境

    }


}
