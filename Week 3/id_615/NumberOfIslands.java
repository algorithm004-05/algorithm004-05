package com.chenlei.geektime.leetcode.lesson9;

/**
 * 岛屿数量
 *
 * 说明：
 * <pre>
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
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/number-of-islands
 * </pre>
 */
public class NumberOfIslands {

    //表示每个点的四个方向
    int[] dx = new int[]{-1,1,0,0};
    int[] dy = new int[]{0,0,-1,1};

    char[][] g;

    //Flood fill 算法
    public int numIslands(char[][] grid){
        int islands = 0; //岛屿数量
        g = grid;

        for (int i = 0; i < g.length; i++) {
            for (int j = 0; j < g[i].length; j++) {

                if(g[i][j] == '0') continue;  //水

                //否则为岛屿，进行dfs遍历
                islands += dfs(i,j);
            }

        }
        
        return islands;
    }

    private int dfs(int i, int j) {
        //终止条件
        if(g[i][j] == '0'){
            return 0;
        }

        //当前层处理，将 g[i][j] == 1设置为0
        g[i][j] = '0';

        //下一层
        for (int k = 0; k < dx.length; k++) {
            System.out.println(k);
            int x = i + dx[k];
            int y = j + dy[k];
            //边界判断
            if(x >= 0 && x < g.length && y >= 0 &&  y < g[i].length){

                if(g[x][y] == '0' ) continue;

                dfs(x,y);
            }
        }

        return 1;
    }

    public static void main(String[] args){
        NumberOfIslands numberOfIslands = new NumberOfIslands();

        char[][] grid1 = {
                {'1', '1', '1', '1', '0'},
                {'1', '1', '0', '1', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '0', '0', '0'}};

        int numIslands1 = numberOfIslands.numIslands(grid1);
        System.out.println(numIslands1);
    }

}
