package com.linksu.algorithm;

import android.support.annotation.NonNull;

/**
 * Created by suful on 2017/12/9.
 */

public class Cards implements Comparable {

    public int casdPaon;

    public int corol;

    public Cards(int corol, int casdPaon) {
        this.casdPaon = casdPaon;
        this.corol = corol;
    }

    //用于对象比大小
    @Override
    public int compareTo(@NonNull Object o) {
        Cards cards = (Cards) o;
        if (cards.casdPaon < this.casdPaon) {
            return 1;
        } else if (cards.casdPaon > this.casdPaon) {
            return -1;
        }

        //点数相同再根据花色排序
        if (cards.corol < this.corol) {
            return 1;
        } else if (cards.corol > this.corol) {
            return -1;
        }
        return 0;
    }

    @Override
    public String toString() {
        return "Cards{" +
                "casdPaon=" + casdPaon +
                ", corol=" + corol +
                '}';
    }
}
