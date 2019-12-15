package main

import "fmt"

//给定一个二维网格和一个单词，找出该单词是否存在于网格中。
//
// 单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。同一个单元格内的字母不允许被重复使用。
//
// 示例:
//
// board =
//[
//  ['A','B','C','E'],
//  ['S','F','C','S'],
//  ['A','D','E','E']
//]
//
//给定 word = "ABCCED", 返回 true.
//给定 word = "SEE", 返回 true.
//给定 word = "ABCB", 返回 false.
// Related Topics 数组 回溯算法


/*
	思路1:深度优先+回溯
	为每一个坐标给定上下左右的四个方向、每找到一个字母的坐标、则向四个方向延伸、查找其下一个字母的匹配坐标、直到匹配成功或者遍历完网格
*/
//leetcode submit region begin(Prohibit modification and deletion)
// 方向
//var dx = []int{-1, 0, 1, 0}
//var dy = []int{0, 1, 0, -1}
func exist(board [][]byte, word string) bool {
	mem := make([][]int, len(board))
	for i := 0; i < len(board); i++ {
		mem[i] = make([]int, len(board[i]))
	}
	for i :=0; i < len(board); i++ {
		for j := 0; j < len(board[i]); j++ {
			if _helper(board, i, j, word, mem) {
				return true
			}
		}
	}
	return false
}

func _helper(board[][]byte, row, col int, word string, memory [][]int) bool {
	// 检查上下左右四个方向
	if row > len(board) - 1 || row < 0 ||
		col > len(board[row]) - 1 || col < 0 {
		return false
	}
	// terminal
	if len(word) == 0 {
		return false
	}
	w := word[0]
	// 找到了
	if w == board[row][col] && memory[row][col] == 0{
		if len(word) == 1 {
			return true
		}
		memory[row][col] = 1
		for k := 0; k < len(dx); k++ {
			next_row := row + dy[k]
			next_col := col + dx[k]
			if _helper(board, next_row, next_col, word[1:], memory) {
				return true
			}
		}
		// 每一轮找完、需要重置标记、否则如果当前轮没找到、但在下一轮可能通过当前轮中的部份
		// 坐标延伸到其它坐标找到情况、也会因为当前轮查找的坐标都已经标记导致找不到
		memory[row][col] = 0
	}
	return false
}
//leetcode submit region end(Prohibit modification and deletion)
func main() {
	board :=[][]byte{
		{'C', 'A', 'A'},
		{'A', 'A', 'A'},
		{'B', 'C', 'D'},
	}
	word := "AAAAABCDC"
	fmt.Println(exist(board, word))
}