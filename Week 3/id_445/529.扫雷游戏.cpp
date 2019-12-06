/*
 * @lc app=leetcode.cn id=529 lang=cpp
 *
 * [529] 扫雷游戏
 */
#include <vector>
#include <queue>
using namespace std;
// @lc code=start
class Solution
{
private:
    // void dfs(vector<vector<char>> &board, int row, int col, vector<vector<char>> &res)
    // {
    //     int count = 0;
    //     if (board[row][col] == 'M')
    //     {
    //     }
    //     if (row + 1 < rows && board[row + 1][col] == 'M')
    //         ++count;
    //     if (row - 1 >= 0 && board[row - 1][col] == 'M')
    //         ++count;
    //     if (col + 1 < cols && board[row][col + 1 == 'M'])
    //         ++count;
    //     if (col - 1 >= 0 && board[row][col - 1] == 'M')
    //         ++count;
    //     if (row + 1 < rows && col + 1 < cols && board[row + 1][col + 1] == 'M')
    //         ++count;
    //     if (row + 1 < rows && col - 1 >= 0 && board[row + 1])
    // }
    void updateEmptySquareBFS(vector<vector<char>> &board, vector<int> &click)
    {
        queue<vector<int>> q;
        vector<vector<int>> visited(board.size(), vector<int>(board[0].size(), 0));
        q.push(click);
        while (!q.empty())
        {
            vector<int> pos = q.front();
            q.pop();
            int mineNum = 0;
            vector<vector<int>> around;
            if (!visited[pos[0]][pos[1]])
            {
                for (int i = pos[0] - 1; i < pos[0] + 2; i++)
                {
                    if (i < 0 || i >= board.size())
                        continue;
                    for (int j = pos[1] - 1; j < pos[1] + 2; j++)
                    {
                        if (j < 0 || j >= board[0].size())
                            continue;
                        if (board[i][j] == 'M')
                        {
                            mineNum++;
                        }
                        else if (board[i][j] == 'E' && !visited[i][j])
                        {
                            around.push_back(vector<int>{i, j});
                        }
                    }
                }
                if (mineNum == 0)
                {
                    board[pos[0]][pos[1]] = 'B';
                    for (auto &val : around)
                        q.push(val);
                }
                else
                    board[pos[0]][pos[1]] = '0' + mineNum;
                visited[pos[0]][pos[1]] = 1;
            }
        }
    }

public:
    vector<vector<char>> updateBoard(vector<vector<char>> &board, vector<int> &click)
    {

        if (board[click[0]][click[1]] == 'M')
        {

            board[click[0]][click[1]] = 'X';
            return board;
        }
        updateEmptySquareBFS(board, click);
        return board;
    }
};
// @lc code=end
