import java.util.*;
/**
 * https://leetcode-cn.com/problems/n-queens/
 */
public class LeetCode_51_100 {
    

    //自上向下搜索，首先不能同列，在是不能同对角线
    //利用属性记录列，以及主副对角线Quee状态
    private boolean[] colQ;
    // 主对角线 i - j = (i + 1) - (j + 1)
    private boolean[] masterQ;
    // 副对角线 i + j = (i + 1) + (j - 1)
    private boolean[] slaveQ;
    private int n;

    public List<List<String>> solveNQueens(int n) {
        this.n = n;
        colQ = new boolean[n];
        masterQ = new boolean[2*n];
        slaveQ = new boolean[2*n - 1];
        List<List<String>> ans = new ArrayList<>();
        char[][] board = new char[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = '.';
            }
        }
        backtrack(board, 0, ans);
        return ans;
    }

    private void backtrack(char[][] board, int row, List<List<String>> ans) {
        if (row == n) {
            fillAns(board, ans);
            return;
        }
        for (int col = 0; col < n; col++) {
            if (validate(row, col)) {
                placeQ(row, col, board);
                backtrack(board, row + 1, ans);
                removeQ(row, col, board);
            }
        }
    }


    private void fillAns(char[][] board, List<List<String>> ans) {
        List<String> list = new ArrayList<>();
        for (int i = 0; i < board.length; i++) {
            StringBuilder row = new StringBuilder();
            for (int j = 0; j < n; j++) {
                row.append(board[i][j]);
            }
            list.add(row.toString());
        }
        ans.add(list);
    } 

    private boolean validate(int row, int col) {
        return !colQ[col] && !masterQ[row - col + n] && !slaveQ[row + col];
    }

    private void placeQ(int row, int col, char[][] board) {
        colQ[col] = true;
        masterQ[row - col + n]  = true;
        slaveQ[row + col] = true;
        board[row][col] = 'Q';
    }

    private void removeQ(int row, int col, char[][] board) {
        colQ[col] = false;
        masterQ[row - col + n]  = false;
        slaveQ[row + col] = false;
        board[row][col] = '.';
    }
}