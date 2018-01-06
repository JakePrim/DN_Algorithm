package com.linksu.algorithm.reference;

import java.lang.ref.ReferenceQueue;
import java.lang.ref.SoftReference;
import java.lang.ref.WeakReference;

/**
 * Created by suful on 2018/1/6.
 */

public class Test {

    @org.junit.Test
    public void test() {
        //软引用
        Object softObj = new Object();
        //引用队列
        ReferenceQueue<Object> referenceQueue = new ReferenceQueue<>();
        //创建软引用 内存不足时才会被回收
        SoftReference<Object> softReference = new SoftReference<>(softObj, referenceQueue);

        System.out.println("softReference:"+softReference.get());
        System.out.println("referenceQueue:"+referenceQueue.poll());

        //弱引用
        Object weakObj = new Object();
        //引用队列
        ReferenceQueue<Object> weakQueue = new ReferenceQueue<>();
        //创建软引用 gc 扫到弱引用直接回收
        WeakReference<Object> weakReference = new WeakReference<>(weakObj, weakQueue);

        System.out.println("weakReference:"+weakReference.get());
        System.out.println("weakQueue:"+weakQueue.poll());

        weakObj = null;
        System.gc();//gc 扫
        System.out.println("weakReference:"+weakReference.get());
        System.out.println("weakQueue:"+weakQueue.poll());//如果 poll 不是空的 就说明引用被回收了

    }
}
