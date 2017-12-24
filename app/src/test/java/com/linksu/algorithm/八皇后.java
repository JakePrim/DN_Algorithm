package com.linksu.algorithm;

import org.junit.Test;

/**
 * Created by suful on 2017/12/20.
 */

public class 八皇后 {

    @Test
    public void test() {
        eightQuee(0);
    }

    private static int[] array = new int[8];

    public static void eightQuee(int row) {

        if (row == 8) {//退出条件
            pritln();
            return;
        }
        for (int col = 0; col < 8; col++) {
            array[row] = col;
            if (judge(row)) {
                eightQuee(row + 1);
            }
        }
    }

    private static void pritln() {
        for (int i = 0; i < 8; i++) {
            System.out.print(array[i] + " ");
        }

        System.out.println();
    }

    public static boolean judge(int n) {
        for (int i = 0; i < n; i++) {
            if (array[i] == array[n] || Math.abs(array[n] - array[i]) == Math.abs(n - i)) {
                return false;
            }
        }
        return true;
    }
}
