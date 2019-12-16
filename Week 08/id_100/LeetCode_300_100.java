
public class LeetCode_300_100 {
    public int lengthOfLIS(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        //定义DP方程
        // 定义dp(i)为以第i个元素为最后一个元素，其最长上升序列的求解
        int[] dp = new int[nums.length];
        dp[0] = 1;
        int max = 1;
        for (int i = 1; i < nums.length; i++) {
            int limitMax = 0;
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    limitMax = Math.max(limitMax, dp[j]);
                }
            }
            dp[i] = limitMax + 1;
            max = Math.max(dp[i], max);
        }
        return max;
    }
}