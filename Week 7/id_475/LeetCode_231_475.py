# 2的幂
# 第一遍:2进制位有且仅有一个1，与leetcode191一些相似的地方
class Solution:
    def isPowerOfTwo(self, n: int) -> bool:
        return n != 0 and (n & (n-1) == 0)