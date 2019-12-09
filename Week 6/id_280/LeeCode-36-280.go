func isValidSudoku(board [][]byte) bool {
    rows := [9][9]bool{}
	cols := [9][9]bool{}
	grid := [9][9]bool{}

	for i := 0; i < 9; i++ {
		for j := 0; j < 9; j++ {
			if board[i][j] == 46 {
				continue
			}
			val := board[i][j] - 49

			if rows[i][val] || cols[j][val] || grid[i/3*3+j/3][val] {
				return false
			}

			rows[i][val] = true
			cols[j][val] = true
			grid[i/3*3+j/3][val] = true
		}
	}
	return true
}