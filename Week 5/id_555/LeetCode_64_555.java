package lsn12_dynamic_programming;

import java.util.Arrays;

/**
 * 64. 最小路径和
 * 
 * https://leetcode-cn.com/problems/minimum-path-sum/
 */
public class LeetCode_64_555 {
	public static void main(String[] args) {
		LeetCode_64_555 leetcode = new LeetCode_64_555();
		int[][] grid = { { 1, 3, 1 }, { 1, 5, 1 }, { 4, 2, 1 } };
		for (int i = 0; i < grid.length; i++) {
			System.out.println(Arrays.toString(grid[i]));
		}

		System.out.println(leetcode.minPathSum(grid));
		System.out.println(leetcode.minPathSum2(grid));
		System.out.println(leetcode.minPathSum3(grid));

	}

	/**
	 * 不需要额外存储空间
	 */
	public int minPathSum3(int[][] grid) {
		for (int i = grid.length - 1; i >= 0; i--) {
			for (int j = grid[0].length - 1; j >= 0; j--) {
				if (i == grid.length - 1 && j != grid[0].length - 1)
					grid[i][j] = grid[i][j] + grid[i][j + 1];
				else if (j == grid[0].length - 1 && i != grid.length - 1)
					grid[i][j] = grid[i][j] + grid[i + 1][j];
				else if (j != grid[0].length - 1 && i != grid.length - 1)
					grid[i][j] = grid[i][j] + Math.min(grid[i + 1][j], grid[i][j + 1]);
			}
		}
		return grid[0][0];
	}

	/**
	 * 一维动态规划
	 */
	public int minPathSum2(int[][] grid) {
		int[] dp = new int[grid[0].length];
		for (int i = grid.length - 1; i >= 0; i--) {
			for (int j = grid[0].length - 1; j >= 0; j--) {
				if (i == grid.length - 1 && j != grid[0].length - 1)
					dp[j] = grid[i][j] + dp[j + 1];
				else if (j == grid[0].length - 1 && i != grid.length - 1)
					dp[j] = grid[i][j] + dp[j];
				else if (j != grid[0].length - 1 && i != grid.length - 1)
					dp[j] = grid[i][j] + Math.min(dp[j], dp[j + 1]);
				else
					dp[j] = grid[i][j];
			}
		}
		return dp[0];
	}

	/**
	 * 二维动态规划
	 */
	public int minPathSum(int[][] grid) {
		int[][] dp = new int[grid.length][grid[0].length];
		for (int i = grid.length - 1; i >= 0; i--) {
			for (int j = grid[0].length - 1; j >= 0; j--) {
				if (i == grid.length - 1 && j != grid[0].length - 1)
					dp[i][j] = grid[i][j] + dp[i][j + 1];
				else if (j == grid[0].length - 1 && i != grid.length - 1)
					dp[i][j] = grid[i][j] + dp[i + 1][j];
				else if (j != grid[0].length - 1 && i != grid.length - 1)
					dp[i][j] = grid[i][j] + Math.min(dp[i + 1][j], dp[i][j + 1]);
				else
					dp[i][j] = grid[i][j];
			}
		}
		return dp[0][0];
	}

}
