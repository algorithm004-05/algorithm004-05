/*
 * @lc app=leetcode.cn id=72 lang=cpp
 *
 * [72] 编辑距离
 */

// @lc code=start
class Solution
{
public:
    int minDistance(string word1, string word2)
    {
        int m = word1.size(), n = word2.size();
        vector<vector<int>> map(m + 1, vector<int>(n + 1, 0));
        for (int i = 0; i < m + 1; i++)
            map[i][0] = i;
        for (int i = 0; i < n + 1; i++)
            map[0][i] = i;
        for (int i = 1; i < m + 1; i++)
        {
            for (int j = 1; j < n + 1; j++)
            {
                if (word1[i - 1] == word2[j - 1])
                    map[i][j] = map[i - 1][j - 1];
                else
                {
                    map[i][j] = 1 + min(map[i - 1][j - 1], min(map[i - 1][j], map[i][j - 1]));
                }
            }
        }
        return map[m][n];
    }
};
// @lc code=end

