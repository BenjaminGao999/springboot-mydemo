package com.example.java.threadspool.threadspooldemo.locks;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author benjamin
 * created at 2019/7/3
 */
class BoundedBuffer {
    final Lock lock = new ReentrantLock();

    // 条件是未满
    final Condition notFull = lock.newCondition();
    // 条件是未空
    final Condition notEmpty = lock.newCondition();

    final Object[] items = new Object[100];
    int putptr, takeptr, count;

    public void put(Object x) throws InterruptedException {
        lock.lock();
        try {
            while (count == items.length)
                notFull.await(); // 因为条件是满，但是现在是满的， 所以等待

            items[putptr] = x;
            if (++putptr == items.length) putptr = 0;
            ++count;
            notEmpty.signal(); // 因为现在未空， 所以唤醒因为空了而等待的线程。

        } finally {
            lock.unlock();
        }
    }

    public Object take() throws InterruptedException {
        lock.lock();
        try {
            while (count == 0)
                notEmpty.await(); // 因为条件是未空， 但是现在空的， 所以等待

            Object x = items[takeptr];
            if (++takeptr == items.length) takeptr = 0;
            --count;
            notFull.signal(); //  因为现在未满， 所以唤醒因为满了而等待的线程
            return x;
        } finally {
            lock.unlock();
        }
    }
}


