
# 49. 字母异位词分组
class Solution:
    def groupAnagrams(self, strs: List[str]) -> List[List[str]]:
        # ans = collections.defaultdict(list)
        # for s in strs:
        #     ans[tuple(sorted(s))].append(s)
        # return ans.values()

        dicts={}
        for s in strs:
            if tuple(sorted(s)) in dicts:
                dicts[tuple(sorted(s))].append(s)
            else :
                dicts[tuple(sorted(s))]=[s]
        
        list_trans = []
        for key, value in dicts.items():
            list_trans.append(value)
        return list_trans        

        # return [ list_trans.append(value) for value in dicts.values()]   没有值