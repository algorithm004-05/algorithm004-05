#给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的字母异位词。
#
# 示例 1:
#
# 输入: s = "anagram", t = "nagaram"
#输出: true
#
#
# 示例 2:
#
# 输入: s = "rat", t = "car"
#输出: false
#
# 说明:
#你可以假设字符串只包含小写字母。
#
# 进阶:
#如果输入字符串包含 unicode 字符怎么办？你能否调整你的解法来应对这种情况？
# Related Topics 排序 哈希表



#leetcode submit region begin(Prohibit modification and deletion)
class Solution:
    def isAnagram(self, s: str, t: str) -> bool:
        if len(s) != len(t):
            return False

        s_map = {}
        for i in s:
            if not s_map.get(i):
                s_map[i] = 1
            else:
                s_map[i] += 1

        t_map = {}
        for i in t:
            if not t_map.get(i):
                t_map[i] = 1
            else:
                t_map[i] += 1

        for i in t:
            if s_map.get(i) != t_map.get(i):
                return False

        return True

#leetcode submit region end(Prohibit modification and deletion)
if __name__ == '__main__':
    s = "anagram"
    t = "nagaram"

    solition = Solution()
    print(solition.isAnagram(s, t))