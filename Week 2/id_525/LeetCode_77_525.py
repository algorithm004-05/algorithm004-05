from typing import List


class Solution:
    def combine(self, n: int, k: int) -> List[List[int]]:
        result = []

        def helper(level, cur):
            if len(cur) == k:
                result.append(cur[:])
                return
            for i in range(level, n + 1):
                cur.append(i)
                helper(i + 1, cur)
                cur.pop()

        helper(1, [])
        return result
