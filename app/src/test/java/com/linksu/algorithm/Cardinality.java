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

    @Test
    public void test2() {
        int[][] a = table(3);
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[i].length; j++) {
                System.out.print(a[i][j] + " ");
            }
            System.out.println();
        }
    }

    private static int[][] table(int k) {
        int n = 1 << k;//k >>> 1 除以 2   1<<K 2次方
        int[][] table = new int[n][n];
        //将第一排填好
        for (int i = 0; i < n; i++) {
            table[0][i] = i + 1;
        }
        //开始使用分治法进行数据填写
        for (int r = 1; r < n; r = r * 2) {//表示拷贝的轮数，和人数的关系
            for (int i = 0; i < n; i = i + r * 2) {//用来表示人数不同的情况下列坐标的位置控制
                copy(table, 0, i, r, r + i, r);//左上到右下
                copy(table, 0, r + i, r, i, r);//右下到左上
            }
        }
        return table;
    }

    private static void copy(int[][] array, int formx, int formy, int tox, int toy, int r) {
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < r; j++) {
                array[tox + i][toy + j] = array[formx + i][formy + j];
            }
        }
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

    @Test
    public void textInsterSort() {
        int[] array = new int[]{23, 78, 45, 8, 32, 56};
        insterSort(array);
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
    }

    /**
     * 插入排序
     *
     * @param array
     */
    private static void insterSort(int[] array) {
        for (int i = 1; i < array.length; i++) {
            int j = i;
            int trage = array[i];
            while (j > 0 && trage < array[j - 1]) {
                array[j] = array[j - 1];
                j--;
            }
            array[j] = trage;
        }
    }

    private static void xierSort(int[] array, int step) {

    }
}
