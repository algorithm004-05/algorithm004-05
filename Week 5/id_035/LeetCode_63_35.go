package main

import "fmt"

//一个机器人位于一个 m x n 网格的左上角 （起始点在下图中标记为“Start” ）。
//
// 机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为“Finish”）。
//
// 现在考虑网格中有障碍物。那么从左上角到右下角将会有多少条不同的路径？
//
//
//
// 网格中的障碍物和空位置分别用 1 和 0 来表示。
//
// 说明：m 和 n 的值均不超过 100。
//
// 示例 1:
//
// 输入:
//[
//  [0,0,0],
//  [0,1,0],
//  [0,0,0]
//]
//输出: 2
//解释:
//3x3 网格的正中间有一个障碍物。
//从左上角到右下角一共有 2 条不同的路径：
//1. 向右 -> 向右 -> 向下 -> 向下
//2. 向下 -> 向下 -> 向右 -> 向右
//
// Related Topics 数组 动态规划


/*
	与62思路大致相同、就是需要添加一个为0的判断
	采用bottom up的方式处理
	注意:因为有了障碍物、所以这里不能再单独判断边界
	时间复杂度:O(n^2)
*/
//leetcode submit region begin(Prohibit modification and deletion)
func uniquePathsWithObstacles(obstacleGrid [][]int) int {
	if len(obstacleGrid) == 0 || len(obstacleGrid[0]) == 0{
		return 0
	}
	result := make([][]int, len(obstacleGrid))
	for i := 0; i < len(result); i++ {
		result[i] = make([]int, len(obstacleGrid[i]))
	}

	for i := len(result) - 1; i >= 0; i-- {
		for j := len(result[i]) - 1; j >= 0; j-- {
			if obstacleGrid[i][j] == 1 {
				// 有障碍物
				result[i][j] = 0
			} else {
				// end
				if i == len(result) - 1 && j == len(result[i]) - 1 {
					result[i][j] = 1
					continue
				}
				// 下边界
				if i == len(result) - 1 && j != len(result[i]) - 1 {
					result[i][j] = result[i][j + 1]
					continue
				}
				// 右边界
				if i != len(result) - 1 && j == len(result[i]) - 1 {
					result[i][j] = result[i + 1][j]
					continue
				}
				result[i][j] = result[i + 1][j] + result[i][j + 1]
			}
		}
	}
	return result[0][0]
}
//leetcode submit region end(Prohibit modification and deletion)
/*
	思路2:递归
	todo 超时
*/

func uniquePathsWithObstacles2(obstacleGrid [][]int) int {
	if len(obstacleGrid) == 0 || len(obstacleGrid[0]) == 0 {
		return 0
	}
	// 判断单行或者单列
	if len(obstacleGrid) == 1 || len(obstacleGrid[0]) == 1 {
		for i := 0; i < len(obstacleGrid); i++ {
			for j := 0; j < len(obstacleGrid[i]); j++ {
				if obstacleGrid[i][j] == 1 {
					return 0
				}
			}
		}
		return 1
	}
	// 判断头部是否是障碍
	if obstacleGrid[0][0] == 1 {
		return 0
	}
	result := make([][]int, len(obstacleGrid))
	for i := 0; i < len(result); i++ {
		result[i] = make([]int, len(obstacleGrid[i]))
	}
	return _paths_with_obs(obstacleGrid, result, 0, 1) + _paths_with_obs(obstacleGrid, result, 1, 0)
}

func _paths_with_obs(obs [][]int, result [][]int, row int, col int) int {
	// terminal
	if row == len(obs) - 1 && col == len(obs[row]) - 1 {
		// end
		if obs[row][col] == 1 {
			return 0
		}
		return 1
	}
	// current logic
	if obs[row][col] == 1 {
		// 障碍物
		result[row][col] = 0
		return 0
	}
	// 检查该节点是否已经处理过
	if result[row][col] != 0 {
		return result[row][col]
	}
	// 下边界
	if row == len(obs) - 1 {
		return _paths_with_obs(obs, result, row, col + 1)
	}
	// 右边界
	if col == len(obs[row]) - 1 {
		return _paths_with_obs(obs, result, row + 1, col)
	}
	result[row][col] = _paths_with_obs(obs, result, row + 1, col) + _paths_with_obs(obs, result, row, col + 1)
	// drill down
	return result[row][col]
}

func main() {
	obs := [][]int{{0,0,0},{0,1,0},{0,0,0}}
	fmt.Println(uniquePathsWithObstacles2(obs))
}