/**
 * LeetCode 64
 * 给定一个包含非负整数的 m x n 网格，请找出一条从左上角到右下角的路径，使得路径上的数字总和为最小。
 * 说明：每次只能向下或者向右移动一步。
 */
class Solution {
    public int minPathSum(int[][] grid) {
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (i == 0 && j == 0) {
                    //左上角 不变
                    continue;
                }
                if (i == 0) {
                    //第一列 只能从上面过来
                    grid[i][j] = grid[i][j - 1] + grid[i][j];
                    continue;
                }
                if (j == 0) {
                    //第一行 只能从左面过来
                    grid[i][j] = grid[i - 1][j] + grid[i][j];
                    continue;
                }
                //左面或上面的最小值+自己
                grid[i][j] = Math.min(grid[i - 1][j], grid[i][j - 1]) + grid[i][j];
            }
        }
        return grid[grid.length - 1][grid[0].length - 1];
    }
}
