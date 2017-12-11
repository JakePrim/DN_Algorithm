package com.linksu.algorithm;

import org.junit.Test;

/**
 * Created by suful on 2017/12/9.
 * 递归的思想
 */

public class Les10Recursive_1 {

    @Test
    public void test() {
        System.out.println(f(7) + "");
    }

    private void fun(int n) {
        System.out.println(n + "");
        if (n < 0) {
            return;
        } else {
            fun(n - 1);
            System.out.println(n + "");
        }
    }

    //1   1   2  3   5  8   13  ..... 斐波那契数列

    private int f(int n) {
        if (n == 1 || n == 2) {
            return 1;
        } else {
            return f(n - 1) + f(n - 2);
        }
    }

    /**
     * @param n
     * @param start  开始的柱子
     * @param moddle 中介柱子
     * @param end
     */
    private static void hanoi(int n, int start, int moddle, int end) {

        if (n <= 1) {
            System.out.println(start + "--------->" + end);
        } else {
            hanoi(n - 1, start, end, moddle);//把第一个上的n-1个移到中间
            System.out.println(start + "--------->" + end);//把第一个上的第一个移到最后
            hanoi(n - 1, moddle, start, end);//把中间的n-1 移到最后
        }
    }

    @Test
    public void test1() {
        hanoi(3, 1, 2, 3);
    }

}
