/*
 * @lc app=leetcode.cn id=64 lang=java
 *
 * [64] 最小路径和
 */

// @lc code=start
class Solution {
    public int minPathSum(int[][] grid) {
        // 方法一 二维动态规划,使用二维的dp数组
        //时间复杂度：O(mn)，整个矩阵遍历一遍
        //空间复杂度：O(mn)开辟一个dp矩阵
        // 递推公式：dp[i,j] = grid(i,j) + min(dp[i+1][j], dp[i][j+1])
        // int[][] dp = new int[grid.length][grid[0].length];
        // for (int i = grid.length - 1; i >=0 ; i--) {
        //     for (int j = grid[0].length-1; j >= 0; j--) {
        //         //最下一行值的计算，只能用其右边的元素
        //         if(i == grid.length - 1 && j != grid[0].length - 1)
        //             dp[i][j] = grid[i][j] +  dp[i][j + 1];
        //             //最右边值的计算，只能用其左边的元素
        //         else if(j == grid[0].length - 1 && i != grid.length - 1)
        //             dp[i][j] = grid[i][j] + dp[i + 1][j];
        //             //非最下一行和最右边的，处在矩阵中间位置的元素的计算
        //         else if(j != grid[0].length - 1 && i != grid.length - 1)
        //             dp[i][j] = grid[i][j] + Math.min(dp[i + 1][j], dp[i][j + 1]);
        //         else
        //             //从最后一个元素开始
        //             dp[i][j] = grid[i][j];
        //     }
        // }
        // return dp[0][0];

        //方法二 一维动态规划
        //时间复杂度：O(mn)，整个矩阵遍历一遍
        //空间复杂度：O(n)开辟一个和行长度相等的一维矩阵
        //对于某个状态，只需要考虑其下方和右侧的点，初始化dp最后一个值是右下角的元素值
        //递推公式：dp[j] = grid(i,j) + min(dp[j], dp[j+1])
        //对于每一行都重复这个过程，然后向上移动一行，计算完成后dp(0)就是最后结果
        // int[] dp = new int[grid[0].length];
        // //循环次数依旧没变，行和列进行扫描
        // for (int i = grid.length-1; i >= 0;i--) {
        //     for (int j = grid[0].length-1 ;j >= 0; j--) {
        //         if (i == grid.length-1 && j != grid[0].length-1) {
        //             dp[j] = grid[i][j] + dp[j+1];
        //         } else if(j == grid[0].length-1 && i != grid.length-1) {
        //             dp[j] = grid[i][j] + dp[j];
        //         } else if(j != grid[0].length-1 && i != grid.length-1) {
        //             dp[j] = grid[i][j] + Math.min(dp[j+1], dp[j]);
        //         } else {
        //             dp[j] = grid[grid.length-1][grid[0].length-1];
        //         }
        //     }
        // }
        // return dp[0];

        //方法三，和方法一类似，但是直接修改传入的二维数组，这样做不需要开辟数组空间
        for (int i = grid.length - 1; i >=0 ; i--) {
            for (int j = grid[0].length-1; j >= 0; j--) {
                //最下一行值的计算，只能用其右边的元素
                if(i == grid.length - 1 && j != grid[0].length - 1)
                    grid[i][j] = grid[i][j] +  grid[i][j + 1];
                    //最右边值的计算，只能用其左边的元素
                else if(j == grid[0].length - 1 && i != grid.length - 1)
                    grid[i][j] = grid[i][j] + grid[i + 1][j];
                    //非最下一行和最右边的，处在矩阵中间位置的元素的计算
                else if(j != grid[0].length - 1 && i != grid.length - 1)
                    grid[i][j] = grid[i][j] + Math.min(grid[i + 1][j], grid[i][j + 1]);
            }
        }
        return grid[0][0];
    }
}
// @lc code=end

