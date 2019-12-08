package main

//给定一个三角形，找出自顶向下的最小路径和。每一步只能移动到下一行中相邻的结点上。
//
// 例如，给定三角形：
//
// [
//     [2],
//    [3,4],
//   [6,5,7],
//  [4,1,8,3]
//]
//
//
// 自顶向下的最小路径和为 11（即，2 + 3 + 5 + 1 = 11）。
//
// 说明：
//
// 如果你可以只使用 O(n) 的额外空间（n 为三角形的总行数）来解决这个问题，那么你的算法会很加分。
// Related Topics 数组 动态规划



//leetcode submit region begin(Prohibit modification and deletion)
/*
	思路1:动态规划、与不同路径和的题目一样、要求整个三角形中的最小路径和、
	可以用bottom up的方式进行推导
	时间复杂度:O(n^2)
*/
func minimumTotal(triangle [][]int) int {
	// 重复子问题:因为每一步只能移动到下一行中相邻的结点上、
	// 所以第i行到最后一行的最小路径和sum = min(triangle[i + 1][j], triangle[i + 1][j + 1]) + triangle[i][j]
	// 状态数组:一个二维数组、每个元素都表示该元素到最底层的最小路径和、可以直接通过triangle赋值进行初始化
	// DP方程:sum = min(triangle[i + 1][j], triangle[i + 1][j + 1]) + triangle[i][j]
	min_sum := triangle
	// 从倒数第二层开始循环
	for i := len(triangle) - 2; i >= 0; i-- {
		for j := 0; j < len(triangle[i]); j++ {
			min_sum[i][j] += _min(triangle[i + 1][j] , triangle[i + 1][j+1])
		}
	}

	return min_sum[0][0]
}

//func _min(pre int, aft int) int {
//	if pre > aft {
//		return aft
//	} else {
//		return pre
//	}
//}
//leetcode submit region end(Prohibit modification and deletion)
/*
	思路2:递归+记忆化搜索
*/
func minimumTotal2(triangle [][]int) int {
	// 初始化一个缓存
	lru_cache := make([][]int, len(triangle))
	for i := 0; i < len(triangle); i++ {
		lru_cache[i] = make([]int, len(triangle[i]))
	}
	return _helper(0, 0, triangle, lru_cache)
}


func _helper(row int, col int, triangle [][]int, lru_cache [][]int) int {
	// terminal
	if row > len(triangle) - 1 || col > len(triangle[row]) - 1 {
		return 0
	}
	// current logic
	if lru_cache[row][col] != 0 {
		return lru_cache[row][col]
	}

	// drill down
	left := _helper(row + 1, col, triangle, lru_cache)
	right := _helper(row + 1, col + 1, triangle, lru_cache)
	lru_cache[row][col] = _min(left, right) + triangle[row][col]
	return  lru_cache[row][col]
}
