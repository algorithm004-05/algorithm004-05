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

int maxProfit(vector<int>& prices) {
    int maxPro = 0;
    for (int i = 1; i < prices.size(); ++i) {
        if (prices[i] > prices[i - 1]) maxPro += prices[i] - prices[i - 1];
    }
    return maxPro;
}


// 思路2: 峰值法
// 每次在峰谷买入峰顶卖出收益最大

// 时间复杂度：O(N)
// 空间复杂度：O(1)

int maxProfit2(vector<int>& prices) {
    int maxPro = 0;
    int dayCount = prices.size() - 1;
    int i = 0;
    int buy, sell;
    while (i < dayCount) {
        buy = prices[i];
        while (i < dayCount && prices[i] >= prices[i + 1]) buy = prices[++i];
        sell = prices[i];
        while (i < dayCount && prices[i] <= prices[i + 1]) sell = prices[++i];
        maxPro += sell - buy;
    }
    
    return maxPro;
}

void leetcode_test_122(void) {
    vector<int>& prices = {7,1,5,3,6,4};
    maxProfit(prices); // 6
    maxProfit2(prices); // 6
}