"""
给出 n 代表生成括号的对数，请你写出一个函数，使其能够生成所有可能的并且有效的括号组合。

例如，给出 n = 3，生成结果为：

[
  "((()))",
  "(()())",
  "(())()",
  "()(())",
  "()()()"
]
"""
from typing import List


class Solution:
    def __init__(self):
        self.result = []

    def generateParenthesis(self, n: int) -> List[str]:
        left, right = 0, 0
        s = ""
        self.generate(left, right, n, s)
        return self.result

    def generate(self, left, right, n, s):
        if left == n and right == n:
            self.result.append(s)
            return
        if left < n:
            self.generate(left + 1, right, n, s + "(")
        if left > right:
            self.generate(left, right + 1, n, s + ")")


if __name__ == '__main__':
    solution = Solution()
    n = 3
    result = solution.generateParenthesis(n)

    print(result)
