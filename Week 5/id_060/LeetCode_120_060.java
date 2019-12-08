/*
  120
  Given a triangle, find the minimum path sum from top to bottom. Each step you may move to adjacent numbers on the row below.

  For example, given the following triangle
    [
         [2],
        [3,4],
       [6,5,7],
      [4,1,8,3]
    ]
  The minimum path sum from top to bottom is 11 (i.e., 2 + 3 + 5 + 1 = 11).

  Note:
    Bonus point if you are able to do this using only O(n) extra space,
    where n is the total number of rows in the triangle.
*/

import java.util.List;

public class Triangle {

  public int minimumTotal0(List<List<Integer>> triangle) {
    if (triangle == null || triangle.size() == 0) {
      return 0;
    }

    int[][] DP = new int[triangle.size()][triangle.size()];

    List<Integer> bottom = triangle.get(triangle.size() - 1);
    for (int index = 0; index < bottom.size(); index++) {
      DP[triangle.size() - 1][index] = bottom.get(index);
    }

    for (int row = triangle.size() - 2; row >= 0; row--) {
      for (int column = 0; column < triangle.get(row).size(); column++) {
        DP[row][column] = Math.min(DP[row + 1][column], DP[row + 1][column + 1]) + triangle.get(row).get(column);
      }
    }

    return DP[0][0];
  }

  public int minimumTotal1(List<List<Integer>> triangle) {
    if (triangle == null || triangle.size() == 0) {
      return 0;
    }

    int[][] DP = new int[triangle.size() + 1][triangle.size() + 1];

    for (int row = triangle.size() - 1; row >= 0; row--) {
      List<Integer> current = triangle.get(row);
      for (int column = 0; column < triangle.get(row).size(); column++) {
        DP[row][column] = Math.min(DP[row + 1][column], DP[row + 1][column + 1]) + triangle.get(row).get(column);
      }
    }

    return DP[0][0];
  }

  public int minimumTotal2(List<List<Integer>> triangle) {
    if (triangle == null || triangle.size() == 0) {
      return 0;
    }

    int[] dp = new int[triangle.get(triangle.size() - 1).size() + 1];

    for (int row = triangle.size() - 1; row >= 0; row--) {
      for (int column = 0; column < triangle.get(row).size(); column++) {
        dp[column] = Math.min(dp[column], dp[column + 1]) + triangle.get(row).get(column);
      }
    }

    return dp[0];
  }

  public int minimumTotal3(List<List<Integer>> triangle) {
    if (triangle == null || triangle.size() == 0) {
      return 0;
    }

    int rows = triangle.size();
    for (int row = rows - 2; row >= 0; row--) {
      for (int column = 0; column < triangle.get(row).size(); column++) {
        int temp = Math.min(triangle.get(rows - 1).get(column), triangle.get(rows - 1).get(column + 1)) + triangle.get(row).get(column);
        triangle.get(rows - 1).set(column, temp);
      }
    }

    return triangle.get(rows - 1).get(0);
  }

}
