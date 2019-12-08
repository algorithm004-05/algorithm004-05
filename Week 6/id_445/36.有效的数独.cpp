/*
 * @lc app=leetcode.cn id=36 lang=cpp
 *
 * [36] 有效的数独
 */
#include <vector>
#include <map>

using namespace std;
// @lc code=start
class Solution {
public:
    bool isValidSudoku(vector<vector<char>>& board) {
        map<char,int> rows[9];
        map<char,int> cols[9];
        map<char,int> grid[9];
        for (int i = 0; i < board.size(); i++)
        {
            for(int j=0;j<board[i].size();j++){
                if(board[i][j]!='.'){
                    int boxIndex=(i/3)*3+j/3;

                   if( rows[i].count(board[i][j])>0 || cols[j].count(board[i][j])>0 || grid[boxIndex].count(board[i][j])>0) return false;
                   rows[i][board[i][j]]=j;
                   cols[j][board[i][j]]=i;
                   grid[boxIndex][board[i][j]]=i/3+j/3;
                   
                }
            }
        }
        return true;
        
        
    }
};
// @lc code=end

