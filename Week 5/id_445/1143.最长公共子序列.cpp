/*
 * @lc app=leetcode.cn id=1143 lang=cpp
 *
 * [1143] 最长公共子序列
 */
#include <string>
#include <vector>
using namespace std;
// @lc code=start
class Solution {
public:
    int longestCommonSubsequence(string text1, string text2) {
        int len1=text1.length(),len2=text2.length();
        vector<vector<int>> compareRes(len1+1,vector<int>(len2+2,0));
        for (int i = 1; i < len1+1; i++)
        {
            for(int j=1;j<len2+1;j++){
                if(text1[i-1]==text2[j-1])compareRes[i][j]=compareRes[i-1][j-1]+1;
                else compareRes[i][j]=compareRes[i-1][j]>compareRes[i][j-1]?compareRes[i-1][j]:compareRes[i][j-1];
            }
        }
        return compareRes[len1][len2];
        

    }
};
// @lc code=end

