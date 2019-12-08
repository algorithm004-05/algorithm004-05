package com.qingclass.yiban.sale.service;

/**
 * 使用动态规划进行打劫
 */
public class LeetCode_198 {
    /**
     * 使用动态规划打劫
     * @param nums 房屋数
     * @return
     */
    public int rob(int[] nums) {
        // 切题四件套,仔细查看题目,检查各种特殊情况和一般情况,不能遗漏掉特殊情况的处理
        // 1.递归终止条件或对特殊情况进行处理
        if (null == nums || nums.length == 0) {
            return 0;
        }

        // 2.动态规划的终极处理方式都是自下向上的处理方式
        // 要思考状态转移方程,最小重复子问题,要么是第一家+第三家,要么是第二家进行比较
        int[] dp = new int[nums.length + 1];
        dp[0] = 0;
        dp[1] = nums[0];
        for (int i = 2; i <= nums.length; i++) {
            dp[i] = Math.max(dp[i-1], dp[i-2] + nums[i-1]);
        }
        return dp[nums.length];
    }

}
