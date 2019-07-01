package com.example.java.threadspool.threadspooldemo.objectmonitor;

/**
 * @author benjamin
 * created at 2019/7/1
 */
public interface Manager {

    void produce() throws InterruptedException;

    void consume() throws InterruptedException;


}
