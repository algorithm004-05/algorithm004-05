# 找到字符串中所有字母异位词

class Solution:
    def findAnagrams(self, s: str, p: str) -> List[int]:
        ns, np = len(s), len(p)
        t = collections.Counter(s[: np])
        d = collections.Counter(p)
        ans = []
        for i in range(ns - np):
            if d == t:
                ans += [i]
            t[s[i + np]] += 1
            t[s[i]] -= 1
            if t[s[i]] == 0:
                t.pop(s[i])
        if d == t:
            ans += [ns - np]
        return ans