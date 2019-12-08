# -*- coding:utf-8 -*-
# 题目: 给定一个整数，编写一个函数来判断它是否是 2 的幂次方

class Solution:
    def isPowerOfTwo_0(self, n: int) -> bool:
        """
        笨办法.遍历二进制码.
        如果整数是2的幂次方,则其二进制数除了最高位是1,其余为都为0
        :param n:
        :return:
        """
        if n == 1:
            return True
        elif n == 0:
            return False
        else:
            c = 0
            for i in bin(n):
                # 为什么c<3? 因为bin转换后,会带ob
                if c < 3:
                    c += 1
                    continue
                else:
                    if i == '1':
                        return False
            return True

    def isPowerOfTwo_1(self, n: int) -> bool:
        """
        如果n是2的幂次方,则 n&n-1=0
        举例: 8=>100 7=>111  8&7=0
        :param n:
        :return:
        """
        # 可简化为 return n>0 and n&n-1==0
        if n > 0 and n & n - 1 == 0:
            return True
        else:
            return False

    def isPowerOfTwo_2(self, n: int) -> bool:
        """

        :param n:
        :return:
        """
        if n <= 0:
            return False
        else:
            while n != 0:
                if n & 1 != 0:
                    if n == 1:
                        return True
                    else:
                        return False
                n >>= 1


s = Solution()

print(s.isPowerOfTwo_0(4))
print(s.isPowerOfTwo_1(4))
print(s.isPowerOfTwo_2(4))
