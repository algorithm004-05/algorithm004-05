#题目
#给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的字母异位词。
#示例 1:
#输入: s = "anagram", t = "nagaram"
#输出: true
#示例 2:
#输入: s = "rat", t = "car"
#输出: false
#说明:
#你可以假设字符串只包含小写字母。

import operator
import collections

class Solution0(object):
    # 对字符串排序, 对比排序后的字符串是否相同
    def isAnagram0(self, s, t):
        """
        :type s: str
        :type t: str
        :rtype: bool
        """
        # 如果两个字符串长度不等,则直接返回False
        if len(s) != len(t):
            return False

        # 对list排序
        sort_s = "".join((lambda x:(x.sort(),x)[1])(list(s)))
        sort_t = "".join((lambda x:(x.sort(),x)[1])(list(t)))

        # 判断列表是否相同
        return operator.eq(sort_s, sort_t)
    
    # 使用python的内置函数, 统计每个字符出现的次数
    def isAnagram1(self, s, t):
        """
        leetcode 优秀代码
        collections.counter: 提供了可哈希对象的计数功能
            >>> collections.Counter(s)
                Counter({'a': 1, 'c': 1, 'b': 1})
            >>> collections.Counter(t)
                Counter({'a': 1, 'c': 1, 'b': 1})
        """
        return collections.Counter(s) == collections.Counter(t)

    # 利用hash表
    def isAnagram2(self, s, t):
        """
        解题思路: 
          1. 初始化一个包含26个元素的列表,所有元素都为0
          2. 遍历字符串s, 列表中对应的元素加1
          3. 遍历字符串t, 列表中对应的元素减1
          4. 如果列表中的所有元素都为0,则s和t为异位词
        """
        # 如果s和t的长度不一致, 则直接返回False
        if len(s) != len(t):
            return False

        # 初始化一个长度为26的列表; 所有元素均为0
        dict = [0]*26
        
        # 遍历s和t, 并对dict进行操作
        for si in s:
            dict[ord(si) - ord('a')] += 1
        
        for ti in t:
            dict[ord(ti) - ord('a')] -= 1

        for i in dict:
            if i != 0:
                return False
        return True

def main():
    s = "anagram"
    t = "nagaram"

    s1 = "car"
    t1 = "rat"
    
    print(len(s1))
    s0 = Solution0()

    is_anagram0 =  s0.isAnagram0(s, t)
    print(is_anagram0) 

    is_anagram1 =  s0.isAnagram0(s1, t1)
    print(is_anagram1)
  
    is_anagram2 = s0.isAnagram2(s, t)
    print(is_anagram2)

    is_anagram3 = s0.isAnagram2(s1, t1)
    print(is_anagram3)

if __name__ == "__main__":
    main()