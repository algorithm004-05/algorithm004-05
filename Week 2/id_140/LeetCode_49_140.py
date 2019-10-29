#
# @lc app=leetcode.cn id=49 lang=python3
#
# [49] 字母异位词分组
#

# @lc code=start
import collections
class Solution:
    def groupAnagrams(self, strs):
        tempdict = collections.defaultdict(list)
        for i in strs:
            key = sorted(i)
            tempdict[tuple(key)].append(i) # 只有tuple类型可以hash
        return tempdict.values()
if __name__ == '__main__':
	s = Solution()
	strs = ["eat", "tea", "tan", "ate", "nat", "bat"]
	print(s.groupAnagrams(strs))