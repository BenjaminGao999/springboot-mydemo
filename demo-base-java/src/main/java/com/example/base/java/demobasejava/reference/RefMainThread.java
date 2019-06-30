package com.example.base.java.demobasejava.reference;

import java.lang.ref.PhantomReference;
import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.SoftReference;
import java.lang.ref.WeakReference;

public class RefMainThread {
    public static void main(String[] args) {
// 创建三种不同的引用类型所需对象
        RefTestObj softRef = new RefTestObj();
        RefTestObj weakRef = new RefTestObj();
        RefTestObj phanRef = new RefTestObj();

        softRef.setId(1);
        weakRef.setId(2);
        phanRef.setId(3);

        ReferenceQueue<RefTestObj> softRefQueue = new ReferenceQueue<RefTestObj>();
        ReferenceQueue<RefTestObj> weakRefQueue = new ReferenceQueue<RefTestObj>();
        ReferenceQueue<RefTestObj> phanRefQueue = new ReferenceQueue<RefTestObj>();

        SoftReference<RefTestObj> softRefObj =
                new SoftReference<RefTestObj>(softRef, softRefQueue);
        WeakReference<RefTestObj> weakRefObj =
                new WeakReference<RefTestObj>(weakRef, weakRefQueue);
        PhantomReference<RefTestObj> phanRefObj =
                new PhantomReference<RefTestObj>(phanRef, phanRefQueue);

// 打印正常情况下三种对象引用
        print(softRefObj);
        print(weakRefObj);
        print(phanRefObj);

// 将对象清空
        softRef = null;
        weakRef = null;
        phanRef = null;

// 打印引用队列及 get() 方法所能取到的对象自身
        if (softRefObj != null) {
            System.out.println("Soft Reference Object run get():" + softRefObj.get());
            System.out.println("Check soft queue:" + softRefQueue.poll());
        }

        if (weakRefObj != null) {
            System.out.println("Weak Reference Object run get():" + weakRefObj.get());
            System.out.println("Check weak queue:" + weakRefQueue.poll());
        }

        if (phanRefObj != null) {
            System.out.println("Phantom Reference Object run get():" + phanRefObj.get());
            System.out.println("Check Phantom queue:" + phanRefQueue.poll());
        }

// 开始执行垃圾回收
        System.gc();
        System.runFinalization();

// 检查队列，是否已经被加入队列，是否还能取回对象
        if (softRefObj != null) {
            System.out.println("Soft Reference Object run get():" + softRefObj.get());
            System.out.println("Check soft queue:" + softRefQueue.poll());
        }

        if (weakRefObj != null) {
            System.out.println("Weak Reference Object run get():" + weakRefObj.get());
            System.out.println("Check weak queue:" + weakRefQueue.poll());
        }
        if (phanRefObj != null) {
            System.out.println("Phantom Reference Object run get():" + phanRefObj.get());
            System.out.println("Check Phantom queue:" + phanRefQueue.poll());
        }

// 对于虚引用对象，在经过多次 GC 之后， 才会加入到队列中去
        Reference<? extends RefTestObj> mynewphantom = null;
        int refCount = 1;
        while (mynewphantom == null) {
            mynewphantom = phanRefQueue.poll();
            System.gc();
            System.runFinalization();
            if (mynewphantom != null) {
                System.out.println("Check Phantom queue:" + mynewphantom);
                System.out.println("Count for " + refCount + " times");
                break;
            }
            refCount++;
        }


//        The Reference is java.lang.ref.SoftReference@4517d9a3 and with object com.example.base.java.demobasejava.reference.RefTestObj@372f7a8d[id=1] which is not null
//        The Reference is java.lang.ref.WeakReference@2f92e0f4 and with object com.example.base.java.demobasejava.reference.RefTestObj@28a418fc[id=2] which is not null
//        The Reference is java.lang.ref.PhantomReference@5305068a and with object null which is null
//        Soft Reference Object run get():com.example.base.java.demobasejava.reference.RefTestObj@372f7a8d[id=1]
//        Check soft queue:null
//        Weak Reference Object run get():com.example.base.java.demobasejava.reference.RefTestObj@28a418fc[id=2]
//        Check weak queue:null
//        Phantom Reference Object run get():null
//        Check Phantom queue:null
//        Object [681842940][id=2] come into finalize
//        Object [2067602151][id=3] come into finalize
//        Soft Reference Object run get():com.example.base.java.demobasejava.reference.RefTestObj@372f7a8d[id=1]
//        Check soft queue:null
//        Weak Reference Object run get():null
//        Check weak queue:java.lang.ref.WeakReference@2f92e0f4
//        Phantom Reference Object run get():null
//        Check Phantom queue:null
//        Check Phantom queue:java.lang.ref.PhantomReference@5305068a
//        Count for 2 times

    }

    public static void print(Reference<RefTestObj> ref) {
        RefTestObj obj = ref.get();
        System.out.println("The Reference is " + ref.toString() + " and with object " + obj +
                " which is " + (obj == null ? "null" : "not null"));
    }
}