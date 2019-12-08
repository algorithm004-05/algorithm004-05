package com.qingclass.yiban.sale.service;

/**
 * 使用动态规划爬楼梯
 */
public class LeetCode_70 {
    /**
     * 使用动态规划爬楼梯
     * @param n 楼梯层数
     * @return
     */
    public int climbStairs(int n) {
        // 切题四件套,仔细查看题目,检查各种特殊情况和一般情况,不能遗漏掉特殊情况的处理
        // 1.递归终止条件或对特殊情况进行处理
        int from0to2 = 2;
        if (n <= from0to2) {
            return n;
        }

        // 2.动态规划的终极处理方式都是自下向上的处理方式
        int from = 1;
        int to = 2;
        int next = 0;
        for (int i = 2; i < n; i++) {
            next = from + to;
            from = to;
            to = next;
        }
        return next;
    }

}
