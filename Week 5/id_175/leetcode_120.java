package week5;

import java.util.List;

/**
 * @author shizeying
 * @date 2019/11/16 14:42
 * @description
 */
public class leetcode_120 {
  private int row;
  private Integer[][] memo;

  public int minimumTotal1(List<List<Integer>> triangle) {
    row = triangle.size();
    memo = new Integer[row][row];
    return helper(0, 0, triangle);
  }

  private int helper(int level, int c, List<List<Integer>> triangle) {
    if (memo[level][c] != null) {
      return memo[level][c];
    }
    if (level == row - 1) {
      return memo[level][c] = triangle.get(level).get(c);
    }
    int left = helper(level + 1, c, triangle);
    int right = helper(level + 1, c + 1, triangle);
    return memo[level][c] = Math.min(left, right) + triangle.get(level).get(c);
  }

  public int minimumTotal(List<List<Integer>> triangle) {
    int row = triangle.size();
    int[] minLen = new int[row + 1];
    for (int level = row - 1; level >= 0; level--) {
      for (int i = 0; i <= level; i++) {
        minLen[i] = Math.min(minLen[i], minLen[i + 1]) + triangle.get(level).get(i);
      }
    }
    return minLen[0];
  }
}
