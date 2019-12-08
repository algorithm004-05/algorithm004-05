#
# @lc app=leetcode.cn id=49 lang=python3
#
# [49] 字母异位词分组
#

# @lc code=start
class Solution:
    # solution 1
    # def groupAnagrams(self, strs: List[str]) -> List[List[str]]:
    #     dic=collections.defaultdict(list)
    #     for s in strs:
    #         dic[tuple(sorted(s))].append(s)
    #     return dic.values()
    #solution fastest
    def groupAnagrams(self, strs: List[str]) -> List[List[str]]:
        dic=collections.defaultdict(list)

        for s in strs:
            count =[0]*26
            for c in s:
                count[ord(c)-97]+=1
            dic[tuple(count)].append(s)
        return dic.values()

# @lc code=end

