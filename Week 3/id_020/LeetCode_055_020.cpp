// Author: liuwufang
// Date: 2019/10/20

#include <vector>
using namespace std;

// https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-ii/
// https://leetcode.com/problems/best-time-to-buy-and-sell-stock-ii/

// Question:
// 122. 买卖股票的最佳时机 II
// 给定一个数组，它的第 i 个元素是一支给定股票第 i 天的价格。
// 设计一个算法来计算你所能获取的最大利润。你可以尽可能地完成更多的交易（多次买卖一支股票）。
// 注意：你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。

// Solution:
// 思路1: 贪心法（一次遍历法）
// [7,1,5,3,6,4], 只要本天比前一天的股票贵，就默认前一天买入本天卖出得到利息
// 本质是一种贪心的思想，

// 时间复杂度：O(N)
// 空间复杂度：O(1)

bool canJump(vector<int>& nums) {
    int end = nums.size() - 1;
    for (int i = end - 1; i >= 0; --i)
        if (nums[i] + i >= end) end = i;

    return end == 0;
}


// 思路2: 峰值法
// 每次在峰谷买入峰顶卖出收益最大

// 时间复杂度：O(N)
// 空间复杂度：O(1)

bool canJump2(vector<int>& nums) {
    int maxStep = 0;
    int end = nums.size() - 1;
    for (int i = 0; i < end; ++i) {
        if (i > maxStep) return false;
        if (nums[i] + i >= maxStep) maxStep = i + nums[i];
    }
    return maxStep >= end;
}


void leetcode_test_055(void) {
    vector<int>& prices = {7,1,5,3,6,4};
    maxProfit(prices); // 6
    maxProfit2(prices); // 6
}