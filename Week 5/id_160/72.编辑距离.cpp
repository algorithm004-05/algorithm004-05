/*
 * @lc app=leetcode.cn id=72 lang=cpp
 *
 * [72] 编辑距离
 */

// @lc code=start
class Solution {
public:
    //集合表示 dp[i][j] 对前i个字符进行操作,转换为目标的前j个字符的操作次数 属性->操作次数最小值
    
    //集合划分 dp[i][j]的来源  考虑对第i个字符进行的操作是什么
    //1 插入操作 从而相等 所以先让前i个字符变为j-1字符，然后在第i处插入j代表的字符 即dp[i][j-1]+1
    //2 删除操作 从而相等 所以先让前i-1个字符变为j字符，然后在第i处删除 即dp[i-1][j]+1
    //3 替换操作 从而相等 if(i处等于j处 不需要替换) 即dp[i-1][j-1]
    //                   else 需要替换 dp[i-1][j-1]+1 
    //上述取个最小值即可
    int minDistance(string w1, string w2) {
        int n = w1.size(), m = w2.size();
        vector<vector<int>> dp(n+1,vector<int>(m+1));
        for(int i = 0; i <= n; i++) dp[i][0] = i;//i个字符转化为0个字符 只能一直删i次
        for(int j = 0; j <= m; j++) dp[0][j] = j;//0个字符转化为j个字符 只能一直插入j次
        for(int i = 1; i <= n; i++){
            for(int j = 1; j <= m; j++){
                dp[i][j] = min(dp[i][j-1],dp[i-1][j])+1;//插入 删除 时
                dp[i][j] = min(dp[i][j],dp[i-1][j-1] + (w1[i-1]==w2[j-1] ? 0:1));//替换时
            }
        }
        return dp[n][m];
    }
};
// @lc code=end

