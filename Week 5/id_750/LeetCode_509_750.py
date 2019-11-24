"""
斐波那契数，通常用 F(n) 表示，形成的序列称为斐波那契数列。该数列由 0 和 1 开始，后面的每一项数字都是前面两项数字的和。也就是：

F(0) = 0,   F(1) = 1
F(N) = F(N - 1) + F(N - 2), 其中 N > 1.
给定 N，计算 F(N)。

 

示例 1：

输入：2
输出：1
解释：F(2) = F(1) + F(0) = 1 + 0 = 1.
示例 2：

输入：3
输出：2
解释：F(3) = F(2) + F(1) = 1 + 1 = 2.
示例 3：

输入：4
输出：3
解释：F(4) = F(3) + F(2) = 2 + 1 = 3.
"""


class Solution:
    def __init__(self, N: int):
        self.memo = [0 for _ in range(n + 1)]

    def fib(self, N: int) -> int:
        if N <= 0:
            return 0
        elif N == 1:
            return 1
        if memo[N] == 0:
            memo[N] = self.fib(N - 1) + self.fib(N - 2)
        return memo[N]

    def fib2(self, N: int) -> int:
        if N <= 0:
            return 0
        elif N == 1:
            return 1
        a = [n for n in range(N + 1)]
        for i in range(2, N+1):
            a[i] = a[i - 1] + a[i - 2]
        return a[N]

    def fib3(self, N: int) -> int:
        if N <= 1:
            return N
        a, b = 0, 1
        while N > 1:
            sum = a + b
            a = b
            b = sum
            N -= 1
        return b


if __name__ == '__main__':
    n = 20
    memo = [0 for _ in range(n + 1)]
    solution = Solution(n)
    result = solution.fib3(n)

    print(result)
