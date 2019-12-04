package leetcode.jacf.tech;

import java.util.List;

/**
 * 120. 三角形最小路径和
 * https://leetcode-cn.com/problems/triangle/
 *
 * @author jacf
 * <p>
 * get minimum triangle using an integer array
 */
public class Triangle {
    int row;
    Integer[][] memo;

    public int minimumTotal(List<List<Integer>> triangle) {
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
}
