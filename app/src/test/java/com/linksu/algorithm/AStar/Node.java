package com.linksu.algorithm.AStar;

import android.support.annotation.NonNull;

/**
 * Created by suful on 2017/12/17.
 * 记录地图上的节点
 */

public class Node implements Comparable<Node> {
    public int g;
    public int h;
    public Coord coord;
    public Node parent;//父节点

    public Node(int x, int y) {
        coord = new Coord(x, y);
    }


    public Node(int g, int h, Coord coord, Node parent) {
        this.g = g;
        this.h = h;
        this.coord = coord;
        this.parent = parent;
    }

    @Override
    public int compareTo(@NonNull Node o) {
        if (o == null) {
            return -1;
        }
        if (g + h > o.g + o.h) {
            return 1;
        } else if (g + h < o.g + o.h) {
            return -1;
        }
        return 0;
    }
}
