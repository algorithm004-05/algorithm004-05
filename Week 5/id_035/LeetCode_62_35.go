package main

import "fmt"

//一个机器人位于一个 m x n 网格的左上角 （起始点在下图中标记为“Start” ）。
//
// 机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为“Finish”）。
//
// 问总共有多少条不同的路径？
//
//
//
// 例如，上图是一个7 x 3 的网格。有多少可能的路径？
//
// 说明：m 和 n 的值均不超过 100。
//
// 示例 1:
//
// 输入: m = 3, n = 2
//输出: 3
//解释:
//从左上角开始，总共有 3 条路径可以到达右下角。
//1. 向右 -> 向右 -> 向下
//2. 向右 -> 向下 -> 向右
//3. 向下 -> 向右 -> 向右
//
//
// 示例 2:
//
// 输入: m = 7, n = 3
//输出: 28
// Related Topics 数组 动态规划



//leetcode submit region begin(Prohibit modification and deletion)
/*
	思路1:bottom up
	自底向上、由于每个格子只能向右或者向下、
	所以每个格子最多有两种走法、可以从右下角的终点开始推导、
	看看终点格子的上方格子和左方格子走到终点有多少种走法、
	然后重复推导、可以发现任何一个坐标的格子到end的走法都是它
	右边格子到end的走法+下方格子到end的走法
	时间复杂度:O(n^2)
*/
func uniquePaths(m int, n int) int {
	if m == 0 || n == 0 {
		return 0
	}
	array := make([][]int,m)
	for i := 0; i < m; i++ {
		array[i] = make([]int, n)
	}
	//fmt.Println(array)
	for i := m - 1; i >= 0; i-- {
		for j := n - 1; j >= 0; j-- {
			if i + 1 == m || j + 1 == n{
				// 所有边界节点都只有1种走法
				array[i][j] = 1
			} else {
				array[i][j] = array[i + 1][j] + array[i][j + 1]
			}
		}
	}
	return array[0][0]
}
//leetcode submit region end(Prohibit modification and deletion)
/*
	思路2:top down
	自顶向下:每个格子只能向右或者向下、所以第一个格子到最后一个格子的走法应该是
	其右边的格子right->end的走法+下面的格子down->end的走法、所以、可以采用分治的方法处理
	注意:不要使用傻递归
*/
func uniquePaths2(m int, n int) int {
	if m == 0 || n == 0 {
		return 0
	}
	// 只有一行或只有一列、走法只有一种
	if m == 1 || n == 1 {
		return 1
	}
	array := make([][]int,m)

	for i := 0; i < m; i++ {
		array[i] = make([]int, n)
	}
	return _paths(array, 0, 1) + _paths(array, 1, 0)
}

func _paths(array [][]int, row int, col int) int {
	// terminal
	if row >= len(array) || col >= len(array[row]) {
		return 0
	}
	// current logic

	// 下边界
	if row == len(array) - 1 {
		array[row][col] = 1
		return 1
	}
	// 右边界
	if col == len(array[row]) - 1 {
		array[row][col] = 1
		return 1
	}

	// 判断该坐标是否已经计算过、
	// 如果已经计算过、直接返回
	if array[row][col] != 0 {
		return array[row][col]
	}
	array[row][col] = _paths(array, row, col + 1) + _paths(array, row + 1, col)
	// drill down
	return array[row][col]
}

/*
	思路3:思路2优化(反向推导)
	不使用递归、直接双重循环
*/
func uniquePaths3(m int, n int) int {
	array := make([][]int, m)
	// 确定边界值
	for i := 0; i < m; i++ {
		// 每一列初始化
		array[i] = make([]int, n)
		array[i][0] = 1
	}
	for i := 0; i < n; i++ {
		array[0][i] = 1
	}
	// 计算非边界的任意一个点的值
	for row := 1; row < m; row++ {
		for col := 1; col < n; col++ {
			array[row][col] = array[row - 1][col] + array[row][col - 1]
		}
	}
	return array[m - 1][n - 1]
}
func main() {
	fmt.Println(uniquePaths3(1, 1))
}