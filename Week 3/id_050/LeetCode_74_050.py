class Solution(object):
    def searchMatrix(self, matrix, target):
        """
        :type matrix: List[List[int]]
        :type target: int
        :rtype: bool
        """
        if len(matrix) == 0:
            return False
            
        n, m = len(matrix), len(matrix[0])
        start, end = 0, n * m - 1
        while start + 1 < end:
            mid = start + (end - start) / 2
            x, y = mid // m, mid % m
            if matrix[x][y] < target:
                start = mid
            else:
                end = mid
        if m:
            x, y = start // m, start % m
            if matrix[x][y] == target:
                return True
        
            x, y = end // m, end % m
            if matrix[x][y] == target:
                return True
        
        return False
