# @author:leacoder
# @des: 哈希表 字母异位词分组

class Solution:
    def groupAnagrams(self, strs: List[str]) -> List[List[str]]:
        datamap = {}
        for s in strs:
            key = str(sorted(s))
            datamap[key] = datamap.get(key,[]) + [s]
        return list(datamap.values())