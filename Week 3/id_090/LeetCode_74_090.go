package main

func main() {

}

func searchMatrix(matrix [][]int, target int) bool {
	rows := len(matrix)
	if rows == 0 {
		return false
	}
	cols := len(matrix[0])

	left, right := 0, rows*cols-1

	for left <= right {
		mid := left + (right-left)/2
		i := mid / cols
		j := mid % cols
		if matrix[i][j] == target {
			return true
		}

		if matrix[i][j] < target {
			left = mid + 1
		} else {
			right = mid - 1
		}
	}

	return false
}
