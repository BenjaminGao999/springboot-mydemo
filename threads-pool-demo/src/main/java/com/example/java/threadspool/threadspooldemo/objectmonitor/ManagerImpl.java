package com.example.java.threadspool.threadspooldemo.objectmonitor;

import java.util.*;

/**
 * @author benjamin
 * created at 2019/7/1
 */
public class ManagerImpl implements Manager {


    private Queue<String> queue;

    public ManagerImpl(Queue<String> queue) {
        this.queue = queue == null ? new LinkedList<>() : queue;
    }

    @Override
    public synchronized void produce() {
        queue.add("- good");
        if (queue.size() > 3) {
            notify();
        }
    }

    @Override
    public synchronized void consume() {
        String poll = this.queue.poll();
        if (poll == null) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        } else {
            System.out.println(Thread.currentThread().getName() + poll);
        }
    }


}
