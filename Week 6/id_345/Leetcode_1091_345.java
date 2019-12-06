package xyz.isok.algorithm.leetcode.medium;

import java.util.*;

public class No1091ShortestPathInBinaryMatrix {

    public static void main(String[] args) {

        int[][] grid = {
                {0, 0, 1, 0, 0, 0, 0},
                {0, 1, 0, 0, 0, 0, 1},
                {0, 0, 1, 0, 1, 0, 0},
                {0, 0, 0, 1, 1, 1, 0},
                {1, 0, 0, 1, 1, 0, 0},
                {1, 1, 1, 1, 1, 0, 1},
                {0, 0, 1, 0, 0, 0, 0}};

        System.out.println(new No1091ShortestPathInBinaryMatrix().shortestPathBinaryMatrix(grid));
    }

    public int shortestPathBinaryMatrix(int[][] grid) {
        if (grid == null || grid.length == 0) {
            return -1;
        }
        int length = grid.length;
        if (grid[0][0] == 1 || grid[length - 1][length - 1] == 1) {
            return -1;
        }

        if (length == 1 && grid[0][0] == 0) {
            return 1;
        }

        int[][] direction = {{1, 0}, {-1, 0}, {1, 1}, {-1, 1}, {0, 1}, {1, -1}, {-1, -1}, {0, -1}};

        List<Position> start = new ArrayList<>(length * length);
        start.add(new Position(0, 0));
        boolean[][] startMarked = new boolean[length][length];
        startMarked[0][0] = true;

        List<Position> end = new ArrayList<>(length * length);
        boolean[][] endMarked = new boolean[length][length];
        end.add(new Position(length - 1, length - 1));
        endMarked[length - 1][length - 1] = true;

        boolean[][] visited = new boolean[length][length];
        visited[0][0] = true;
        visited[length - 1][length - 1] = true;

        int distance = 1;

        return doubleBfs(start, startMarked, end, endMarked, distance, grid, visited, direction, length);
    }

    private int doubleBfs(List<Position> start, boolean[][] startMarked, List<Position> end, boolean[][] endMarked, int distance, int[][] grid, boolean[][] visited, int[][] direction, int length) {
        if (start.size() == 0) {
            return -1;
        }

        List<Position> list = new ArrayList<>();
        for (Position center : start) {
            int i = center.x, j = center.y;
            for (int[] dir : direction) {
                int cornerI = i + dir[0], cornerJ = j + dir[1];
                if (cornerI >= 0 && cornerI < length && cornerJ >= 0 && cornerJ < length && grid[cornerI][cornerJ] == 0) {
                    Position pos = new Position(cornerI, cornerJ);

                    if (endMarked[pos.x][pos.y]) {
                        return distance + 1;
                    }

                    if (visited[pos.x][pos.y]) {
                        continue;
                    }

                    list.add(pos);
                    visited[pos.x][pos.y] = true;
                    startMarked[pos.x][pos.y] = true;
                }
            }
        }
        distance++;
        if (list.size() > end.size()) {
            return doubleBfs(end, endMarked, list, startMarked, distance, grid, visited, direction, length);
        } else {
            return doubleBfs(list, startMarked, end, endMarked, distance, grid, visited, direction, length);
        }
    }
}

class Position {

    public int x;

    public int y;

    public Position(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
