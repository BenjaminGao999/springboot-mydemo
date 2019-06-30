package com.example.base.java.demobasejava.reference;

import java.lang.ref.*;

/**
 * @author benjamin
 * created at 2019/6/29
 */
public class ReferenceMain {

//    public static void main(String[] args) {
//       /* // strong reference
//        Bean bean = new Bean("jack", 10);
//        System.gc();
//        System.runFinalization();
//
//        // jack
//        System.out.println(bean.getName());*/
//
//
//        //java.lang.OutOfMemoryError: GC overhead limit exceeded
//        //JVM spent too much time doing garbage collection without any success
//        // 因为没有足够的内存可用， 导致GC占据了超过98%的时间， 且没有内存可用
//
//        //java.lang.OutOfMemoryError: Java heap space
//        // Action: Increase the heap size. The java.lang.OutOfMemoryError exception for GC Overhead limit exceeded can be turned off with the command line flag -XX:-UseGCOverheadLimit.
//
//        Bean[] referent = new Bean[16_000];
//
//        for (int i = 0; i < referent.length; i++) {
//
//            referent[i] = new Bean("jack" + i, 1000);
//        }
//
//        System.out.println(referent[100]);
//    }

//    public static void main(String[] args) {
//       /* // soft reference
//
//        SoftReference<Bean> softReference = new SoftReference<>(new Bean("jack", 10));
//        System.gc();
//        System.runFinalization();
//
//        // jack
//        System.out.println(softReference.get().getName());*/
//
//
//        //java.lang.OutOfMemoryError: Java heap space  100_000
//
//        //  new SoftReference(null); 24_900
//
//        Reference<Bean>[] referent = new SoftReference[20_000];
//        for (int i = 0; i < referent.length; i++) {
//            referent[i] = new SoftReference<Bean>(new Bean("mybean:" + i, 100));
//        }
//
//        System.out.println(referent[100].get());// “null”
//    }


    public static void main(String[] args) {
        // weak reference

        Bean jack = new Bean("jack", 10);
        WeakReference<Bean> weakReference = new WeakReference<Bean>(jack);


        jack = null; // 断开了对referent的强引用

        System.gc();
        System.runFinalization();


        // null
        System.out.println(weakReference.get() == null ? null : weakReference.get().getName());


        //if almost 98% of CPU for a Java process is busy doing GC and reclaims very less amount of Java heap space around 2%, then JVM throws "java.lang.OutOfMemoryError: GC overhead limit exceeded" error.

        /*Reference<Bean>[] referent = new WeakReference[16_000];
        for (int i = 0; i < referent.length; i++) {
            referent[i] = new WeakReference<>(new Bean("mybean:" + i, 100));
        }

        System.out.println(referent[100].get());// “null”*/
    }


//    public static void main(String[] args) {
//        //java.lang.OutOfMemoryError: Java heap space 10_000
//        Reference<Bean>[] referent = new PhantomReference[10_000];
//        ReferenceQueue<Bean> queue = new ReferenceQueue<Bean>();
//        for (int i = 0; i < referent.length; i++) {
//            referent[i] = new PhantomReference<Bean>(new Bean("mybean:" + i, 100),
//                    queue);// throw Exception
//        }
//
//        // null 8_000
//        System.out.println(referent[100].get());
//    }


//    public static void main(String[] args) {
//
//        //java.lang.OutOfMemoryError: Java heap space
//        Reference[] referent = new WeakReference[30_620];
//        for (int i = 0; i < referent.length; i++) {
//            referent[i] = new WeakReference<>(null);
//        }
//
//    }

}
