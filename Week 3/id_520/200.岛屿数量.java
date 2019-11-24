/*
 * @lc app=leetcode.cn id=200 lang=java
 *
 * [200] 岛屿数量
 */

// @lc code=start
class Solution {

    //方法一，力扣中国站高票方法

    //  //           x-1,y
    // //  x,y-1    x,y      x,y+1
    // //           x+1,y
    // // 方向数组，它表示了相对于当前位置的 4 个方向的横、纵坐标的偏移量，这是一个常见的技巧
    // private static final int[][] directions = {{-1, 0}, {0, -1}, {1, 0}, {0, 1}};
    // // 标记数组，标记了 grid 的坐标对应的格子是否被访问过
    // private boolean[][] marked;
    // // grid 的行数
    // private int rows;
    // // grid 的列数
    // private int cols;
    // private char[][] grid;

    // public int numIslands(char[][] grid) {
    //     //确认行数
    //     rows = grid.length;
        
    //     //如果输入的行数为0，那么也不可能有岛屿的数量
    //     if (rows == 0) {
    //         return 0;
    //     }
    //     //确认列数
    //     cols = grid[0].length;
    //     this.grid = grid;
    //     marked = new boolean[rows][cols];
    //     int count = 0;
    //     for (int i = 0; i < rows; i++) {
    //         for (int j = 0; j < cols; j++) {
    //             // 如果是岛屿中的一个点，并且没有被访问过
    //             // 就进行深度优先遍历
    //             if (!marked[i][j] && grid[i][j] == '1') {
    //                 count++;
    //                 dfs(i, j);
    //             }
    //         }
    //     }
    //     return count;
    // }

    // // 从坐标为 (i,j) 的点开始进行深度优先遍历
    // private void dfs(int i, int j) {
    //     marked[i][j] = true;
    //     // 得到 4 个方向的坐标
    //     for (int k = 0; k < 4; k++) {
    //         int newX = i + directions[k][0];
    //         int newY = j + directions[k][1];
    //         // 如果不越界、没有被访问过、并且还要是陆地
    //         if (inArea(newX, newY) && grid[newX][newY] == '1' && !marked[newX][newY]) {
    //             dfs(newX, newY);
    //         }
    //     }
    // }

    // // 封装成 inArea 方法语义更清晰
    // private boolean inArea(int x, int y) {
    //     // 等于号不要忘了
    //     return x >= 0 && x < rows && y >= 0 && y < cols;
    // }


    //方法二，力扣国际站高票方法,也是DFS
    private int n;
    private int m;

    public int numIslands(char[][] grid) {
        //总共岛屿数
        int count = 0;
        //这里的n即上面方法的row
        n = grid.length;
        //同上，一开始排除输入为0的情况
        if (n == 0) return 0;
        m = grid[0].length;
        for (int i=0; i<n; i++) {
            for (int j=0; j<m; j++) {
                if (grid[i][j] == '1') {
                    DFSMarking(grid, i, j);
                    ++count;
                }
            }
        }
        return count;
    }

    private void DFSMarking(char[][] grid, int i, int j) {
        if (i<0 || j<0 || i>=n || j>=m ||grid[i][j] != '1') return;
        grid[i][j] = '0';
        DFSMarking(grid, i+1, j);
        DFSMarking(grid, i-1, j);
        DFSMarking(grid, i, j+1);
        DFSMarking(grid, i, j-1);
    }
}
// @lc code=end

