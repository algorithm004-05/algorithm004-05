/*
 * @lc app=leetcode.cn id=37 lang=cpp
 *
 * [37] 解数独
 */
#include <vector>
#include <iostream>
using namespace std;
// @lc code=start
class Solution {
    bool help(vector<vector<char>>& board,vector<vector<bool>> &rows,vector<vector<bool>> &cols,vector<vector<vector<bool>>> &boxes,int row,int col){
        if(col==board[0].size()){
            col=0;
            row++;
            // for (int i = 0; i < board.size(); i++)
            // {
                
            //     for(int j=0;j<board.size();j++){
            //         cout <<board[i][j] << " ";
            //     }
            //     cout <<endl;
            // }
            
            if(row==board.size()) return true;
        }

        if(board[row][col]=='.'){
            for (int i = 1; i <= board.size(); i++)
            {
                bool canUsed=!( rows[row][i] || cols[col][i] || boxes[row/3][col/3][i] );
                if(canUsed){
                    rows[row][i] =true;
                    cols[col][i]=true;
                    boxes[row/3][col/3][i]=true;
                    board[row][col]='0'+i;
                    if(help(board,rows,cols,boxes,row,col+1))return true;
                    board[row][col]='.';
                    rows[row][i]=false;
                    cols[col][i]=false;
                    boxes[row/3][col/3][i]=false;
                }
            }
            
        }else
        {
            return help(board,rows,cols,boxes,row,col+1);
        }
        return false;
        
    }
public:
    void solveSudoku(vector<vector<char>>& board) {
        vector<vector<bool>> rows(9,vector<bool>(10,false));
        vector<vector<bool>> cols(9,vector<bool>(10,false));
        vector<vector<vector<bool>>> boxes(3,vector<vector<bool>>(3,vector<bool>(10,false)));
        for (int i = 0; i < board.size(); i++)
        {
            for(int j=0;j<board[i].size();j++){
                int num=board[i][j]-'0';
                if(1<=num && num<=9){
                    rows[i][num]=true;
                    cols[j][num]=true;
                    boxes[i/3][j/3][num]=true;
                }
            }
        }
        

        help(board,rows,cols,boxes,0,0);
        
    }
};
// @lc code=end

int main(){
    vector<vector<char>> board{{'5','3','.','.','7','.','.','.','.'},{'6','.','.','1','9','5','.','.','.'},{'.','9','8','.','.','.','.','6','.'},{'8','.','.','.','6','.','.','.','3'},{'4','.','.','8','.','3','.','.','1'},{'7','.','.','.','2','.','.','.','6'},{'.','6','.','.','.','.','2','8','.'},{'.','.','.','4','1','9','.','.','5'},{'.','.','.','.','8','.','.','7','9'}};
   Solution s;
   s.solveSudoku(board);
}