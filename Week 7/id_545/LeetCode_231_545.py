## 231. 2的幂

# 方法1
# class Solution:
#     def isPowerOfTwo(self, n: int) -> bool:
#         if n <= 0: return False
#         while n>1:
#             if n&1 != 0:
#                 return False
#             n >>= 1
#         return True

# 方法2
class Solution:
    def isPowerOfTwo(self, n: int) -> bool:
        return False if n <= 0 or n & (n - 1) else True