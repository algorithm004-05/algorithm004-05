package day30

//给定一个由 '1'（陆地）和 '0'（水）组成的的二维网格，计算岛屿的数量。一个岛被水包围，并且它是通过水平方向或垂直方向上相邻的陆地连接而成的。你可以假设网格的四个边均被水包围。
//
// 示例 1:
//
// 输入:
//11110
//11010
//11000
//00000
//
//输出: 1
//
//
// 示例 2:
//
// 输入:
//11000
//11000
//00100
//00011
//
//输出: 3
//
// Related Topics 深度优先搜索 广度优先搜索 并查集

//leetcode submit region begin(Prohibit modification and deletion)
/*
	思路1:深度优先搜索、1代表陆地、我们可以遍历整个二维数组、只要遇到1、将其变成0
	同时将1相邻的1都变成0、每操作一次、就代表我们发现了一个岛、最终我们的操作次数就是岛的数量
*/
// 当前坐标的上下左右移动方向
var dx = []int{-1, 0, 1, 0}
var dy = []int{0, -1, 0, 1}

func numIslands(grid [][]byte) int {
	islands := 0
	for i := 0; i < len(grid); i++ {
		for j := 0; j < len(grid[i]); j++ {
			if string(grid[i][j]) == "1" {
				// 以当前节点为根、启动深度优先搜索
				islands += _helper(grid, i, j)
			}
		}
	}
	return islands
}

// 以grid[i][j]为根进行深度优先搜索
func _helper(grid [][]byte, i int, j int) int {
	// terminal
	if string(grid[i][j]) == "0" {
		return 0
	}
	// current level logic
	// 将当前元素变成0
	grid[i][j] = 48
	// 判断当前元素的相邻上下左右是否为1
	for k := 0; k < len(dx); k++ {
		x := j + dx[k]
		y := i + dy[k]
		//
		if x >= 0 && x < len(grid[i]) && y >= 0 && y < len(grid) && string(grid[y][x]) == "1" {
			// drill down 某个方向值为1则以该方向为根再进行深度优先
			_helper(grid, y, x)
		}
	}
	return 1
}