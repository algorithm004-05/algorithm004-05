/*
 * @lc app=leetcode.cn id=122 lang=cpp
 *
 * [122] 买卖股票的最佳时机 II
 */
#include <vector>
using namespace std;
// @lc code=start
class Solution {
public:
    int maxProfit(vector<int>& prices) {
        int maxProfit=0,profit=0;
        for(int i=1;i<prices.size();i++){
            profit=prices[i]-prices[i-1];
            if(profit>0){
                maxProfit=maxProfit+profit;
            }
        }
        return maxProfit;
    }
};
// @lc code=end

