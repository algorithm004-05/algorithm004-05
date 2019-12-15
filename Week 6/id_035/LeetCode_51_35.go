package main

import "fmt"

//n 皇后问题研究的是如何将 n 个皇后放置在 n×n 的棋盘上，并且使皇后彼此之间不能相互攻击。
//
//
//
// 上图为 8 皇后问题的一种解法。
//
// 给定一个整数 n，返回所有不同的 n 皇后问题的解决方案。
//
// 每一种解法包含一个明确的 n 皇后问题的棋子放置方案，该方案中 'Q' 和 '.' 分别代表了皇后和空位。
//
// 示例:
//
// 输入: 4
//输出: [
// [".Q..",  // 解法 1
//  "...Q",
//  "Q...",
//  "..Q."],
//
// ["..Q.",  // 解法 2
//  "Q...",
//  "...Q",
//  ".Q.."]
//]
//解释: 4 皇后问题存在两个不同的解法。
//
// Related Topics 回溯算法

/*
	思路1:递归+剪枝
	核心思想:以8皇后为例
	8皇后放置在一个8*8的棋盘中、那么有如下特性
	每一层只能放一个皇后、每一列也只能放一个皇后、已放置皇后的行列及对角线不能再放其它皇后
	可以遍历第一层的每一列、放置皇后、填充其攻击区、然后进入下一层、采用同样的办法放置第二个皇后
	注意:怎么判断斜线攻击区、也就是对角线、根据数学上的主对角线和副对角线特点进行判断
	主对角线:每一条主对角线上、横纵坐标之差是相等的(0-0, 1-1, 2-2...)
	副对角线:每一条副对角线上、横纵坐标之和是相等的(0+1=1+0, 2+0=1+1+0+2)
	时间复杂度:O(n^3)、其中有n^2是在对结果进行字符串转换时所消耗的
*/
//leetcode submit region begin(Prohibit modification and deletion)
func solveNQueens(n int) [][]string {
	// 设定三个map、分别存储列、撇(副对角线)、捺(主对角线)
	m_col := make(map[int]bool)
	m_pie := make(map[int]bool)
	m_na := make(map[int]bool)

	area := make([][]int, n)
	for i := 0; i < n; i++ {
		area[i] = make([]int, n)
	}
	result := make([][]string, 0)
	_helper(0, n, m_col, m_pie, m_na, &result, area)
	return result
}

func _helper(row int, n int, m_col map[int]bool, m_pie map[int]bool, m_na map[int]bool, result *[][]string, area [][]int) {
	// terminal
	if row >= n {
		// 已经到了最后一行、将此次组成的棋盘追加到result中
		var s []string
		s = _area_to_string(area)
		*result = append(*result, s)
		return
	}
	// current logic
	for col := 0; col < n; col++ {
		if m_col[col] || m_pie[col+row] || m_na[row-col] {
			// 位于攻击范围
			continue
		}
		// 当前列可以放新的皇后
		area[row][ col] = 1
		// 指定攻击范围
		m_col[col] = true
		m_pie[row+col] = true
		m_na[row-col] = true
		// drill down
		_helper(row + 1, n, m_col, m_pie, m_na, result, area)
		// 完成一种放法、重置攻击范围
		// reserve(恢复状态)
		area[row][col] = 0
		m_col[col] = false
		m_pie[row+col] = false
		m_na[row-col] = false
	}
}

func _area_to_string(area [][]int) []string {
	result := make([]string, 0)
	for i := 0; i < len(area); i++ {
		s := ""
		for j := 0; j < len(area[i]); j++ {
			if area[i][j] == 0 {
				s += "."
			} else {
				s += "Q"
			}
		}
		result = append(result, s)
	}
	return result
}

//leetcode submit region end(Prohibit modification and deletion)
func main() {
	count := 0
	slice := solveNQueens(6)
	for _, s := range slice {
		count++
		fmt.Println(s, count)
	}
	fmt.Println(count)
}