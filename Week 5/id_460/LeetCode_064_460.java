package week5.Question64MinPathSum;
/**
 * 给定一个包含非负整数的 m x n 网格，请找出一条从左上角到右下角的路径，使得路径上的数字总和为最小。
 *
 * 说明：每次只能向下或者向右移动一步。
 *
 * 示例:
 *
 * 输入:
 * [
 *   [1,3,1],
 *   [1,5,1],
 *   [4,2,1]
 * ]
 * 输出: 7
 * 解释: 因为路径 1→3→1→1→1 的总和最小。
 *
 * */
public class MinPathSum {
    public static void main(String[] args) {
        int[][] grid = {{1, 3, 1}, {1, 5, 1}, {4, 2, 1}, {5, 6, 7}};
        System.out.println(minPathSum(grid));
    }

    //dp(i,j)=grid(i,j)+min(dp(i+1,j),dp(i,j+1))

//(1)如果是j=0的情况，这些点只能经过左侧的点走到，所以grid[i][0] = grid[i-1][0]+grid[i][0];
//(2)如果是i=0的情况，这些点只能是由上方的点走到的，所以grid[0][j] = grid[0][j-1]+grid[0][j];
//(3)如果i>0&&j>0的情况，这些点既可以由上方走到，也可以由左侧走到，那么取两者最小值即可。

    private static int minPathSum(int[][] grid) {
        int[][] dp = new int[grid.length][grid[0].length];
        int m = grid.length;//行数
        int n = grid[0].length;//列数
        for (int i = m-1; i >= 0; i--) {
            for (int j = n-1; j >= 0; j--) {
                if (i == m - 1 && j != n - 1) {
                    dp[i][j] = grid[i][j] +  dp[i][j + 1];
                } else if (i != m - 1 && j == n - 1) {
                    dp[i][j] = grid[i][j] +  dp[i+1][j];
                } else if (i != m - 1 && j != n - 1) {
                    dp[i][j] = grid[i][j] + Math.min(dp[i + 1][j], dp[i][j + 1]);
                } else{
                    dp[i][j] = grid[i][j];
                }
            }
        }

       return dp[0][0];
    }

}
