class Solution {
public:
    void solveSudoku(vector<vector<char>>& board) {
        if (board.size() == 0) {
            return ;
        }
        doSolve(board, 0, 0);
    }

    bool doSolve(vector<vector<char>> &board, int i, int j)
    {
        if (i == 9)
            return true;
        if (j == 9)
            return doSolve(board, i+1, 0);
        if (board[i][j] != '.')
            return doSolve(board, i, j+1);

        for (char c = '1'; c <= '9'; c++) {
            if (isValid(board, i, j, c)) {
                board[i][j] = c;
                if (doSolve(board, i, j+1))
                    return true;
                board[i][j] = '.';
            }
        }
        return false;
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
