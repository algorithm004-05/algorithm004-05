package leetcode

func isValidSudoku(board [][]byte) bool {
	var row [9][10]bool
	var cow [9][10]bool
	var block [9][10]bool
	for i := 0; i < 9; i++ {
		for j := 0; j < 9; j++ {
			var index = i/3*3 + j/3
			if board[i][j] != '.' {
				var tmp = board[i][j] - '0'
				if row[i][tmp] {
					return false
				} else {
					row[i][tmp] = true
				}
				if cow[j][tmp] {
					return false
				} else {
					cow[j][tmp] = true
				}
				if block[index][tmp] {
					return false
				} else {
					block[index][tmp] = true
				}

			}
		}

	}
	return true
}
