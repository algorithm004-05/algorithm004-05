/*
  529
  Let's play the minesweeper game (Wikipedia, online game)!

  You are given a 2D char matrix representing the game board.
    'M' represents an unrevealed mine,

    'E' represents an unrevealed empty square,

    'B' represents a revealed blank square that has no adjacent
    (above, below, left, right, and all 4 diagonals) mines,

    digit ('1' to '8') represents how many mines are adjacent
    to this revealed square, and finally 'X' represents a revealed mine.

  Now given the next click position (row and column indices) among all the unrevealed squares ('M' or 'E'),
  return the board after revealing this position according to the following rules:

  If a mine ('M') is revealed, then the game is over - change it to 'X'.
  If an empty square ('E') with no adjacent mines is revealed, then change it to revealed blank ('B') and all of its adjacent unrevealed squares should be revealed recursively.
  If an empty square ('E') with at least one adjacent mine is revealed, then change it to a digit ('1' to '8') representing the number of adjacent mines.

  Return the board when no more squares will be revealed.

  Example 1:
    Input:
    [['E', 'E', 'E', 'E', 'E'],
    ['E', 'E', 'M', 'E', 'E'],
    ['E', 'E', 'E', 'E', 'E'],
    ['E', 'E', 'E', 'E', 'E']]

    Click : [3,0]

    Output:

    [['B', '1', 'E', '1', 'B'],
    ['B', '1', 'M', '1', 'B'],
    ['B', '1', '1', '1', 'B'],
    ['B', 'B', 'B', 'B', 'B']]

  Example 2:
    Input:
    [['B', '1', 'E', '1', 'B'],
    ['B', '1', 'M', '1', 'B'],
    ['B', '1', '1', '1', 'B'],
    ['B', 'B', 'B', 'B', 'B']]

    Click : [1,2]

    Output:
    [['B', '1', 'E', '1', 'B'],
    ['B', '1', 'X', '1', 'B'],
    ['B', '1', '1', '1', 'B'],
    ['B', 'B', 'B', 'B', 'B']]

  Note:
    The range of the input matrix's height and width is [1,50].

    The click position will only be an unrevealed square ('M' or 'E'),
    which also means the input board contains at least one clickable square.

    The input board won't be a stage when game is over (some mines have been revealed).

    For simplicity, not mentioned rules should be ignored in this problem.

    For example, you don't need to reveal all the unrevealed mines when the game is over,
    consider any cases that you will win the game or flag any squares.
*/

import java.util.ArrayDeque;
import java.util.Deque;

public class Minesweeper {

  public char[][] updateBoard0(char[][] board, int[] click) {
    if (board.length == 0 || board[0].length == 0) {
      return board;
    }
    int rows = board.length, columns = board[0].length, x = click[0], y = click[1];

    if (board[x][y] == 'M') {
      board[x][y] = 'x';
    } else {
      int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}, {1, 1}, {-1, -1}, {1, -1}, {-1, 1}};
      DFS(board, x, y, rows, columns, directions);
    }
    return board;
  }

  private void DFS(char[][] board, int x, int y, int rows, int columns, int[][] directions) {
    if (x < 0 || x >= rows || y < 0 || y >= columns || board[x][y] != 'E') {
      return;
    }

    int mine = adjacentMine(board, x, y, rows, columns);

    if (mine > 0) {
      board[x][y] = (char) ('0' + mine);
    } else {
      board[x][y] = 'B';
      for (int[] direction : directions) {
        DFS(board, x + direction[0], y + direction[1], rows, columns, directions);
      }
    }
  }

  private int adjacentMine(char[][] board, int x, int y, int rows, int columns) {
    int count = 0;
    for (int newX = x - 1; newX <= x + 1; newX++) {
      for (int newY = y - 1; newY <= y + 1; newY++) {
        if (0 <= newX && newX < rows && 0 <= newY && newY < columns && board[newX][newY] == 'M') {
          count++;
        }
      }
    }
    return count;
  }

  // BFS
  public char[][] updateBoard1(char[][] board, int[] click) {
    int rows = board.length, columns = board[0].length;
    int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}, {1, 1}, {-1, -1}, {1, -1}, {-1, 1}};

    Deque<int[]> queue = new ArrayDeque<>();
    queue.addLast(click);

    if (board[click[0]][click[1]] == 'M') {
      board[click[0]][click[1]] = 'X';
      return board;
    }

    while (!queue.isEmpty()) {
      int[] currentCell = queue.removeFirst();

      int x = currentCell[0], y = currentCell[1], count = 0;

      for (int[] direction : directions) {
        int newX = x + direction[0], newY = y + direction[1];
        if (newX < 0 || newX >= rows || newY < 0 || newY >= columns) {
          continue;
        }
        if (board[newX][newY] == 'M') {
          count++;
        }
      }

      if (count > 0) {
        board[x][y] = (char) (count + '0');
      } else {
        board[x][y] = 'B';
        for (int[] direction : directions) {
          int newX = x + direction[0], newY = y + direction[1];
          if (newX < 0 || newX >= rows || newY < 0 || newY >= columns) {
            continue;
          }
          if (board[newX][newY] == 'E') {
            queue.addLast(new int[]{newX, newY});
            board[newX][newY] = 'B';
          }
        }
      }
    }

    return board;
  }
}
