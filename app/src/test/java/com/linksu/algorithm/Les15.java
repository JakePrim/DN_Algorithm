package com.linksu.algorithm;

import org.junit.Test;

/**
 * Created by suful on 2017/12/12.
 */

public class Les15 {

    @Test
    public void testHeap() {
        int[] array = new int[]{3, 4, 7, 6, 2, 8, 5, 1, 9};
        heapSort(array);
    }

    public static void heapSort(int[] array) {
        //从最后一个非叶子节点开始创建堆
        for (int i = (array.length - 1) / 2; i >= 0; i--) {
            createHeap(array, array.length, i);
        }
        // 开始输出堆顶 边调整堆
        int n = array.length;
        while (n > 0) {
            System.out.print(array[0] + " ");//根取走
            //最后一个放到根上
            array[0] = array[n - 1];
            n--;
            //重新调整
            createHeap(array, n, 0);
        }
    }

    /**
     * 创建堆
     *
     * @param array
     * @param n     堆中有多少数据
     * @param k     准备进行筛选的节点
     */
    public static void createHeap(int[] array, int n, int k) {
        int kLeft = (k * 2) + 1; //得到左树节点的下标
        int kRight = (k * 2) + 2; //得到右树节点的下标

        if (kLeft >= n && kRight >= n) {
            return;
        }
        int kLeftValue = array[kLeft]; //左树节点的值
        int kRightValue = array[kRight];//右树节点的值

        //开始三个节点比大小
        if (array[k] < kLeftValue && array[k] < kRightValue) {
            return;
        }

        if (kLeftValue < kRightValue) {
            int temp = array[k];
            array[k] = array[kLeft];
            array[kLeft] = temp;
            createHeap(array, n, kLeft);
        } else {
            int temp = array[k];
            array[k] = array[kRight];
            array[kRight] = temp;
            createHeap(array, n, kRight);
        }
    }
}
