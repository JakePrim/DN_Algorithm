package com.linksu.algorithm.AStar;

/**
 * Created by suful on 2017/12/17.
 * 地图的坐标
 */

public class Coord {
    public int x;
    public int y;

    public Coord(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (obj instanceof Coord) {
            Coord coord = (Coord) obj;
            if (this.x == coord.x && this.y == coord.y) {
                return true;
            }
        }
        return false;
    }
}
