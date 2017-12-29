package com.linksu.algorithm.list;

/**
 * Created by suful on 2017/12/24.
 */

public class Test {
    @org.junit.Test
    public void test() {
//        LinkedList<Integer> linkedList = new LinkedList<>();
//        linkedList.add(1);
//        linkedList.add(3);
//        linkedList.add(2);
//        linkedList.add(5);
//        linkedList.add(7);
//        linkedList.add(0,-1);
//        linkedList.add(2,0);
//        linkedList.remove(2);
//        for (int i = 0; i < linkedList.size; i++) {
//            System.out.print(linkedList.get(i) + " ");
//        }
        SingleList<Integer> singleList = new SingleList<>();
        singleList.add(1);
        singleList.add(2);
        singleList.add(3);
        singleList.add(4);
        singleList.add(5);
//        singleList.add(9,0);
//        singleList.add(8,5);
//        singleList.add(7,2);
//        singleList.remove(6);
        singleList.remove(3);
        for (int i = 0; i < singleList.size; i++) {
            System.out.print(singleList.get(i) + " ");
        }
    }
}
