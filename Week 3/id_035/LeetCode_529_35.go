package day31

import (
)

//让我们一起来玩扫雷游戏！
//
// 给定一个代表游戏板的二维字符矩阵。 'M' 代表一个未挖出的地雷，'E' 代表一个未挖出的空方块，'B' 代表没有相邻（上，下，左，右，和所有4个对角线）地雷的已挖出的空白方块，数字（'1' 到 '8'）表示有多少地雷与这块已挖出的方块相邻，'X' 则表示一个已挖出的地雷。
//
// 现在给出在所有未挖出的方块中（'M'或者'E'）的下一个点击位置（行和列索引），根据以下规则，返回相应位置被点击后对应的面板：
//
//
// 如果一个地雷（'M'）被挖出，游戏就结束了- 把它改为 'X'。
// 如果一个没有相邻地雷的空方块（'E'）被挖出，修改它为（'B'），并且所有和其相邻的方块都应该被递归地揭露。
// 如果一个至少与一个地雷相邻的空方块（'E'）被挖出，修改它为数字（'1'到'8'），表示相邻地雷的数量。
// 如果在此次点击中，若无更多方块可被揭露，则返回面板。
//
//
//
//
// 示例 1：
//
// 输入:
//
//[['E', 'E', 'E', 'E', 'E'],
// ['E', 'E', 'M', 'E', 'E'],
// ['E', 'E', 'E', 'E', 'E'],
// ['E', 'E', 'E', 'E', 'E']]
//
//Click : [3,0]
//
//输出:
//
//[['B', '1', 'E', '1', 'B'],
// ['B', '1', 'M', '1', 'B'],
// ['B', '1', '1', '1', 'B'],
// ['B', 'B', 'B', 'B', 'B']]
//
//解释:
//
//
//
// 示例 2：
//
// 输入:
//
//[['B', '1', 'E', '1', 'B'],
// ['B', '1', 'M', '1', 'B'],
// ['B', '1', '1', '1', 'B'],
// ['B', 'B', 'B', 'B', 'B']]
//
//Click : [1,2]
//
//输出:
//
//[['B', '1', 'E', '1', 'B'],
// ['B', '1', 'X', '1', 'B'],
// ['B', '1', '1', '1', 'B'],
// ['B', 'B', 'B', 'B', 'B']]
//
//解释:
//
//
//
//
//
// 注意：
//
//
// 输入矩阵的宽和高的范围为 [1,50]。
// 点击的位置只能是未被挖出的方块 ('M' 或者 'E')，这也意味着面板至少包含一个可点击的方块。
// 输入面板不会是游戏结束的状态（即有地雷已被挖出）。
// 简单起见，未提及的规则在这个问题中可被忽略。例如，当游戏结束时你不需要挖出所有地雷，考虑所有你可能赢得游戏或标记方块的情况。
// Related Topics 深度优先搜索 广度优先搜索


/*
	思路1:广度优先搜索(BFS)
	从click中的坐标i,j为根、找到其上下左右以及四个对角、遍历每一个格子、查看该格子上下左右及4个对角
	有多少颗雷
	注意边界
*/
// 指定一个方向列表
var dx = []int{1, 1, 0, -1, -1, -1, 0, 1}
var dy = []int{0, 1, 1, 1, 0, -1, -1, -1}
//leetcode submit region begin(Prohibit modification and deletion)
func updateBoard(board [][]byte, click []int) [][]byte {
	if len(click) != 2 {
		return nil
	}

	_update(board, click[0], click[1])
	return board
}

func _update(board [][]byte, i int, j int) {
	// 终止条件
	if string(board[i][j]) == "M" {
		board[i][j] = 'X'
		return
	}
	// 检查其周围8个点、是否包含地雷、包含地雷就改为地雷数量、否则改为B
	count := _getMineCounts(board, i, j)
	if count > 0 {
		board[i][j] = byte(count) + '0'
		return
	} else {
		board[i][j] = 'B'
	}

	for k := 0; k < len(dx); k++ {
		if i + dy[k] >= 0 && i + dy[k] < len(board) && j + dx[k] >= 0 && j + dx[k] < len(board[i]) && board[i + dy[k]][j + dx[k]] == 'E' {
			_update(board, i + dy[k], j + dx[k])
		}
	}

}
// 统计指定坐标的周围地雷数
func _getMineCounts(board [][]byte, i int, j int) int {
	count := 0
	for k := 0; k < len(dx); k++ {
		// 不能超出边界
		if i + dy[k] >= 0 && i + dy[k] < len(board) && j + dx[k] >= 0 && j + dx[k] < len(board[i]) && board[i + dy[k]][j + dx[k]] == 'M' {
			count++
		}
	}
	return count
}
//leetcode submit region end(Prohibit modification and deletion)
