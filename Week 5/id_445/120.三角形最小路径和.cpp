/*
 * @lc app=leetcode.cn id=120 lang=cpp
 *
 * [120] 三角形最小路径和
 */
#include <vector>
using namespace std;
// @lc code=start
class Solution {
public:
    int minimumTotal(vector<vector<int>>& triangle) {
        int len=triangle.size();
        if(len==0) return 0;
        int innerLen=triangle[len-1].size();
        if(innerLen==0) return 0;
        // if(innerLen==1) return triangle[0][0];
        for (int i = len-2; i >= 0; i--)
        {
            innerLen=triangle[i].size();
            for(int j=0;j<innerLen;j++){
                triangle[i][j]=triangle[i][j]+(triangle[i+1][j]<triangle[i+1][j+1]?triangle[i+1][j]:triangle[i+1][j+1]);
            }
        }
        return triangle[0][0];
        
    }
};
// @lc code=end

