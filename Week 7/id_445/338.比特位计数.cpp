/*
 * @lc app=leetcode.cn id=338 lang=cpp
 *
 * [338] 比特位计数
 */
#include <vector>
using namespace std;
// @lc code=start
class Solution {
public:
    vector<int> countBits(int num) {
        vector<int>  res(num+1,0);
        for (int i = 1; i <= num; i++)
        {
            res[i]=res[i>>1]+ (i &1);
        }
        return res;
        
        
    }
};
// @lc code=end

