package com.linksu.algorithm;

import org.junit.Test;

import java.util.LinkedList;

import static org.junit.Assert.*;

/**
 * ================================================
 * 作    者：linksus
 * 版    本：1.0
 * 创建日期：12/7 0007
 * 描    述：排序-链式基数排序算法:主要用于棋牌游戏例如麻将
 * 修订历史：
 * ================================================
 */
public class Cardinality {

    @Test
    public void test() {
        LinkedList<MalJiang> list = new LinkedList<MalJiang>();
        list.add(new MalJiang(3, 1));
        list.add(new MalJiang(2, 3));
        list.add(new MalJiang(3, 7));
        list.add(new MalJiang(1, 1));
        list.add(new MalJiang(3, 8));
        list.add(new MalJiang(2, 2));
        list.add(new MalJiang(3, 2));
        list.add(new MalJiang(1, 3));
        list.add(new MalJiang(3, 9));
        System.out.println(list);
        MalJiangList(list);
        System.out.println(list);
    }


    /**
     * 将从后台得到的麻将数据，进行排序
     *
     * @param list
     *         得到的数据列表
     */
    private void MalJiangList(LinkedList<MalJiang> list) {
        //先对点数进行分组
        LinkedList[] linkedLists = new LinkedList[9];
        for (int i = 0; i < linkedLists.length; i++) {
            linkedLists[i] = new LinkedList();
        }
        //把数据放到对应的组中
        while (list.size() > 0) {// 循环列表数据
            MalJiang malJiang = list.remove();//得到麻将对象
            // 将点数放到对应的数组list中
            linkedLists[(malJiang.potions - 1)].add(malJiang);
        }
        // 然后将9个分组重新组合起来，这时list是空的
        for (int i = 0; i < linkedLists.length; i++) {
            list.addAll(linkedLists[i]);
        }
        //对花色进行分组 假设只有三种花色
        LinkedList[] suitList = new LinkedList[3];
        for (int i = 0; i < suitList.length; i++) {
            suitList[i] = new LinkedList();
        }
        //这时得到的list 是排序好的list
        while (list.size() > 0) {
            //取一个
            MalJiang m = list.remove();
            //放到对应的分组中
            suitList[m.coclor - 1].add(m);
        }
        //然后将3个花色的分组重新组合起来
        for (int i = 0; i < suitList.length; i++) {
            list.addAll(suitList[i]);
        }

    }
}
