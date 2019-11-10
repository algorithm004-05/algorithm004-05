
// Copyright(c) 2019 Mobvoi Inc. All Rights Reserved.

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * @Author Shuangshuang Wang, <shshwang@mobvoi.com>
 * @Date 2019/11/2
 */
public class LeetCode_200_430 {
  /**
   * DFS
   */
  class Solution1 {
    public int numIslands(char[][] grid) {
      if (grid.length == 0 || grid[0].length == 0) {
        return 0;
      }
      int row = grid.length;
      int col = grid[0].length;
      int c = 0;
      for (int i = 0; i < row; i++) {
        for (int j = 0; j < col; j++) {
          // 对第一个未访问过的点进行操作
          if (grid[i][j] == '1') {
            c++;
            DFS(grid, i, j);
          }
        }
      }
      return c;
    }

    private void DFS(char[][] grid, int i, int j) {
      int[] dx = new int[] { -1, 1, 0, 0 };
      int[] dy = new int[] { 0, 0, -1, 1 };
      int row = grid.length;
      int col = grid[0].length;
      // visited终止条件
      if (i < 0 || i >= row || j < 0 || j >= col || grid[i][j] == '0') {
        return;
      }
      // vistied=true
      grid[i][j] = '0';
      for (int k = 0; k < 4; k++) {
        int x = i + dx[k];
        int y = j + dy[k];
        DFS(grid, x, y);
      }
    }
  }

  /**
   * BFS
   */
  class Solution2 {
    public int numIslands(char[][] grid) {
      if (grid.length == 0 || grid[0].length == 0) {
        return 0;
      }
      int row = grid.length;
      int col = grid[0].length;
      int c = 0;
      Queue<Integer> queue = new ArrayDeque<>(row * col);
      for (int i = 0; i < row; i++) {
        for (int j = 0; j < col; j++) {
          if (grid[i][j] == '1') {
            c++;
            BFS(grid, queue, i, j);
          }
        }
      }
      return c;
    }

    private void BFS(char[][] grid, Queue<Integer> queue, int a, int b) {
      int col = grid[0].length;
      int row = grid.length;
      int[] dx = new int[] { -1, 1, 0, 0 };
      int[] dy = new int[] { 0, 0, -1, 1 };
      // 压入第一个值
      queue.offer(a * col + b);
      // 提前设置visited
      grid[a][b] = '0';
      while (!queue.isEmpty()) {
        int index = queue.poll();
        for (int i = 0; i < 4; i++) {
          int x = index / col + dx[i];
          int y = index % col + dy[i];
          // visited不存在，压入子级
          if (x >= 0 && x < row && y >= 0 && y < col && grid[x][y] == '1') {
            queue.offer(x * col + y);
            // 循环内部及时更新visited
            grid[x][y] = '0';
          }
        }
      }
    }
  }
}
