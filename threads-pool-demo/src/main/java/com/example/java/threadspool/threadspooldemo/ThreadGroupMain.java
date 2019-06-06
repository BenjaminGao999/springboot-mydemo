package com.example.java.threadspool.threadspooldemo;

/**
 * @author benjamin
 * created at 2019/6/6
 */
public class ThreadGroupMain {

    public static void main(String[] args) {

        ThreadGroup tg = new ThreadGroup("tg");

        Thread thread01 = new Thread(tg, "thread-1");
        Thread thread02 = new Thread(tg, "thread-2");

    }
}
