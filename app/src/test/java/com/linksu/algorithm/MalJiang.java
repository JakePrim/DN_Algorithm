package com.linksu.algorithm;

/**
 * ================================================
 * 作    者：linksus
 * 版    本：1.0
 * 创建日期：12/7 0007
 * 描    述：
 * 修订历史：
 * ================================================
 */
public class MalJiang {
    public int potions;// 麻将点数

    public int coclor;// 花色 1 筒子 2 万 3 索

    public MalJiang(int coclor, int potions) {
        this.potions = potions;
        this.coclor = coclor;
    }

    @Override
    public String toString() {
        String s = "";
        if (coclor == 1) {
            s = "筒";
        } else if (coclor == 2) {
            s = "万";
        } else if (coclor == 3) {
            s = "条";
        }

        return "(" + this.potions + s + ")";
    }
}
