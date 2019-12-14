/*
  200
  Given a 2d grid map of '1's (land) and '0's (water), count the number of islands.

  An island is surrounded by water and is formed
  by connecting adjacent lands horizontally or vertically.

  You may assume all four edges of the grid are all surrounded by water.

  Example 1:
    Input:
      11110
      11010
      11000
      00000
    Output: 
      1

  Example 2:
    Input:
      11000
      11000
      00100
      00011
    Output:
      3
*/

import java.util.ArrayDeque;
import java.util.Deque;

public class NumberOfIslands {

  public int numIslands0(char[][] grid) {
    int count = 0;
    for (int row = 0; row < grid.length; ++row) {
      for (int column = 0; column < grid[0].length; ++column) {
        if (grid[row][column] == '1') {
          ++count;
          numIslands0Helper(grid, row, column);
        }
      }
    }
    return count;
  }

  // DFS
  private void numIslands0Helper(char[][] grid, int i, int j) {
    if (i < 0 || j < 0 || i >= grid.length || j >= grid[0].length || grid[i][j] == '0') {
      return;
    }

    grid[i][j] = '0';
    numIslands0Helper(grid, i - 1, j);
    numIslands0Helper(grid, i + 1, j);
    numIslands0Helper(grid, i, j - 1);
    numIslands0Helper(grid, i, j + 1);
  }


  public int numIslands1(char[][] grid) {
    if (grid == null || grid.length == 0) {
      return 0;
    }

    int res = 0, rows = grid.length, columns = grid[0].length;
    boolean[][] visited = new boolean[rows][columns];
    int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    for (int row = 0; row < rows; row++) {
      for (int column = 0; column < columns; column++) {
        if (grid[row][column] == '1' && !visited[row][column]) {
          res++;
          numIslnds1Helper(grid, row, column, rows, columns, directions, visited);
        }
      }
    }

    return res;
  }

  // DFS
  private void numIslnds1Helper(char[][] grid, int baseRow, int baseColumn, int rows, int columns, int[][] directions, boolean[][] visited) {
    for (int[] direction : directions) {
      int newRow = baseRow + direction[0];
      int newColumn = baseColumn + direction[1];
      if (newRow >= 0 && newColumn >= 0 && newRow < rows && newColumn < columns && grid[newRow][newColumn] == '1' && !visited[newRow][newColumn]) {
        visited[newRow][newColumn] = true;
        numIslnds1Helper(grid, newRow, newColumn, rows, columns, directions, visited);
      }
    }
  }

  // BFS
  public int numIslands2(char[][] grid) {
    if (grid == null || grid.length == 0) {
      return 0;
    }

    int result = 0, rows = grid.length, columns = grid[0].length;
    boolean[][] visited = new boolean[rows][columns];
    int[][] directions = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    for (int row = 0; row < rows; row++) {
      for (int column = 0; column < columns; column++) {
        if (grid[row][column] == '1' && !visited[row][column]) {
          Deque<Integer> queue = new ArrayDeque<>();
          visited[row][column] = true;

          // queue.add(row + column* rows );
          queue.addLast(row * columns + column);

          while (!queue.isEmpty()) {
            int current = queue.removeFirst();

            // int baseRow = current % rows;
            int baseRow = current / columns;

            //int baseColumn = current / rows;
            int baseColumn = current % columns;

            for (int[] direction : directions) {
              int newRow = baseRow + direction[0];
              int newColumn = baseColumn + direction[1];

              if (newRow < 0 || newRow >= rows || newColumn < 0 || newColumn >= columns) {
                continue;
              }

              if (grid[newRow][newColumn] == '1' && !visited[newRow][newColumn]) {
                // queue.add(newRow + newColumn * rows);
                queue.addLast(newRow * columns + newColumn);
                visited[newRow][newColumn] = true;
              }
            }
          }

          result += 1;
        }
      }
    }
    return result;
  }

  // Union Find
  public int numIslands3(char[][] grid) {
    if (grid == null || grid.length == 0) {
      return 0;
    }

    int rows = grid.length;
    int columns = grid[0].length;

    int[][] directions = {{0, 1}, {1, 0}};

    QuickUnionFindSecond unionFind = new QuickUnionFindSecond(rows * columns + 1);

    for (int row = 0; row < rows; row++) {
      for (int column = 0; column < columns; column++) {
        if (grid[row][column] == '0') {
          unionFind.union(rows * columns, row * columns + column);
        }
        if (grid[row][column] == '1') {
          for (int[] direction : directions) {
            int newRow = row + direction[0];
            int newColumn = column + direction[1];
            if (newRow >= 0 && newColumn >= 0 && newRow < rows && newColumn < columns && grid[newRow][newColumn] == '1') {
              unionFind.union((row * columns + column), (newRow * columns + newColumn));
            }
          }
        }
      }
    }

    return unionFind.getCount() - 1;
  }
}
