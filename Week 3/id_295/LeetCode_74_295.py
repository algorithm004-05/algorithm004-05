# 编写一个高效的算法来判断 m x n 矩阵中，是否存在一个目标值。该矩阵具有如下特性：
#
# 每行中的整数从左到右按升序排列。
# 每行的第一个整数大于前一行的最后一个整数。
# 示例 1:
#
# 输入:
# matrix = [
#   [1,   3,  5,  7],
#   [10, 11, 16, 20],
#   [23, 30, 34, 50]
# ]
# target = 3
# 输出: true
# 示例 2:
#
# 输入:
# matrix = [
#   [1,   3,  5,  7],
#   [10, 11, 16, 20],
#   [23, 30, 34, 50]
# ]
# target = 13
# 输出: false
#
# 来源：力扣（LeetCode）
# 链接：https://leetcode-cn.com/problems/search-a-2d-matrix
# 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

from typing import List


class Solution:
    # 1. 暴力法
    def searchMatrix(self, matrix: List[List[int]], target: int) -> bool:
        concat = []
        for l in matrix:
            concat += l
        left = 0
        right = len(concat) - 1
        while left < right:
            mid = (left + right) / 2
            if concat[mid] == target:
                return True
            if concat[mid] < target:
                left = mid + 1
            else:
                right = mid - 1
        return False

    # 2. 将矩阵视为 一维有序数组
    def searchMatrix(self, matrix: List[List[int]], target: int) -> bool:
        m = len(matrix)
        if m == 0:
            return False
        n = len(matrix[0])
        left = 0
        right = m * n - 1

        while left <= right:
            mid = (left + right) // 2
            if target == matrix[mid // n][mid % n]:
                return True
            if target > matrix[mid // n][mid % n]:
                left = mid + 1
            else:
                right = mid - 1


if __name__ == '__main__':
    Solution().searchMatrix([[1, 3, 5, 7], [10, 11, 16, 20], [23, 30, 34, 50]], 3)
