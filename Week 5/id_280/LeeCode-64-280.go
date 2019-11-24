package main

import "fmt"

func main() {
	var grid [][]int
	a1, a2, a3 := []int{1,3,1}, []int{1,5,1}, []int{4,2,1}
	grid = append(grid, a1, a2, a3)

	fmt.Println(minPathSum(grid))
}

func minPathSum(grid [][]int) int {
	var m int = len(grid)
	var n int = len(grid[0])
	for i := 1; i < m; i++{
		grid[i][0] += grid[i-1][0];
	}
	for j := 1; j < n; j++{
		grid[0][j] += grid[0][j-1];
	}
	for i:= 1; i < m; i++{
		for j:=1; j<n; j++{
			grid[i][j] += min(grid[i-1][j], grid[i][j-1]);
		}
	}
	return grid[m-1][n-1];
}

func min(a, b int) int {
	if a < b {
		return a
	}
	return b
}