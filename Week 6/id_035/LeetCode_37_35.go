package main

//编写一个程序，通过已填充的空格来解决数独问题。
//
// 一个数独的解法需遵循如下规则：
//
//
// 数字 1-9 在每一行只能出现一次。
// 数字 1-9 在每一列只能出现一次。
// 数字 1-9 在每一个以粗实线分隔的 3x3 宫内只能出现一次。
//
//
// 空白格用 '.' 表示。
//
//
//
// 一个数独。
//
//
//
// 答案被标成红色。
//
// Note:
//
//
// 给定的数独序列只包含数字 1-9 和字符 '.' 。
// 你可以假设给定的数独只有唯一解。
// 给定数独永远是 9x9 形式的。
//
// Related Topics 哈希表 回溯算法
/*
	思路1:回溯+DFS
	遍历整个棋盘、当遍历到为空的坐标时、将数字1到9都往里面放、判断是否合法
	如果不合法、放下一个数字、如果合法、递归找下一个空格、插入数字
*/
//leetcode submit region begin(Prohibit modification and deletion)
func solveSudoku(board [][]byte)  {
	solve_helper(board)
}

func solve_helper(board [][]byte) bool {
	// current logic
	for i := 0; i < len(board); i++ {
		for j := 0; j< len((board)[i]); j++ {
			if (board)[i][j] == '.' {
				for k := byte('1'); k <= byte('9'); k++ {
					if _isValidNum(board, i, j, k) {
						(board)[i][j] = byte(k)
						// drill down
						if solve_helper(board) {
							// terminal
							// 返回true说明此次DFS完成了一个解法
							return true
						}
						// reserve stats
						(board)[i][j] = '.'
					}
				}
				// 9个数字遍历完仍然没有找到合法的插入空格、返回false
				return false
			}
		}
	}

	return true
}

// 判断数字k是否能够插入当前board中形成有效的数独
func _isValidNum(board [][]byte,row, col int, k byte) bool {
	for i := 0; i < 9; i++ {
		// check row
		if board[i][col] != '.' && board[i][col] == byte(k) {
			return false
		}
		// check col
		if board[row][i] !='.' && board[row][i] == byte(k) {
			return false
		}
		// todo 难点  check bolck 对于任意坐标、找到其子数独块范围
		if board[3*(row / 3) + i / 3][3 * (col / 3) + i % 3] != '.' &&
			board[3*(row / 3) + i / 3][3 * (col / 3) + i % 3] == byte(k) {
			return false
		}
	}
	return true
}
//leetcode submit region end(Prohibit modification and deletion)
