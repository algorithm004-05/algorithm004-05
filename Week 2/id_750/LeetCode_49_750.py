"""
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
from typing import List


class Solution:
    # 方法1：统计数量分类
    def groupAnagrams(self, strs: List[str]) -> List[List[str]]:
        if len(strs) == 0:
            return list()
        str_dict = collections.defaultdict(list)
        for i in strs:
            str_dict["".join(sorted(i))].append(i)
        return str_dict.values()


if __name__ == '__main__':
    solution = Solution()
    str_array = ["eat", "tea", "tan", "ate", "nat", "bat"]
    result = solution.groupAnagrams(str_array)
    print(result)