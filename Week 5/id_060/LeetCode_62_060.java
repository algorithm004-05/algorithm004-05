/*
  62
  A robot is located at the top-left corner of a m x n grid (marked 'Start' in the diagram below).

  The robot can only move either down or right at any point in time.
  The robot is trying to reach the bottom-right corner of the grid
  (marked 'Finish' in the diagram below).

  How many possible unique paths are there?

  Above is a 7 x 3 grid. How many possible unique paths are there?

  Note: m and n will be at most 100.

  Example 1:
    Input: m = 3, n = 2
    Output: 3

  Explanation:
    From the top-left corner, there are a total of 3 ways to reach the bottom-right corner:
    1. Right -> Right -> Down
    2. Right -> Down -> Right
    3. Down -> Right -> Right

  Example 2:
    Input: m = 7, n = 3
    Output: 28
*/

import java.util.Arrays;

public class UniquePaths {

  public int uniquePaths0(int m, int n) {
    return uniquePaths0Helper(m - 1, n - 1);
  }

  private int uniquePaths0Helper(int x, int y) {
    if (x < 0 || y < 0) {
      return 0;
    }

    if (x == 0 | y == 0) {
      return 1;
    }

    return uniquePaths0Helper(x - 1, y) + uniquePaths0Helper(x, y - 1);
  }

  public int uniquePaths1(int m, int n) {
    int[][] DP = new int[m][n];
    return uniquePaths1Helper(m - 1, n - 1, DP);
  }

  private int uniquePaths1Helper(int x, int y, int[][] DP) {
    if (x < 0 || y < 0) {
      return 0;
    }

    if (y == 0 || x == 0) {
      return 1;
    }

    if (DP[x][y] != 0) {
      return DP[x][y];
    }

    return uniquePaths1Helper(x - 1, y, DP) + uniquePaths1Helper(x, y - 1, DP);
  }

  public int uniquePaths2(int m, int n) {
    int[][] DP = new int[m][n];

    for (int i = m - 1; i > 0; i--) {
      for (int j = n - 1; j > 0; j--) {
        if (i == (m - 1) || j == (n - 1)) {
          DP[i][j] = 1;
        } else {
          DP[i][j] = DP[i + 1][j] + DP[i][j + 1];
        }
      }
    }

    return DP[0][0];
  }

  public int uniquePaths3(int m, int n) {
    int[][] DP = new int[m][n];

    for (int i = 0; i < m; i++) {
      for (int j = 0; j < n; j++) {
        if (i == 0 || j == 0) {
          DP[i][j] = 1;
        } else {
          DP[i][j] = DP[i - 1][j] + DP[i][j - 1];
        }
      }
    }

    return DP[m - 1][n - 1];
  }

  public int uniquePaths4(int m, int n) {
    if (m == 0 || n == 0) {
      return 0;
    }
    if (m == 1 || n == 1) {
      return 1;
    }

    int[] DP = new int[n];

    Arrays.fill(DP, 1);

    for (int i = 1; i < m; i++) {
      for (int j = 1; j < n; j++) {
        DP[j] = DP[j] + DP[j - 1];
      }
    }

    return DP[n - 1];
  }
}
