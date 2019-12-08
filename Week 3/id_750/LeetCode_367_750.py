"""
给定一个正整数 num，编写一个函数，如果 num 是一个完全平方数，则返回 True，否则返回 False。

说明：不要使用任何内置的库函数，如  sqrt。

示例 1：

输入：16
输出：True
示例 2：

输入：14
输出：False
"""


class Solution:
    def isPerfectSquare(self, num: int) -> bool:
        left, right = 1, num
        while left < right:
            mid = (left + right) // 2
            if mid * mid < num:
                left = mid + 1
            else:
                right = mid
        return left * left == num


if __name__ == '__main__':
    solution = Solution()

    num = 13
    result = solution.isPerfectSquare(num)
    print(result)
