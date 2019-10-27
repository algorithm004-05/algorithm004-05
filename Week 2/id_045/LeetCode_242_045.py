# @author:leacoder
# @des:  排序法 有效的字母异位词
# 时间复杂度 O(NlogN)
class Solution:
    def isAnagram(self, s: str, t: str) -> bool:
        return sorted(s) == sorted(t)
        

# @author:leacoder
# @des:  使用map 计算 有效的字母异位词
# 时间复杂度 O(N)
class Solution:
    def isAnagram(self, s: str, t: str) -> bool:
        dic1,dic2 = {},{}
        for item in s:
            dic1[item] = dic1.get(item,0) + 1  #dic.get(key, default=None)    #返回指定键的值，如果值不在字典中返回default值
        for item in t:
            dic2[item] = dic2.get(item,0) + 1
        return dic1==dic2
            