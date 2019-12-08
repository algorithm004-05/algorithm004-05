## 搜索二维矩阵
class Solution:
    def searchMatrix(self, matrix: List[List[int]], target: int) -> bool:
        if len(matrix)==0 : return False
        rows = len(matrix)
        cols = len(matrix[0])
        length = rows*cols
        l = 0
        r = length
        while l < r:
            mid = (l+r) >> 1
            row = mid // cols
            col = mid%cols
            if matrix[row][col] > target:
                r = mid
            elif matrix[row][col] < target:
                l = mid + 1
            else:
                return True
        return False