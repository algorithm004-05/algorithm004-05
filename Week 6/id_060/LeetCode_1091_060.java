/*
  1091
  In an N by N square grid, each cell is either empty (0) or blocked (1).

  A clear path from top-left to bottom-right has length k
  if and only if it is composed of cells C_1, C_2, ..., C_k such that:

  Adjacent cells C_i and C_{i+1} are connected 8-directionally
  (ie., they are different and share an edge or corner)

  C_1 is at location (0, 0) (ie. has value grid[0][0])
  C_k is at location (N-1, N-1) (ie. has value grid[N-1][N-1])

  If C_i is located at (r, c), then grid[r][c] is empty (ie. grid[r][c] == 0).

  Return the length of the shortest such clear path from top-left to bottom-right. 
  If such a path does not exist, return -1.

  Example 1:
    Input: [[0,1],[1,0]]
    Output: 2

  Example 2:
    Input: [[0,0,0],[1,1,0],[1,1,0]]
    Output: 4

  Note:
    1 <= grid.length == grid[0].length <= 100
    grid[r][c] is 0 or 1
*/

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ShortestPathInBinaryMatrix {

  // BFS
  public int shortestPathBinaryMatrix0(int[][] grid) {
    int rows = grid.length;
    int columns = grid[0].length;

    if (grid[0][0] == 1 || grid[rows - 1][columns - 1] == 1) {
      return -1;
    }

    int result = 0;
    int[][] directions = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}, {-1, -1}, {-1, 1}, {1, -1}, {1, 1}};
    boolean[][] visited = new boolean[rows][columns];
    Deque<int[]> queue = new ArrayDeque<>();
    visited[0][0] = true;
    queue.addLast(new int[]{0, 0});

    while (!queue.isEmpty()) {
      int size = queue.size();

      while (size-- > 0) {
        int[] currentCell = queue.removeFirst();
        if (currentCell[0] == rows - 1 && currentCell[1] == columns - 1) {
          return ++result;
        }
        for (int[] direction : directions) {
          int newRow = currentCell[0] + direction[0];
          int newColumn = currentCell[1] + direction[1];
          if (newRow < 0 || newColumn < 0 || newRow >= rows || newColumn >= columns || visited[newRow][newColumn] || grid[newRow][newColumn] != 0) {
            continue;
          }
          queue.addLast(new int[]{newRow, newColumn});
          visited[newRow][newColumn] = true;
        }
      }

      result++;
    }

    return -1;
  }

  //DOUBLE BFS
  public int shortestPathBinaryMatrix1(int[][] grid) {
    if (grid.length == 0 || grid == null) {
      return -1;
    }

    if (grid.length == 1) {
      return grid[0][0] == 0 ? 1 : -1;
    }

    int rows = grid.length;
    int columns = grid[0].length;

    if (grid[0][0] == 1 || grid[rows - 1][columns - 1] == 1) {
      return -1;
    }

    int[][] directions = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}, {-1, -1}, {-1, 1}, {1, -1}, {1, 1}};

    Set<Integer> beginSet = new HashSet<Integer>() {{add(0 * columns + 0);}};
    Set<Integer> endSet = new HashSet<Integer>(){{add((rows - 1) * columns + (columns - 1));}};
    Set<Integer> visited = new HashSet<Integer>() {{add(0 * columns + 0); add((rows - 1) * columns + (columns - 1));}};

    int result = 0;

    while (!beginSet.isEmpty() && !endSet.isEmpty()) {

      if (beginSet.size() > endSet.size()) {
        Set<Integer> temp = new HashSet<>();
        temp = beginSet;
        beginSet = endSet;
        endSet = temp;
      }

      Set<Integer> temp = new HashSet<>();

      for (int currentCell : beginSet) {
        int row = currentCell / columns;
        int column = currentCell % columns;

        for (int[] direction : directions) {
          int newRow = row + direction[0];
          int newColumn = column + direction[1];

          if (newRow < 0 || newColumn < 0 || newRow >= rows || newColumn >= columns || grid[newRow][newColumn] != 0) {
            continue;
          }

          if (endSet.contains(newRow * columns + newColumn)) {
            return ++result;
          }

          if (visited.contains(newRow * columns + newColumn)) {
            continue;
          }

          temp.add(newRow * columns + newColumn);
          visited.add(newRow * columns + newColumn);
        }
      }

      beginSet = temp;
      result++;
    }

    return -1;
  }

  // ANOTHER DOUBLE BFS
  public int shortestPathBinaryMatrix(int[][] grid) {
    if (grid.length == 0 || grid == null) {
      return -1;
    }

    if (grid.length == 1) {
      return grid[0][0] == 0 ? 1 : -1;
    }

    int rows = grid.length;
    int columns = grid[0].length;

    if (grid[0][0] == 1 || grid[rows - 1][columns - 1] == 1) {
      return -1;
    }

    int[][] directions = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}, {-1, -1}, {-1, 1}, {1, -1}, {1, 1}};

    List<int[]> beginStartCell = new ArrayList<>();
    List<int[]> endStartCell = new ArrayList<>();
    beginStartCell.add(new int[]{0, 0});
    endStartCell.add(new int[]{rows - 1, columns - 1});

    boolean[][] visited = new boolean[rows][columns];
    visited[0][0] = true;
    visited[rows - 1][columns - 1] = true;

    boolean[][] beginStartCellVisited = new boolean[rows][columns];
    boolean[][] endStartCellVisited = new boolean[rows][columns];
    beginStartCellVisited[0][0] = true;
    endStartCellVisited[rows - 1][columns - 1] = true;

    int result = 1;

    while (!beginStartCell.isEmpty() && !endStartCell.isEmpty()) {

      if (beginStartCell.size() > endStartCell.size()) {
        List<int[]> tempCells = beginStartCell;
        beginStartCell = endStartCell;
        endStartCell = tempCells;

        boolean[][] tempVisited = beginStartCellVisited;
        beginStartCellVisited = endStartCellVisited;
        endStartCellVisited = tempVisited;
      }

      List<int[]> tempCells = new ArrayList<>();

      for (int[] cell : beginStartCell) {
        for (int[] direction : directions) {
          int newRow = cell[0] + direction[0];
          int newColumn = cell[1] + direction[1];
          if (newRow < 0 || newColumn < 0 || newRow >= rows || newColumn >= columns || grid[newRow][newColumn] != 0) {
            continue;
          }

          if (endStartCellVisited[newRow][newColumn]) {
            return ++result;
          }

          if (visited[newRow][newColumn]) {
            continue;
          }

          tempCells.add(new int[]{newRow, newColumn});
          visited[newRow][newColumn] = true;
          beginStartCellVisited[newRow][newColumn] = true;
        }
      }

      beginStartCell = tempCells;
      result++;
    }
    return -1;
  }


  // TODO : A *
}
