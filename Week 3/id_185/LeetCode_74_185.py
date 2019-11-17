class Solution:
    def searchMatrix(self, matrix: List[List[int]], target: int) -> bool:
        # empty matrix
        if len(matrix) == 0 or len(matrix[0]) == 0: return False
        
        # find which line
        up, down = 0, len(matrix) - 1
        while up <= down:
            row_middle = (up + down) // 2
            if target < matrix[row_middle][0]: down = row_middle - 1
            elif target > matrix[row_middle][len(matrix[row_middle]) - 1]: up = row_middle + 1
            else:
                left, right = 0, len(matrix[row_middle]) - 1
                while left <= right:
                    col_middle = (left + right) // 2
                    if target == matrix[row_middle][col_middle]: return True
                    elif target < matrix[row_middle][col_middle]: right = col_middle - 1
                    else: left = col_middle + 1
                        
                return False
                
        return False
