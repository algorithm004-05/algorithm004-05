/*
  130
  Given a 2D board containing 'X' and 'O' (the letter O), capture all regions surrounded by 'X'.

  A region is captured by flipping all 'O's into 'X's in that surrounded region.

  Example:
    X X X X
    X O O X
    X X O X
    X O X X

  After running your function, the board should be:
    X X X X
    X X X X
    X X X X
    X O X X

  Explanation:
    Surrounded regions shouldn’t be on the border,
    which means that any 'O' on the border of the board are not flipped to 'X'.

    Any 'O' that is not on the border and it is not connected to an 'O' on the border
    will be flipped to 'X'.

    Two cells are connected if they are adjacent cells connected horizontally or vertically.
*/

import java.util.ArrayDeque;
import java.util.Deque;

public class SurroundedRegions {

  public void solve0(char[][] board) {

    if (board == null || board.length == 0 || board[0] == null || board[0].length == 0) {
      return;
    }

    int rows = board.length, columns = board[0].length;
    int[][] directions = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    for (int column = 0; column < columns; column++) {
      if (board[0][column] == 'O') {
        solve0Helper(0, column, rows, columns, board, directions);
      }

      if (board[rows - 1][column] == 'O') {
        solve0Helper(rows - 1, column, rows, columns, board, directions);
      }
    }

    for (int row = 0; row < rows; row++) {
      if (board[row][0] == 'O') {
        solve0Helper(row, 0, rows, columns, board, directions);
      }

      if (board[row][columns - 1] == 'O') {
        solve0Helper(row, columns - 1, rows, columns, board, directions);
      }
    }

    for (int row = 0; row < rows; row++) {
      for (int column = 0; column < columns; column++) {
        // ORDER of these TWO IF statements is essential
        // In case: 'B' --> 'O' --> 'X'
        if (board[row][column] == 'O') {
          board[row][column] = 'X';
        }

        if (board[row][column] == 'B') {
          board[row][column] = 'O';
        }
      }
    }

  }

  // DFS
  private void solve0Helper(int baseRow, int baseColumn, int rows, int columns, char[][] board, int[][] directions) {
    board[baseRow][baseColumn] = 'B';

    for (int[] direction : directions) {
      int newRow = baseRow + direction[0];
      int newColumn = baseColumn + direction[1];
      if (newRow < 0 || newRow >= rows || newColumn < 0 || newColumn >= columns
          || board[newRow][newColumn] != 'O') {
        continue;
      }
      solve0Helper(newRow, newColumn, rows, columns, board, directions);
    }
  }

  public void solve(char[][] board) {
    if (board == null || board.length == 0 || board[0] == null || board[0].length == 0) {
      return;
    }

    int rows = board.length, columns = board[0].length;
    int[][] directions = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    for (int column = 0; column < columns; column++) {
      if (board[0][column] == 'O') {
        solve1Helper(0, column, rows, columns, board, directions);
      }

      if (board[rows - 1][column] == 'O') {
        solve1Helper(rows - 1, column, rows, columns, board, directions);
      }
    }

    for (int row = 0; row < rows; row++) {
      if (board[row][0] == 'O') {
        solve1Helper(row, 0, rows, columns, board, directions);
      }

      if (board[row][columns - 1] == 'O') {
        solve1Helper(row, columns - 1, rows, columns, board, directions);
      }
    }

    for (int row = 0; row < rows; row++) {
      for (int column = 0; column < columns; column++) {
        if (board[row][column] == 'O') {
          board[row][column] = 'X';
        }

        if (board[row][column] == 'B') {
          board[row][column] = 'O';
        }
      }
    }

  }

  // BFS
  private void solve1Helper(int row, int column, int rows, int columns, char[][] board, int[][] directions) {
    Deque<Integer> queue = new ArrayDeque<>();
    queue.addLast(row * columns + column);
    while (!queue.isEmpty()) {
      int temp = queue.removeFirst();
      int baseRow = temp / columns;
      int baseColumn = temp % columns;
      if (baseRow >= 0 && baseRow < rows && baseColumn >= 0 && baseColumn < columns && board[baseRow][baseColumn] == 'O') {
        board[baseRow][baseColumn] = 'B';
        for (int[] direction : directions) {
          queue.addLast((baseRow + direction[0]) * columns + (baseColumn + direction[1]));
        }
      }
    }
  }

  // Union Find
  public void solve2(char[][] board) {
    if (board == null || board.length == 0 || board[0] == null || board[0].length == 0) {
      return;
    }

    int rows = board.length, columns = board[0].length;
    int[][] directions = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0,1}};

    QuickUnionFindSecond unionFind = new QuickUnionFindSecond(rows * columns + 1);

    for (int row = 0; row < rows; row++) {
      for (int column = 0; column < columns; column++) {

        if (board[row][column] == 'O') {

          if (row == 0 || row == rows - 1 || column == 0 || column == columns - 1) {
            unionFind.union(row * columns + column, rows * columns);
          } else {
            for (int[] direction : directions) {
              int newRow = row + direction[0];
              int newColumn = column + direction[1];
              if (newRow >= 0 && newRow < rows && newColumn >= 0 && newColumn < columns && board[newRow][newColumn] == 'O') {
                unionFind.union(newRow * columns + newColumn, row * columns + column);
              }
            }
          }

        }

      }
    }

    for (int row = 0; row < rows; row++) {
      for (int column = 0; column < columns; column++) {
        if (board[row][column] == 'O' && !unionFind.connected(row * columns + column, rows * columns)) {
          board[row][column] = 'X';
        }
      }
    }
  }
}
