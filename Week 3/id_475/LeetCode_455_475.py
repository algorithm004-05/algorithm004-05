# 分发饼干
# 第一遍：贪心算法
class Solution(object):
    def findContentChildren(self, g, s):
        """
        :type g: List[int]
        :type s: List[int]
        :rtype: int
        """
        res = 0
        g.sort()
        s.sort()
        
        g_length = len(g)
        s_length = len(s)
        
        i = 0
        j = 0
        while i < g_length and j < s_length:
            if g[i] <= s[j]:
                # 可以满足胃口，把小饼干喂给小朋友
                res += 1
                i += 1
                j += 1
            else:
                # 不满足胃口，查看下一块小饼干
                j += 1
                
        return res
