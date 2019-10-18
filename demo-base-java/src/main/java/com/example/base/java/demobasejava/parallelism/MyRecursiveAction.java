package com.example.base.java.demobasejava.parallelism;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveAction;

/**
 * @author benjamin
 * created at 2019/10/12
 */
public class MyRecursiveAction extends RecursiveAction {

    public static void main(String[] args) {
        MyRecursiveAction action = new MyRecursiveAction(100);
        ForkJoinPool.commonPool().invoke(action);
    }

    private long workLoad = 0;

    public MyRecursiveAction(long workLoad) {
        this.workLoad = workLoad;
    }

    @Override
    protected void compute() {

        //if work is above threshold, break tasks up into smaller tasks
        if (this.workLoad > 16) {
            System.out.println("Splitting workLoad : " + this.workLoad);

            invokeAll(new MyRecursiveAction(this.workLoad / 2), new MyRecursiveAction(this.workLoad / 2));

        } else {
            System.out.println("Doing workLoad myself: " + this.workLoad);
        }
    }

}
