package com.linksu.algorithm.AStar;

/**
 * Created by suful on 2017/12/17.
 * 地图的信息
 */

public class MapInfo {
    public int[][] map;
    public int width;
    public int heigh;
    public Node start;
    public Node end;

    public MapInfo(int[][] map, int width, int heigh, Node start, Node end) {
        this.map = map;
        this.width = width;
        this.heigh = heigh;
        this.start = start;
        this.end = end;
    }
}
