"""
题目:
给定一个字符串数组，将字母异位词组合在一起。字母异位词指字母相同，但排列不同的字符串。
示例:
输入: ["eat", "tea", "tan", "ate", "nat", "bat"],
输出:
[
  ["ate","eat","tea"],
  ["nat","tan"],
  ["bat"]
]
说明：
所有输入均为小写字母。
不考虑答案输出的顺序。
"""
import collections

class Solution(object):
    def groupAnagrams0(self, strs):
        """
        :type strs: List[str]
        :rtype: List[List[str]]
        解题思路: 定义一个字典: key为字符串排序后的字符串; value为原始字符串
        """
        dict = {}

        for i in strs:
            sort_s = "".join((lambda x:(x.sort(),x)[1])(list(i)))
            
            if not dict:
                dict[sort_s] = [i]
            else:
                if sort_s in dict.keys():
                    dict[sort_s].append(i)
                else:
                    dict[sort_s] = [i]
        return dict.values()

    def groupAnagrams1(self, strs):
        """
        使用python的collections模块实现, 简化代码
        思路与groupAnagrams0 相同
        """
        # 初始化一个字典; 该字典的value为 list
        result_dict = collections.defaultdict(list)

        for s in strs:
            """
            注: 这里有一个小坑: 为什么dict的key类型为tuple?
                原因: dict/set 使用hash值进行索引,也即其要求欲存储的元素有可哈希的要求; 
                     list 不使用 hash 值进行索引，故其对所存储元素没有可哈希的要求
                     所以,Python不支持dict的key为list或dict类型，因为list和dict类型是unhashable
            """ 
            result_dict[tuple(sorted(s))].append(s)
        
        return result_dict.values()


def main():
    list_s = ["eat", "tea", "tan", "ate", "nat", "bat"]

    s = Solution()
    
    all_anagrams0 = s.groupAnagrams0(list_s)

    print(all_anagrams0)

    all_anagrams1 = s.groupAnagrams1(list_s)

    print(all_anagrams1)
     
    
if __name__ == '__main__':
    main()
