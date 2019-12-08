# -*- coding:utf-8 -*-
class Solution:
    def hammingWeight_0(self, n: int) -> int:
        """
        利用python的bin函数,将整数转化为二进制;然后利用count函数,统计二进制数中1的个数
        时间复杂度: O(1)
        空间复杂度: O(1)
        :param n:
        :return:
        """
        return bin(n).count('1')

    def hammingWeight_1(self, n: int) -> int:
        """
        利用位运算.
        时间复杂度: O(1)
        空间复杂度: O(1)
        思路:
          1. 将传入的整数转化为二进制数
          2. 将二进制数与1的二进制数进行与运算
          3. 1的二进制数左移1位,重新进行与运算
          4. 重复上述步骤
        :param n:
        :return:
        """
        count = 0
        mark = 1
        for i in range(32):
            # 为什么判断条件是 !=0? 因为位运算的结果返回的是十进制数
            if n & mark != 0:
                count += 1
            # 每次判断一次,左移一位,同时将新值,付给mark. mark的值依次为:1->2->4->8->...
            mark <<= 1

        return count

    def hammingWeight_2(self, n: int) -> int:
        """
        手动循环
        时间复杂度: O(1)
        :param n:
        :return:
        """
        count = 0
        for i in bin(n):
            if i == '1':
                count += 1

        return count

    def hammingWeight_3(self, n: int) -> int:
        """
        利用 n & n-1.
        举例:
         n=70=>1000110
           69=>1000101 70&69=>1000100=>68 -> 消除了70里的末尾的1
         n=68=>1000100
           67=>1000011 68&67=>1000000=>64 -> 消除了70里的末尾的1
         知道n=0,则以为着所有的1都被消除
        :param n:
        :return:
        """
        count = 0
        while n != 0:
            n &= n - 1
            count += 1

        return count


s = Solution()
print(s.hammingWeight_0(5))
print(s.hammingWeight_1(5))
print(s.hammingWeight_2(5))
print(s.hammingWeight_3(5))
