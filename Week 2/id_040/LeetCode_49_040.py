#给定一个字符串数组，将字母异位词组合在一起。字母异位词指字母相同，但排列不同的字符串。
#
# 示例:
#
# 输入: ["eat", "tea", "tan", "ate", "nat", "bat"],
#输出:
#[
#  ["ate","eat","tea"],
#  ["nat","tan"],
#  ["bat"]
#]
#
# 说明：
#
#
# 所有输入均为小写字母。
# 不考虑答案输出的顺序。
#
# Related Topics 哈希表 字符串



#leetcode submit region begin(Prohibit modification and deletion)
class Solution:
    def groupAnagrams(self, strs: list) -> list:
        s_map = {}
        for i in range(len(strs)):
            s = strs[i]
            ss = str(sorted(s))

            if not s_map.get(ss):
                s_map[ss] = [s, ]
            else:
                s_map[ss].append(s)

        return [s for s in s_map.values()]

#leetcode submit region end(Prohibit modification and deletion)
if __name__ == '__main__':
    l = ["eat", "tea", "tan", "ate", "nat", "bat"]
    s= Solution()
    print(s.groupAnagrams(l))