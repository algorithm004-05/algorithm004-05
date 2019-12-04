## 190. 颠倒二进制位

# 方法1
# class Solution:
#     # @param n, an integer
#     # @return an integer
#     def reverseBits(self, n):
#         m = bin(n)
#         length = len(m) - 2
#         arr = list(m)[:1:-1]
#         arr += ['0' for _ in range(32 - length)]
#         return int(''.join(arr), 2)

#方法2
class Solution:
    # @param n, an integer
    # @return an integer
    def reverseBits(self, n):
        ans = 0
        for i in range(32):
            ans = (ans << 1) + (n & 1)
            n >>= 1
        return ans