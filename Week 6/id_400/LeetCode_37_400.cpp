class Solution {
public:
    void solveSudoku(vector<vector<char>>& board) {
        if (board.size() == 0) {
            return ;
        }
        doSolve(board);
    }

    bool doSolve(vector<vector<char>>& board)
    {
        for (int i = 0; i < board.size(); i++){
            for (int j = 0; j < board[0].size(); j++) {
                if (board[i][j] == '.'){
                    for (char k = '1'; k <= '9'; k++) {
                        if (isValid(board, i, j, k)) {
                            board[i][j] = k;
                            if(doSolve(board))
                                return true;
                            board[i][j] = '.';
                        }
                    }
                    return false;
                }
            }
        }
        return true;
    }

    bool isValid(vector<vector<char>>& board, int row, int col, char c)
    {
        for (int i = 0; i < 9; i++) {
            if (board[i][col] != '.' && board[i][col] == c) {
                return false;
            }
            if (board[row][i] != '.' && board[row][i] == c) {
                return false;
            }
            int row_index = 3 * (row / 3) + i / 3;
            int col_index = 3 * (col / 3) + i % 3;
            if (board[row_index][col_index] != '.' && board[row_index][col_index] == c) {
                return false;
            }
        }
        return true;
    }
};
