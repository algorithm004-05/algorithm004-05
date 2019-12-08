/*
 * @lc app=leetcode.cn id=36 lang=java
 *
 * [36] 有效的数独
 */

// @lc code=start
class Solution {

    public boolean isValidSudoku(char[][] board) {
        byte[][] hash = new byte[27][9]; 
        int v;
        for(int i = 0; i < 9; ++i) {
            for(int j = 0; j < 9; ++j) {
                if(board[i][j] == '.') {
                    continue;
                }else{
                    v = board[i][j]-49; 
                    if(hash[i][v] == 1 || hash[9+j][v] == 1 || hash[18+i/3*3+j/3][v] == 1){
                        return false;
                    }else{
                        hash[i][v] = 1;
                        hash[9+j][v] = 1;
                        hash[18+i/3*3+j/3][v] = 1;
                    }
                }
            }
        }
        return true;
    }
}
// @lc code=end

