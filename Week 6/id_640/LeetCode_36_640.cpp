/*
 * @lc app=leetcode.cn id=36 lang=cpp
 *
 * [36] 有效的数独
 */

// @lc code=start
class Solution {
    public:
    bool isValidSudoku(vector<vector<char>>& board)
    {
        int used1[9][9] = {0}, used2[9][9] = {0}, used3[9][9] = {0};  //分别用来判断行，列，九宫格是否有重复的元素
        for (int i = 0; i < board.size(); ++i) {
            for (int j = 0; j < board[i].size(); ++j) {
                if (board[i][j] != '.') {
                    int num = board[i][j] - '1';  //将char转换为int， 实际数组下标是从0开始的，所以要-'1'，而不是-'0'
                    int k = i / 3 * 3 + j / 3;
                    if (used1[i][num] || used2[j][num] || used3[k][num])
                        return false;
                    used1[i][num] = used2[j][num] = used3[k][num] = ' ';
                }
            }
        }
        return true;
    }
};
// @lc code=end

/*
Accepted
504/504 cases passed (12 ms)
Your runtime beats 94.88 % of cpp submissions
Your memory usage beats 99.21 % of cpp submissions (9.1 MB)
*/