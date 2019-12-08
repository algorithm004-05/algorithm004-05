package com.geek.lee.leetcode.medium;

/**
 * 给定一个由 '1'（陆地）和 '0'（水）组成的的二维网格，计算岛屿的数量。一个岛被水包围，并且它是通过水平方向或垂直方向上相邻的陆地连接而成的。你可以假设网格的四个边均被水包围。
 *
 * 示例 1:
 *
 * 输入:
 * 11110
 * 11010
 * 11000
 * 00000
 *
 * 输出: 1
 * 示例 2:
 *
 * 输入:
 * 11000
 * 11000
 * 00100
 * 00011
 *
 * 输出: 3
 *
 */

/**
 * 200. 岛屿数量
 */
public class NumIslands_200 {

    int[] dx = new int[]{-1, 1, 0, 0};
    int[] dy = new int[]{0, 0, -1, 1};
    char[][] g;

    public int numIslands(char[][] grid) {

        int landsNum = 0;
        g = grid;
        //遍历每一个元素, 如果是1,则处理该元素四个方位的1
        for (int i = 0; i < g.length; i ++) {
            for (int j = 0; j < g[i].length; j ++) {
                if (g[i][j] == '0') {
                    continue;
                }
                landsNum += sink(i, j);
            }
        }

        return landsNum;
    }

    private int sink(int i, int j) {
        // 递归终止条件
        if (g[i][j] == '0') {
            return 0;
        }
        // 处理过程, 将岛夷为平地.
        g[i][j] = '0';

        for (int k = 0; k < dx.length; ++k) {
            int x = i + dx[k];
            int y = j + dy[k];
            if (x >= 0 && x < g.length && y >= 0 && y <g[i].length) {
                if (g[x][y] == '0') {
                    continue;
                }
                sink(x, y);
            }
        }

        return 1;
    }

    public static void main(String[] args) {
        char[][] grid = {
                {'1','1','1','1','0'},
                {'1','1','0','1','0'},
                {'1','1','0','0','0'},
                {'0','0','0','0','0'}
        };

        System.out.println(new NumIslands_200().numIslands(grid));

        char[][] grid2 = {
                {'1', '1', '0', '0', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '1', '0', '0'},
                {'0', '0', '0', '1', '1'}};

        System.out.println(new NumIslands_200().numIslands(grid2));
    }
}
