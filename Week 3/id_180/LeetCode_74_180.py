class Solution:
    def searchMatrix(self, matrix: List[List[int]], target: int) -> bool:
        if len(matrix) == 0 or len(matrix[0]) == 0:
            return False
        low = 0
        high = len(matrix) - 1
        line = -1
        while low <= high:
            mid = low + (high - low) // 2
            if matrix[mid][0] == target:
                return True
            elif matrix[mid][0] > target:
                high = mid - 1
            else:
                if mid == len(matrix) - 1 or matrix[mid + 1][0] > target:
                    line = mid
                    break
                else:
                    low = mid + 1
        if line == -1:
            return False
        left = 0
        right = len(matrix[line]) - 1
        while left <= right:
            mid = left + (right - left) // 2
            if matrix[line][mid] == target:
                return True
            elif matrix[line][mid] > target:
                right = mid - 1
            else:
                left = mid + 1
        return False

