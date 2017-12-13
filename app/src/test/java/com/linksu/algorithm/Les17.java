package com.linksu.algorithm;

import org.junit.Test;

/**
 * Created by suful on 2017/12/13.
 */

public class Les17 {

    @Test
    public void test() {
        String dest = "ababcaba";
        String str = "ababcabcababcabacde";
        int[] ints = kmpNext(dest);
        for (int i = 0; i < ints.length; i++) {
            System.out.print(ints[i] + " ");
        }
        System.out.println(kmp(str,dest,ints));
    }

    /**
     * 获取next 数组
     *
     * @param dest
     * @return
     */
    public static int[] kmpNext(String dest) {
        int[] next = new int[dest.length()];
        next[0] = 0;
        for (int i = 1, j = 0; i < dest.length(); i++) {
            //3 如果不相等进行循环比较
            while (j > 0 && dest.charAt(i) != dest.charAt(j)) {
                j = next[j - 1];
            }
            //1 先比较i=1 j =0 开始是否相等
            if (dest.charAt(i) == dest.charAt(j)) {
                j++;
            }
            //2 将j 放到数组中去
            next[i] = j;
        }
        return next;
    }

    /**
     * kmp 算法
     * @param str
     * @param dest
     * @param next
     * @return
     */
    public static int kmp(String str, String dest, int[] next) {
        for (int i = 1, j = 0; i < str.length(); i++) {
            while (j > 0 && dest.charAt(j) != str.charAt(i)) {
                j = next[j - 1];
            }

            if (str.charAt(i) == dest.charAt(j)) {
                j++;
            }

            if (j == dest.length()) {
                return i - j + 1;
            }
        }
        return 0;
    }
}
