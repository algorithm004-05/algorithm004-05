package main

import "fmt"

//给定一个包含非负整数的 m x n 网格，请找出一条从左上角到右下角的路径，使得路径上的数字总和为最小。
//
// 说明：每次只能向下或者向右移动一步。
//
// 示例:
//
// 输入:
//[
//  [1,3,1],
//  [1,5,1],
//  [4,2,1]
//]
//输出: 7
//解释: 因为路径 1→3→1→1→1 的总和最小。
//
// Related Topics 数组 动态规划

/*
	思路1:动态规划
	基本思路:从起点到坐标grid[i][j]的最小路径和应该为min(grid[i - 1][j],grid[i][j - 1]) + grid[i][j]
	sub problem: f(i, j) = min(f(i - 1, j), f(i, j - 1)) + grid[i][j]
	dp array: 存储起点到当前位置的最小路径和
	dp equation: grid[i][j] = min(grid[i - 1][j],grid[i][j - 1]) + grid[i][j]
	时间复杂度:O(n^2)
*/

//leetcode submit region begin(Prohibit modification and deletion)
func minPathSum(grid [][]int) int {
	if len(grid) == 0 || len(grid[0]) == 0 {
		return 0
	}
	dp := grid
	dp[0][0] = grid[0][0]
	// 初始化上边界和左边界
	for i := 1; i < len(grid[0]); i++ {
		dp[0][i] = dp[0][i - 1] + grid[0][i]
	}
	for j := 1; j < len(grid); j++ {
		dp[j][0] = dp[j - 1][0] + grid[j][0]
	}
	for i := 1; i < len(grid); i++ {
		for j := 1; j < len(grid[0]); j++ {
			dp[i][j] = _min_path(dp[i - 1][j], dp[i][j - 1]) + grid[i][j]
		}
	}
	return dp[len(dp) - 1][len(dp[0]) - 1]
}
func _min_path(pre int, aft int) int {
	if pre > aft {
		return aft
	} else {
		return pre
	}
}
//leetcode submit region end(Prohibit modification and deletion)

func main() {
	dp :=[][]int{{1,3,1},{1,5,1},{4,2,1}}
	fmt.Println(minPathSum(dp))
}