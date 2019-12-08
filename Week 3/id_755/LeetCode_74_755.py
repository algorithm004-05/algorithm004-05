class Solution:
    def searchMatrix(self, matrix: List[List[int]], target: int) -> bool:
        num_row = len(matrix)
        if num_row != 0:
            num_col = len(matrix[0])
        r = num_row - 1
        c = 0
        while 0 <= r < num_row and 0 <= c < num_col:
            if matrix[r][c] == target:
                return True
            elif matrix[r][c] < target:
                c += 1
            elif matrix[r][c] > target:
                r -= 1
        return False
