/*
 * @lc app=leetcode.cn id=62 lang=cpp
 *
 * [62] 不同路径
 */
#include <vector>
using namespace std;
// @lc code=start
class Solution {
public:
    int uniquePaths(int m, int n) {
        if(m==0|| n==0) return 0;
        vector<vector<int>> steps(m,vector(n,1));
        if(m==1 || n ==1) return 1;
        
        for (int i = m-2; i >= 0; i--)
        {
            for (int j = n-2; j >=0 ; j--) steps[i][j]=steps[i][j+1]+steps[i+1][j];
        }
        return steps[0][0];
        
    }
};
// @lc code=end

