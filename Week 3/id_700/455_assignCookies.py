# 假设你是一位很棒的家长，想要给你的孩子们一些小饼干。但是，每个孩子最多只能给一块饼干。对每个孩子 i ，
# 都有一个胃口值 gi ，这是能让孩子们满足胃口的饼干的最小尺寸；并且每块饼干 j ，都有一个尺寸 sj 。
# 如果 sj >= gi ，我们可以将这个饼干 j 分配给孩子 i ，这个孩子会得到满足。你的目标是尽可能满足越多数量的孩子，并输出这个最大数值。
#
# 注意：
#
# 你可以假设胃口值为正。
# 一个小朋友最多只能拥有一块饼干。
#
# 示例 1:
#
# 来源：力扣（LeetCode）
# 链接：https://leetcode-cn.com/problems/assign-cookies
# 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

class Solution:
    def findContentChildren(self, g: List[int], s: List[int]) -> int:
        count = 0
        g.sort()
        s.sort()
        for i in range(len(g)):
            for j in range(len(s)):
                if s[j] >= g[i]:
                    count += 1
        return count
####  出现错误的原因在于重复计算




# 根据jalan代码修改,双指针法

class Solution(object):
    def findContentChildren(self, g, s):
        count = 0
        g.sort()
        s.sort()
        i = 0
        j = 0
        while i <len(g) and j < len(s):
            if s[j] >= g[i]:
                count += 1
                i += 1
                j += 1
            else: j += 1
        return count
