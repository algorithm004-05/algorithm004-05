# time: Nklogk
class Solution(object):
    def groupAnagrams(self, strs):
        """
        :type strs: List[str]
        :rtype: List[List[str]]
        """
        dic = {}
        for _str in strs:
            sorted_str = ''.join(sorted(_str))
            dic[sorted_str] = dic.get(sorted_str, []) + [_str]
        return dic.values()

# time: Nk, but how much time does tuple() and ord() take?
class Solution(object):
    def groupAnagrams(self, strs):
        """
        :type strs: List[str]
        :rtype: List[List[str]]
        """
        dic = {}
        for _str in strs:
            cnt = [0] * 26
            for s in _str:
                cnt[ord(s) - ord('a')] += 1
            dic[tuple(cnt)] = dic.get(tuple(cnt), []) + [_str]
        return dic.values()
