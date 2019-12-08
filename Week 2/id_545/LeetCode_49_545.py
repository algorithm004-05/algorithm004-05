## 49. 字母异位词分组

# 哈希
class Solution:
    def groupAnagrams(self, strs: List[str]) -> List[List[str]]:
        dct = collections.defaultdict(list)
        for word in strs:
            dct[tuple(sorted(word))].append(word)
        return dct.values()