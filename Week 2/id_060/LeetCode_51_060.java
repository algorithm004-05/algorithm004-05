/*
  51 52
  The n-queens puzzle is the problem of placing n queens
  on an n×n chessboard such that no two queens attack each other.

  Given an integer n, return all distinct solutions to the n-queens puzzle.

  Each solution contains a distinct board configuration of the n-queens' placement,
  where 'Q' and '.' both indicate a queen and an empty space respectively.

  Example:
    Input: 4
    Output:
      [
        [".Q..",  // Solution 1
        "...Q",
        "Q...",
        "..Q."],

        ["..Q.",  // Solution 2
        "Q...",
        "...Q",
        ".Q.."]
      ]

  Explanation:
    There exist two distinct solutions to the 4-queens puzzle as shown above.
*/

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class NQueens {

  private String[] board = null;
  private boolean[] queenPosition = null;
  private boolean[] positive = null;
  private boolean[] negative = null;
  private List<List<String>> res0 = new ArrayList<>();

  public List<List<String>> solveNQueens0(int n) {
    board = new String[n];
    queenPosition = new boolean[n];
    positive = new boolean[2 * n];
    negative = new boolean[2 * n];
    helper(0);
    return res0;
  }

  private void helper(int row) {

    if (row == board.length) {
      System.out.println(Arrays.asList(board));
      res0.add(Arrays.asList(board.clone())); // Recursion terminated
    } else {
      for (int columnIndex = 0; columnIndex < queenPosition.length; columnIndex++) {
        int positiveIndex = row + columnIndex;
        int negativeIndex = row - columnIndex + board.length - 1;

        if (!queenPosition[columnIndex] && !positive[positiveIndex] && !negative[negativeIndex]) {

          // Update board
          char[] state = new char[board.length];
          Arrays.fill(state, '.');
          state[columnIndex] = 'Q';
          board[row] = new String(state);

          // Update constrain
          queenPosition[columnIndex] = true;
          positive[positiveIndex] = true;
          negative[negativeIndex] = true;

          helper(row + 1);

          // Unset condition to trace back
          queenPosition[columnIndex] = false;
          positive[positiveIndex] = false;
          negative[negativeIndex] = false;
        }
      }
    }
  }

  private boolean[] columns = null;
  private boolean[] left = null;
  private boolean[] right = null;
  private List<List<String>> res1 = new ArrayList<>();

  public List<List<String>> solveNQueens1(int n) {
    columns = new boolean[n];
    left = new boolean[2 * n - 1];
    right = new boolean[2 * n - 1];
    char[][] board = new char[n][n];
    helper(board, 0);
    return res1;
  }

  private void helper(char[][] board, int row) {
    if (row >= board.length) {
      List<String> list = new ArrayList<>();
      for (char[] chars : board) {
        list.add(new String(chars));
      }
      res1.add(list);
      return;
    }

    Arrays.fill(board[row], '.');

    for (int column = 0; column < board[0].length; column++) {
      if (!columns[column] && !left[row + column] && !right[row - column + board.length - 1]) {
        board[row][column] = 'Q';
        columns[column] = true;
        left[row + column] = true;
        right[row - column + board.length - 1] = true;

        helper(board, row + 1);

        board[row][column] = '.';
        columns[column] = false;
        left[row + column] = false;
        right[row - column + board.length - 1] = false;
      }
    }
  }

  private int count = 0;

  public int totalNQueens(int n) {
    if (n < 1) {
      return 0;
    }
    helper(0, 0, 0, 0, n);
    return count;
  }

  private void helper(int row, int column, int left, int right, int n) {
    if (row >= n) {
      count++;
      return;
    }

    int bit = (~(column | left | right))  // ~(column | left | right) 获取当前空位 标识为1
              & ((1 << n) - 1);           // (1 << n) - 1 与操作去掉所有高位

    while (bit > 0) {                     // 遍历所有空位
      int position = bit & -bit;          // bit & -bit 获取最后的空位 1

                                          // column | position 表示 position 位被占用
                                          // (left | position ) << 1 表示 left 往斜左方移一位 被占用
                                          // (right | position) >> 1 表示 right 往斜右方移一位 被占用
      helper(row + 1, column | position, (left | position) << 1, (right | position) >> 1, n);

      bit &= (bit - 1);                   // 打掉最后的 1 去除占用的位置
    }
  }
}
