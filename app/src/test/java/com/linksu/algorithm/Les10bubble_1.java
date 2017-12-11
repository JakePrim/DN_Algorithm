package com.linksu.algorithm;

import org.junit.Test;

import java.lang.reflect.Array;

/**
 * Created by suful on 2017/12/9.
 * 冒泡排序及快速排序
 */

public class Les10bubble_1 {

    @Test
    public void testBubble() {

        int[] arrays = new int[]{3, 1, 5, 9, 7, 4, 8, 6, 2};
        for (int i : arrays) {
            System.out.print(i + " ");
        }
        questSort(arrays);
        System.out.println("");
        for (int i : arrays) {
            System.out.print(i + " ");
        }
    }

    private static void questSort(int[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            int index = i;
            for (int j = i + 1; j < array.length; j++) {
                if (array[j] < array[index]) {
                    index = j;
                }
            }
            if (index != i) {//表示找到过最小值
                int temp = array[i];
                array[i] = array[index];
                array[index] = temp;
            }
        }
    }

    @Test
    public void test2() {
        Cards[] cards = new Cards[]{new Cards(3, 9), new Cards(2, 7), new Cards(1, 7), new Cards(4, 3)};

        System.out.println(cards.toString());

        bubble2(cards);
        for (Cards c :
                cards) {
            System.out.println(c.toString());
        }
    }

    private static void bubble2(Cards[] arrays) {
        for (int i = arrays.length - 1; i > 0; i--) {
            boolean flag = true;
            for (int j = 0; j < i; j++) {
                if (arrays[j].compareTo(arrays[j + 1]) > 0) {
                    Cards tmpe = arrays[j];
                    arrays[j] = arrays[j + 1];
                    arrays[j + 1] = tmpe;
                    flag = false;
                }
            }
            if (flag) {
                break;
            }
        }
    }

    /**
     * 冒泡排序方法
     *
     * @param arrays 需要排序的数组
     */
    private static void bubble(int[] arrays) {
        for (int i = arrays.length - 1; i > 0; i--) {
            boolean flag = true;
            for (int j = 0; j < i; j++) {
                if (arrays[j] > arrays[j + 1]) {
                    int tmpe = arrays[j];
                    arrays[j] = arrays[j + 1];
                    arrays[j + 1] = tmpe;
                    flag = false;
                }
            }
            if (flag) {
                break;
            }
        }
    }
}
