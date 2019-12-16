# @author:leacoder
# @des:  暴力求解 最长回文子串

'''
从最长字符串开始扫描（最长子串就是其本身）子串个数为 1，如果不是回文 子串长度-1，子串个数+1

子串长度  子串个数
	n		1
	n-1		2
	.		.
	.		.
	2		n-1
	1		n
'''
class Solution:
    def longestPalindrome(self, s: str) -> str:
        n = len(s)
        if 0 == n:
            return null
        for i in range(n): # i = 0 时为最长子串，长度n ；i = 1时 子串长度n-1子串个数2
            start = 0
            end = n - i # n-i 长度子串中，第一个子串的起始位置
            while end <= n:
                sub_string = s[start:end]	# 子串
                # 判断是否回文
                if self.is_palindromic_string(sub_string):
                    return sub_string
                # 遍历长度为 n-i 的所有子串
                start += 1
                end +=1

    def is_palindromic_string(self,s):
        return s == s[::-1]
		
# @author:leacoder
# @des:  动态规划 最长回文子串

class Solution:
    def longestPalindrome(self, s: str) -> str:
        size = len(s)
        if size < 2:
            return s

        # 至少是 1
        max_len = 1
        res = s[0]

        for i in range(size):
            palindrome_odd, odd_len = self.__center_spread(s, size, i, i)	#  奇数
            palindrome_even, even_len = self.__center_spread(s, size, i, i + 1)	# 偶数

            # 当前找到的最长回文子串
            cur_max_sub = palindrome_odd if odd_len >= even_len else palindrome_even
            if len(cur_max_sub) > max_len:
                max_len = len(cur_max_sub)
                res = cur_max_sub

        return res

    def __center_spread(self, s, size, left, right):
        """
        left = right 的时候，此时回文中心是一条线，回文串的长度是奇数
        right = left + 1 的时候，此时回文中心是任意一个字符，回文串的长度是偶数
        """
        i = left
        j = right

        while i >= 0 and j < size and s[i] == s[j]:
            i -= 1
            j += 1
        return s[i + 1:j], j - i - 1

