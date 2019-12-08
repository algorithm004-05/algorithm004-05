package main

func main() {

}

func dfs(grid [][]byte, x, y int) {
	if x < 0 || x >= len(grid) || y < 0 || y >= len(grid[0]) {
		return
	}
	if grid[x][y] == '1' {
		grid[x][y] = '2'
		dfs(grid, x+1, y)
		dfs(grid, x-1, y)
		dfs(grid, x, y+1)
		dfs(grid, x, y-1)
	}
}

func numIslands(grid [][]byte) int {
	if len(grid) == 0 {
		return 0
	}
	m, n := len(grid), len(grid[0])
	count := 0
	for i := 0; i < m; i++ {
		for j := 0; j < n; j++ {
			if grid[i][j] == '1' {
				count++
				dfs(grid, i, j)
			}
		}
	}
	return count
}
