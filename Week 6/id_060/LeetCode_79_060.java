/*
  79
  Given a 2D board and a word, find if the word exists in the grid.

  The word can be constructed from letters of sequentially adjacent cell,
  where "adjacent" cells are those horizontally or vertically neighboring.

  The same letter cell may not be used more than once.

  Example:
    board =
      [
        ['A','B','C','E'],
        ['S','F','C','S'],
        ['A','D','E','E']
      ]

    Given word = "ABCCED", return true.
    Given word = "SEE", return true.
    Given word = "ABCB", return false.
*/

public class WordSearchFirst {

  private boolean[][] visited;
  private int[][] directions = {{-1, 0}, {0, -1}, {0 ,1}, {1 ,0}};

  private char[][] board;
  private int rows;
  private int columns;
  private String word;

  public boolean exist(char[][] board, String word) {
    if (board.length <= 0) {
      return false;
    }
    this.word = word;
    this.board = board;
    this.rows = board.length;
    this.columns = board[0].length;
    this.visited = new boolean[rows][columns];

    for (int row = 0; row < rows; row++) {
      for (int column = 0; column < columns; column++) {
        if (existHelper(row, column, 0)) {
          return true;
        }
      }
    }
    return false;
  }

  // DFS
  private boolean existHelper(int baseRow, int baseColumn, int index) {
    if (index >= word.length() - 1) {
      return board[baseRow][baseColumn] == word.charAt(index);
    }else if (board[baseRow][baseColumn] == word.charAt(index)) {
      visited[baseRow][baseColumn] = true;
      for (int[] direction : directions) {
        int newRow = baseRow + direction[0];
        int newColumn = baseColumn + direction[1];
        if (newRow >= 0 && newRow < rows && newColumn >= 0 && newColumn < columns && !visited[newRow][newColumn]) {
          if (existHelper(newRow, newColumn, index + 1)) {
            return true;
          }
        }
      }
      visited[baseRow][baseColumn] = false;
    }
    return false;
  }
}
