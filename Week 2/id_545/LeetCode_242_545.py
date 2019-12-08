## 242. 有效的字母异位词

# 排序 比较是否相等
# class Solution:
#     def isAnagram(self, s: str, t: str) -> bool:
#         return sorted(s) == sorted(t)

# 哈希表
# class Solution:
#     def isAnagram(self, s: str, t: str) -> bool:
#         if len(s) != len(t): return False
#         dct = {}
#         for i in s:
#             dct[i] = dct.get(i, 0) + 1
#         for j in t:
#             dct[j] = dct.get(j, 0) - 1
#             if dct[j] < 0: return False
#         return True

# 集合
class Solution:
    def isAnagram(self, s: str, t: str) -> bool:
        t_set = set(t)
        if len(s) != len(t) or t_set != set(s): return False
        for i in t_set:
            if s.count(i) != t.count(i):
                return False
        return True