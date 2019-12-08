/**
这题老师讲过，比如机器人或者三角形最小路径和
所以直接按照思路来写，问题不大
*/
public int minPathSum(int[][] grid) {
       int[] dp = Arrays.copyOf(grid[0], grid[0].length);
       for (int i = 1; i < dp.length; i++) {
           dp[i] += dp[i - 1]; 
       }
       for (int i = 1; i < grid.length; i++) {
           for (int j = 0; j < grid[0].length; j++) {
               if (j == 0) dp[j] += grid[i][j];
               else {
                   dp[j] = Math.min(dp[j - 1], dp[j]) + grid[i][j];
               }
           }
       }
       return dp[dp.length - 1];
    }
