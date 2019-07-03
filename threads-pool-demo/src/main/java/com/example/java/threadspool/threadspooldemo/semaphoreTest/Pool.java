package com.example.java.threadspool.threadspooldemo.semaphoreTest;

import java.util.concurrent.Semaphore;

/**
 * @author benjamin
 * created at 2019/7/3
 */
class Pool {
    private static final int MAX_AVAILABLE = 2;
    private final static Semaphore available = new Semaphore(MAX_AVAILABLE, true);

    public Object getItem() throws InterruptedException {
        available.acquire();
        return getNextAvailableItem();
    }

    public void putItem(Object x) {
        if (markAsUnused(x))
            available.release();
    }

    // Not a particularly efficient data structure; just for demo

    protected Object[] items = new Object[]{"whatever kinds", "of items", "being managed"};

    protected boolean[] used = new boolean[MAX_AVAILABLE];

    protected synchronized Object getNextAvailableItem() {
        for (int i = 0; i < MAX_AVAILABLE; ++i) {
            if (!used[i]) {
                used[i] = true;
                return items[i];
            }
        }
        return null; // not reached
    }

    protected synchronized boolean markAsUnused(Object item) {
        for (int i = 0; i < MAX_AVAILABLE; ++i) {
            if (item == items[i]) {
                if (used[i]) {
                    used[i] = false;
                    return true;
                } else
                    return false;
            }
        }
        return false;
    }


    public static void main(String[] args) throws InterruptedException {


        Runnable rAcq = () -> {

            for (int i = 0; i < 3; i++) {
                try {
                    available.acquire(); // 当i=2时，阻塞
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("acquire count " + i);
            }

        };

        Runnable rRel = () -> {

            for (int i = 0; i < 3; i++) {
                available.release();
                System.out.println("release count " + i);
            }

        };

        new Thread(rAcq).start();
        new Thread(rRel).start();
    }
}

