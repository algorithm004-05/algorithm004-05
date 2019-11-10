74. 搜索二维矩阵
class Solution:
    def searchMatrix(self, matrix: List[List[int]], target: int) -> bool:
        m = len(matrix)
        if m == 0:
            return False
        n = len(matrix[0])
        
        left, right = 0, m * n - 1
        while left<=right:
            mid=left+(right-left)//2
            mid_ele=matrix[mid//n][mid%n]
            if mid_ele==target:
                return True
            else:
                if target<mid_ele:
                    right=mid-1
                else:
                    left=mid+1
        return False