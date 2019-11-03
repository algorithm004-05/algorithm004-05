# 自己的思考的
# 暴力法：法一：遍历一次,对每个元素进行排序，判断在不在字典里面 O(nlogn)；法二：双指针：一次判断两个元素O(nlogn)
# 法一：O(NKlogK) 本质在于排序，类比leetcode242的先排序方法
class Solution:
    def groupAnagrams(self, strs: List[str]) -> List[List[str]]:
        _dict = {}
        for i in strs:
            j = tuple(sorted(i))  # tuple是关键
            if j not in _dict:
                _dict[j] = [i]
            else:
                _dict[j].append(i)
        res = []
        for lst in _dict.values():
            res.append(lst)
        return res
# 简洁代码
# 官方
class Solution(object):
    def groupAnagrams(self, strs):
        ans = collections.defaultdict(list)
        for s in strs:
            ans[tuple(sorted(s))].append(s)
        return ans.values()
# 国际友人
    def groupAnagrams(self, strs):
    d = {}
    for w in sorted(strs):
        key = tuple(sorted(w))
        d[key] = d.get(key, []) + [w]
    return d.values()

    def anagrams(self, strs):
        count = collections.Counter([tuple(sorted(s)) for s in strs])
        return filter(lambda x: count[tuple(sorted(x))]>1, strs)

# 法二：本质类似leetcode242的先判断字母次数 O(NK)


