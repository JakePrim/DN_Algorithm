package com.linksu.algorithm;

import org.junit.Test;

/**
 * Created by suful on 2017/12/9.
 * 冒泡排序及快速排序
 */

public class Les12 {

    @Test
    public void text() {
//        int[] array = new int[]{1, 2, 5, 6, 7, 18, 21, 22, 27, 29, 30, 32, 33};
//        System.out.println(twoFind(array, 0, array.length, 33));

        int[] array = new int[]{31, 24, 68, 59, 12, 40};
        questSort(array, 0, array.length);
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
    }


    /**
     * 快速排序
     *
     * @param array
     * @param begin
     * @param end
     */
    private static void questSort(int[] array, int begin, int end) {
        if (end - begin <= 1) {
            return;
        }
        int low = begin;
        int high = end - 1;
        int x = array[begin];
        //由于会在两头取数据，需要一个方向
        boolean direction = true;
        //开始进行数据的移动
        L1:
        while (low < high) {
            if (direction) {
                for (int i = high; i > low; i--) {
                    if (array[i] <= x) {
                        array[low++] = array[i];
                        high = i;
                        direction = !direction;
                        continue L1;
                    }
                }
                high = low;
            } else {
                for (int i = 0; i < high; i++) {
                    if (array[i] >= x) {
                        array[high--] = array[i];
                        low = i;
                        direction = !direction;
                        continue L1;
                    }
                }
                low = high;
            }
        }
        //把最后找到的值放入中间位置 写成low 或者 high 都行
        array[low] = x;
        questSort(array, begin, low - 1);
        questSort(array, low + 1, end);
    }

    /**
     * 二分查找法  左闭右开的原则
     *
     * @return
     */
    private int twoFind(int[] array, int fromIndex, int toIndex, int key) {
        int low = fromIndex;
        int high = toIndex - 1;
        while (low <= high) {
            int mid = (low + high) >>> 1;// 无符号除2
            System.out.println("mid:" + mid);
            if (key < array[mid]) {
                high = mid - 1;
            } else if (key > array[mid]) {
                low = mid + 1;
            } else {
                return mid;
            }
        }
        return -(low + 1);
    }

    @Test
    public void test() {
//        int[] array = new int[]{1, 3, 5, 10, 4, 7, 8, 9, 10};
        int[] array = new int[]{11, 3, 25, 10, 14, 7, 18, 9, 10};
//        mager(array, 0, 4, array.length - 1);
        magerSort(array, 0, array.length - 1);
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
    }

    /**
     * 对两个有序的据说进行归并排序
     *
     * @param array
     * @param left
     * @param min
     * @param right
     */
    private static void mager(int[] array, int left, int min, int right) {
        int leftSize = min - left;//左边数据的大小
        int rightSize = right - min + 1;//右边数据的大小
        int[] leftArray = new int[leftSize];//左边的数组
        int[] rightArray = new int[rightSize];//右边的数组
        //将左边的数据放入到数组中
        for (int i = left; i < min; i++) {
            leftArray[i - left] = array[i];
        }
        //将右边的数据放入到数组中
        for (int i = min; i <= right; i++) {
            rightArray[i - min] = array[i];
        }

        //进行归并
        int l = 0;//左边数据开始的位置
        int r = 0;//右边数据开始的位置
        int k = left;

        while (l < leftSize && r < rightSize) {
            if (leftArray[l] < rightArray[r]) {
                array[k++] = leftArray[l++];
            } else {
                array[k++] = rightArray[r++];
            }
        }

        //
        while (l < leftSize) {//左边还有数据没完
            array[k++] = leftArray[l++];
        }

        while (r < rightSize) {//右边还有数据没完
            array[k++] = rightArray[r++];
        }
//        for (int i = 0; i < array.length; i++) {
//            System.out.print(array[i] + " ");
//        }
//        System.out.println();
    }

    private static void magerSort(int[] array, int left, int right) {
        if (left == right) {
            return;
        } else {
            int mid = (left + right) / 2;
            magerSort(array, left, mid);
            magerSort(array, mid + 1, right);
            System.out.println("left:" + left + " mid:" + (mid + 1) + " right:" + right);
            mager(array, left, mid + 1, right);
        }

    }
}
