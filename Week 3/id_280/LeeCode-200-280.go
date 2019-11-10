package main

import "fmt"

func main() {
	 
}

var dx = [4]int{-1, 1, 0, 0}
var dy = [4]int{0, 0, -1, 1}
var g [][]byte

func numIslands(grid [][]byte) int {
    islands := 0
	g = grid
	
	for i := 0; i < len(g); i++ {
		for j := 0; j < len(g[i]); j++ {
			if g[i][j] == '0' {
				continue
			}
			islands += sink(i, j) // 陆地
		}
	}
	return  islands
}

func sink(i int, j int) int { 
	if g[i][j] == '0' {
		return 0
	}

	g[i][j] = '0'

	for k := 0; k < len(dx); k++ {
		x, y := i + dx[k], j + dy[k]
		if x >= 0 && x < len(g) && y >= 0 && y < len(g[i]) {
			if g[x][y] == '0' {
				continue
			}
			sink(x, y)
		}
	}
	return 1
}