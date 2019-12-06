/*
 * @lc app=leetcode.cn id=51 lang=cpp
 *
 * [51] N皇后
 */
#include <vector>
#include <string>
using namespace std;
// @lc code=start
class Solution
{
private:
    int *rows, *hills, *dales, *queens, n;
    vector<vector<string>> res;

public:
    vector<vector<string>> solveNQueens(int n)
    {
        
        this->n = n;
        queens = new int[n];
        rows = new int[n];
        dales = new int[2 * n - 1];
        hills = new int[4 * n - 1];
        for (int i = 0; i < n; i++){
            queens[i]=0;
            rows[i]=0;

        }
        for (int i = 0; i < 2 * n - 1; i++)
        {
            dales[i]=0;
        }
        for (int i = 0; i < 4 * n - 1; i++)
        {
            hills[i]=0;
        }
        
        
        
        backtrack(0);

        return res;
    }
    void backtrack(int row)
    {
        for (int i = 0; i < n; i++)
        {
            if (isNotUnderAttack(row, i))
            {
                placeQueen(row, i);
                if (row + 1 == n)
                    addSolution();
                else
                    backtrack(row + 1);
                removeQueen(row, i);
            }
        }
    }
    bool isNotUnderAttack(int row, int col)
    {
        int res = rows[col] + hills[row - col + 2 * n] + dales[row + col];
        return (res == 0)?true:false;
    }
    void placeQueen(int row, int col)
    {
        queens[row] = col;
        rows[col] = 1;
        hills[row - col + 2 * n] = 1;
        dales[row + col] = 1;
    }
    void removeQueen(int row, int col)
    {
        queens[row] = 0;
        rows[col] = 0;
        hills[row - col + 2 * n] = 0;
        dales[row + col] = 0;
    }
    void addSolution()
    {
        vector<string> solution;
        
        for (int i = 0; i < n; i++)
        {
            int col = queens[i];
            string str;
            for (int j = 0; j < col; ++j)
                str.push_back('.');
            str .push_back('Q');
            for (int j = 0; j < n - col - 1; ++j)
                str.push_back('.');
            solution.push_back(str);
        }
        res.push_back(solution);
    }
};
// @lc code=end
