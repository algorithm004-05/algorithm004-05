# @author:leacoder
# @des:  贪心 分发饼干


class Solution:
    def findContentChildren(self, g: List[int], s: List[int]) -> int:
        res = 0
        g.sort()
        s.sort()

        length_g = len(g)
        length_s = len(s)

        count_g = 0
        count_s = 0

        while count_g < length_g and count_s < length_s:
            if g[count_g] <= s[count_s]:
                # 可以满足胃口，把小饼干喂给小朋友
                res += 1
                count_g += 1
                count_s += 1
            else:   # 不满足胃口，饼干小了查看下一块小饼干
                count_s += 1
        return res