class Solution:
    def findContentChildren(self, g: List[int], s: List[int]) -> int:
        g.sort()
        s.sort()
        greed_p = 0
        size_p = 0
        count = 0
        while greed_p < len(g) and size_p < len(s):
            if g[greed_p] <= s[size_p]:
                count += 1
                greed_p += 1
                size_p += 1
            elif g[greed_p] > s[size_p]:
                size_p += 1
        return count
