package com.linksu.algorithm.list;

/**
 * Created by suful on 2017/12/24.
 */

public class Test {
    @org.junit.Test
    public void test() {
        LinkedList<Integer> linkedList = new LinkedList<>();
        linkedList.add(1);
        linkedList.add(3);
        linkedList.add(2);
        linkedList.add(5);
        linkedList.add(7);
        linkedList.add(0,-1);
        linkedList.add(2,0);
        linkedList.remove(2);
        for (int i = 0; i < linkedList.size; i++) {
            System.out.print(linkedList.get(i) + " ");
        }
    }
}
