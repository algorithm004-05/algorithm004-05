//给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。 
//
// 你可以假设每种输入只会对应一个答案。但是，你不能重复利用这个数组中同样的元素。 
//
// 示例: 
//
// 给定 nums = [2, 7, 11, 15], target = 9
//
//因为 nums[0] + nums[1] = 2 + 7 = 9
//所以返回 [0, 1]
// 
// Related Topics 数组 哈希表


import java.util.HashMap;
import java.util.Map;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int minPathSum(int[][] grid) {

        int rows = grid.length;
        int cols = grid[0].length;
        int[][] dp = new int[rows][cols];
        int minSum = 0;
        dp[0][0] = grid[0][0];
        for (int i = 0; i<rows;i++){
            for (int j = 0;j<cols;j++){
                if (i==0 && j > 0){
                    dp[i][j] = dp[i][j-1]+grid[i][j];
                    continue;
                }
                if(i>0 && j == 0){
                    dp[i][j] = dp[i-1][j]+grid[i][j];
                    continue;
                }
                if (i>0 && j>0){
                    dp[i][j] = Math.min(dp[i][j-1],dp[i-1][j]) + grid[i][j];
                    continue;
                }
            }
        }

        return dp[rows-1][cols-1];
    }
}
//leetcode submit region end(Prohibit modification and deletion)
