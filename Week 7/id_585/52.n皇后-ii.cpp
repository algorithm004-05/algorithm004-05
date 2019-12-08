/*
 * @lc app=leetcode.cn id=52 lang=cpp
 *
 * [52] N皇后 II
 */

// @lc code=start
class Solution {
public:
    int totalNQueens(int n) {
        dfs(n, 0, 0, 0, 0);
        return this->res;
    }
    
    void dfs(int n, int row, int col, int ld, int rd) {
        if (row >= n) { res++; return; }
        
        int bits = ~(col | ld | rd) & ((1 << n) - 1);
        while (bits > 0) {
            int pick = bits & -bits; 
            dfs(n, row + 1, col | pick, (ld | pick) << 1, (rd | pick) >> 1);
            bits &= bits - 1; 
        }
    }

private:
    int res = 0;
};
// @lc code=end

