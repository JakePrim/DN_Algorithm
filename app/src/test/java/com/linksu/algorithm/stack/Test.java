package com.linksu.algorithm.stack;

/**
 * Created by suful on 2018/2/4.
 */

public class Test {
    @org.junit.Test
    public void test() {
        Calculate calculate = new Calculate();
        char[] s = new char[]{'1', '+', '2', '-', '(', '2', '*', '3', ')', '+', '9', '#'};

        //1, 2, +, 2, 3, *, -, 9, +
        //1+2-(2*3)+9
        Object o = calculate.changeData(s);
        System.out.println("1+2-(2*3)+10 = " + o.toString());
    }
}
